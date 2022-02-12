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
    private void populateList(){
        for (int i =0; i<1000000; i++){
            listeEpicerie.add(new ItemEpicerie("pormme", "ses bons quand ses pas trop surett"));
        }
    }
    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view.
        View view = inflater.inflate(R.layout.activity_epicerie, parent, false);
        return new ViewHolder(view);

    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextView().setText(listeEpicerie.get(position).getDescriptionItem());
    }

    @Override
    public int getItemCount() {
        return listeEpicerie.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.nom_item);
        }

        public TextView getTextView() {
            return textView;
        }

        public TextView setTextView(TextView textView) {
            return this.textView=textView;
        }


    }

}