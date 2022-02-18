package com.example.testdevmobile;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.testdevmobile.Models.ItemEpicerie;

import java.util.ArrayList;
//https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
public class EpicerieAdapter extends RecyclerView.Adapter<EpicerieAdapter.ViewHolder> {
    ArrayList<ItemEpicerie> listeEpicerie = new ArrayList<ItemEpicerie>();
    private LayoutInflater inflater;

    EpicerieAdapter(Context context, ArrayList list){
        this.inflater = LayoutInflater.from(context);
        this.listeEpicerie = list;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view.
        View view = inflater.inflate(R.layout.protoype_epicerie, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.description.setText(listeEpicerie.get(position).getDescriptionItem());
        viewHolder.title.setText(listeEpicerie.get(position).getNomItem());

    }

    @Override
    public int getItemCount() {
        return listeEpicerie.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.nom_item);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }

}