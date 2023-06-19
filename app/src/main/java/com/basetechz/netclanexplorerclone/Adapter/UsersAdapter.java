package com.basetechz.netclanexplorerclone.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.basetechz.netclanexplorerclone.Models.model;
import com.basetechz.netclanexplorerclone.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class UsersAdapter  extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    ArrayList<model> modelArrayList = new ArrayList<>();
    Context context;
    int completedCount;


    // constructor of UsersAdapter Class
    public UsersAdapter(ArrayList<model> modelArrayList, Context context){
        this.modelArrayList = modelArrayList;
        this.context = context;
    }





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.people_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        model model = modelArrayList.get(position);
        holder.name.setText(model.getName());
        Glide.with(context).load(model.getImage()).into(holder.image);
        holder.city.setText(model.getCity());
        holder.distance.setText(model.getDistance());
        holder.purposeCoffee.setText(model.getPurposeCoffee());
        holder.purposeBusiness.setText(model.getPurposeBusiness());
        holder.hiCommunity.setText(model.getHiCommunity());
        holder.Bio.setText(model.getBio());

        // set Text Visibility

        setTextViewVisibility(holder.city, model.getCity()+", ");
        setTextViewVisibility(holder.distance, model.getDistance());
        setTextViewVisibility(holder.purposeCoffee, model.getPurposeCoffee()+" | ");
        setTextViewVisibility(holder.purposeBusiness, model.getPurposeBusiness()+" | ");
        setTextViewVisibility(holder.hiCommunity, model.getHiCommunity());
        setTextViewVisibility(holder.Bio, model.getBio());

        // set Progress Bar functions

        int progress = calculateProgress(model); // Calculate progress based on model
        holder.progressBar.setProgress(progress);

    }

    // setTextViewVisibility Method
    private void setTextViewVisibility(TextView textView, String value) {
        if (!TextUtils.isEmpty(value)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(value);
        } else {
            textView.setVisibility(View.GONE);
        }
    }

    // calculateProgress Method
    private int calculateProgress(model model) {
        completedCount = 0;

        if (!TextUtils.isEmpty(model.getCity())) {
            completedCount++;
        }
        if (!TextUtils.isEmpty(model.getDistance())) {
            completedCount++;
        }
        if (!TextUtils.isEmpty(model.getPurposeCoffee())
                || !TextUtils.isEmpty(model.getPurposeBusiness())
                || !TextUtils.isEmpty(model.getPurposeHobbies())
                || !TextUtils.isEmpty(model.getPurposeFriendShip())
                || !TextUtils.isEmpty(model.getPurposeMovies())
                || !TextUtils.isEmpty(model.getPurposeDinning())
                || !TextUtils.isEmpty(model.getPurposeDating())
                || !TextUtils.isEmpty(model.getPurposeMatrimony())) {
            completedCount++;
        }

        if (!TextUtils.isEmpty(model.getHiCommunity())) {
            completedCount++;
        }if (!TextUtils.isEmpty(model.getImage())) {
            completedCount++;
        }if (!TextUtils.isEmpty(model.getBio())) {
            completedCount++;
        }if (!TextUtils.isEmpty(model.getName())) {
            completedCount++;
        }
        int progress = (int) ((completedCount / 7.0) * 100); // Calculate progress as a percentage
        return progress;
    }



    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    // setFilter method for search people
    public  void setFilter(ArrayList<model> filteredList) {
        this.modelArrayList = filteredList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        TextView city;
        TextView distance;
        TextView purposeCoffee;
        TextView purposeBusiness;
        TextView purposeHobbies;
        TextView purposeFriendShip;
        TextView  purposeMovies;
        TextView purposeDinning;
        TextView purposeDating;
        TextView purposeMatrimony;
        TextView  hiCommunity; TextView Bio;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            city = itemView.findViewById(R.id.city);
            distance = itemView.findViewById(R.id.distance);
            purposeCoffee = itemView.findViewById(R.id.purposeCoffee);
            purposeBusiness = itemView.findViewById(R.id.purposeBusiness);
            purposeHobbies = itemView.findViewById(R.id.purposeHobbies);
            purposeFriendShip = itemView.findViewById(R.id.purposeFriendShip);
            purposeMovies = itemView.findViewById(R.id.purposeMovies);
            purposeDinning = itemView.findViewById(R.id.purposeDinning);
            purposeDating = itemView.findViewById(R.id.purposeDating);
            purposeMatrimony = itemView.findViewById(R.id.purposeMatrimony);
            hiCommunity = itemView.findViewById(R.id.hiCommunity);
            Bio = itemView.findViewById(R.id.bio);
            progressBar = itemView.findViewById(R.id.progress_horizontal);
        }
    }



}
