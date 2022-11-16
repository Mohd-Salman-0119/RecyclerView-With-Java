package com.udemy.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    ArrayList<Person> people;
    ItemSelected activity;
    public interface ItemSelected
    {
        void onItemSelected(int index);
    }
    public PersonAdapter(Context context, ArrayList<Person> list)
    {
        people = list;
        activity = (ItemSelected) context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPlane;
        TextView tvName,tvSurname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            ivPlane = itemView.findViewById(R.id.ivPlane);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemSelected(people.indexOf((Person) view.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(people.get(position));

        holder.tvName.setText(people.get(position).getName());
        holder.tvSurname.setText(people.get(position).getSurname());

    if (people.get(position).getPreference().equals("bus")){
        holder.ivPlane.setImageResource(R.drawable.bus);
        }
    else {
        holder.ivPlane.setImageResource(R.drawable.plane);
    }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
