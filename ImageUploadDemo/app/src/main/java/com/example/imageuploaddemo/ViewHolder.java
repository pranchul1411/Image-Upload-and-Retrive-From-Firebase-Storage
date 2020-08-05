package com.example.imageuploaddemo;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {


    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


    }

    public void  setdetails(Context context,String title,String image){

        TextView mtitlev = view.findViewById(R.id.rTitleView);
        ImageView mImagev = view.findViewById(R.id.rImageView);


        mtitlev.setText(title);
        Picasso.with(context).load(image).into(mImagev);

        Animation animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
        itemView.startAnimation(animation);
    }
}
