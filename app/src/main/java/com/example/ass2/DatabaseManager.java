package com.example.ass2;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseManager {
    public static final String DB_NAME = "Friends";
    public static final String DB_TABLE = "friends";
    public static final int DB_VERSION = 1;

    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (f_id INTEGER, first_name TEXT, last_name TEXT, gender TEXT, age INTEGER, address TEXT);";

    private SQLHelper helper;
    private SQLiteDatabase db;
    private Context context;

    public DatabaseManager(Context c) {
        this.context = c;
        helper = new SQLHelper(c);
        this.db = helper.getWritableDatabase();
    }

    public DatabaseManager openReadable() throws android.database.SQLException {
        helper = new SQLHelper(context);
        db = helper.getReadableDatabase();
        return this;
    }

    public void close() {
        helper.close();
    }

    public boolean addRow(Integer id, String fn, String ln, String g, Integer a, String ad) {
        synchronized(this.db) {

            ContentValues newFriend = new ContentValues();
            newFriend.put("f_id", id);
            newFriend.put("first_name", fn);
            newFriend.put("last_name", ln);
            newFriend.put("gender", g);
            newFriend.put("age", a);
            newFriend.put("address", ad);

            try {
                db.insertOrThrow(DB_TABLE, null, newFriend);
            } catch (Exception e) {
                Log.e("Error in inserting rows", e.toString());
                e.printStackTrace();
                return false;
            }
            //db.close();
            return true;
        }
    }

    public ArrayList<String> retrieveRows() {
        ArrayList<String> friendRows = new ArrayList<String>();
        String[] columns = new String[] {"f_id", "first_name", "last_name", "gender", "age", "address"};
        Cursor cursor = db.query(DB_TABLE, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {

            friendRows.add(
                    Integer.toString(cursor.getInt(0)) + ", " +
                    cursor.getString(1) + ", " +
                    cursor.getString(2) + ", " +
                    cursor.getString(3) + ", " +
                    Integer.toString(cursor.getInt(4)) + ", " +
                    cursor.getString(5)
            );

            cursor.moveToNext();
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return friendRows;
    }

    public void clearRecords()
    {
        db = helper.getWritableDatabase();
        db.delete(DB_TABLE, null, null);
    }

    public class SQLHelper extends SQLiteOpenHelper {
        public SQLHelper (Context c) {
            super(c, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("Friends Table", "Upgrading database");
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }
}
