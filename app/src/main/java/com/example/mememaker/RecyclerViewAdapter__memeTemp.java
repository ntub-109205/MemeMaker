package com.example.mememaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class RecyclerViewAdapter__memeTemp extends RecyclerView.Adapter<RecyclerViewAdapter__memeTemp.MyViewHolder> {
    Context mContext;
    List<memeTemplate> mData;

    public RecyclerViewAdapter__memeTemp(Context mContext, List<memeTemplate> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_hottemplate,parent,false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

//        holder.tempName.setText(mData.get(position).getTempName());
//        holder.tempImage.setImageResource(mData.get(position).getTempImage());
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);
        //將image用glide的方式呈現
        Glide.with(mContext)
                .load(mData.get(position).getTempImage())
                .apply(requestOptions)
                .into(holder.tempImage);
        holder.tempName.setText(mData.get(position).getTempName());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tempName;
        private ImageView tempImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tempName = (TextView) itemView.findViewById(R.id.cardName);
            tempImage = (ImageView) itemView.findViewById(R.id.cardImage);
        }
    }
}