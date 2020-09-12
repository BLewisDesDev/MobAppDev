package com.example.ass2.ui.taskList;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import com.example.ass2.R;
        import com.example.ass2.Task;

        import java.util.ArrayList;

public class taskAdapter extends ArrayAdapter<Task> {
    public taskAdapter(Context context, ArrayList<Task> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Task task = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_task, parent, false);
        }

        // Lookup view for data population
        TextView tName = (TextView) convertView.findViewById(R.id.t_name);
        TextView location = (TextView) convertView.findViewById(R.id.t_location);

        // Populate the data into the template view using the data object
        tName.setText(task.getTaskName());
        location.setText(task.getLocation());

        // Return the completed view to render on screen
        return convertView;
    }
}