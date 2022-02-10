package com.example.testdevmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdevmobile.Models.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {
    private List<Client> listeClient;

    ClientAdapter(List<Client> listeClient){
        this.listeClient = listeClient;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ite,parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        holder.textView.setText(listeClient.get(position).getfName());

    }

    @Override
    public int getItemCount() {
        return listeClient.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
             this.textView = itemView.findViewById(R.id.item_view);
        }


    }
}
