package com.example.buspass;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Pass_rate_Adopter extends RecyclerView.Adapter<Pass_rate_Adopter.ViewHolder> {

    Context context;

    public Pass_rate_Adopter(Context context, ArrayList<PassRate_Model> passrate_model_list) {
        this.context = context;
        Passrate_model_list = passrate_model_list;
    }

    ArrayList<PassRate_Model> Passrate_model_list;

    @Override
    public Pass_rate_Adopter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.item_on_passrates,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Pass_rate_Adopter.ViewHolder holder, int position) {

        PassRate_Model model= Passrate_model_list.get(position);
        holder.Bus_name.setText(model.getBus_Name());
        holder.Bus_image.setImageResource(model.getBus_Image());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,RateList.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Passrate_model_list.size();
    }

    public void setItems(ArrayList<PassRate_Model> passrate_model_list) {
        this.Passrate_model_list=passrate_model_list;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView Bus_image;
        private final TextView Bus_name;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            Bus_image = itemView.findViewById(R.id.Image_on_passRates);
            Bus_name = itemView.findViewById(R.id.Tv_On_BusType);

        }
    }
}
