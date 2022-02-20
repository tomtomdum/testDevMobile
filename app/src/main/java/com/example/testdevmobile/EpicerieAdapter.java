package com.example.testdevmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdevmobile.Models.ItemEpicerie;

import java.util.ArrayList;
//https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example
public class EpicerieAdapter extends RecyclerView.Adapter<EpicerieAdapter.ViewHolder> {
    private ArrayList<ItemEpicerie> listeEpicerie = new ArrayList<ItemEpicerie>();


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

    public ArrayList<ItemEpicerie> getListeEpicerie() {
        return listeEpicerie;
    }

    public void setListeEpicerie(ArrayList<ItemEpicerie> listeEpicerie) {
        this.listeEpicerie = listeEpicerie;
    }



    public class ViewHolder extends RecyclerView.ViewHolder  implements PopupMenu.OnMenuItemClickListener  {
        TextView description;
        TextView title;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            cardView = itemView.findViewById(R.id.card_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("clicl","click");
//                  listeEpicerie.remove(getLayoutPosition());
                    showPopup(view);
                }
            });

            title = (TextView) itemView.findViewById(R.id.nom_item);
            description = (TextView) itemView.findViewById(R.id.description);

            }

        public void showPopup(View view) {
            PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.inflate(R.menu.context_menu_recycler_view);
            popupMenu.show();
        }
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.options_add:
                    for (long i =0; i<999; i++){
                        listeEpicerie.add(new ItemEpicerie("pormme", "ses bons quand ses pas trop surettaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
                        notifyDataSetChanged();
                    }
                    return true;

                case R.id.options_remove:
                    listeEpicerie.remove(getPosition());
                    notifyDataSetChanged();

                    return true;

                default:
                    return false;
            }
        }
    }
}