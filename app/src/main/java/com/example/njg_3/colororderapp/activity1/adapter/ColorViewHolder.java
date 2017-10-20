package com.example.njg_3.colororderapp.activity1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.njg_3.colororderapp.R;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class ColorViewHolder extends RecyclerView.ViewHolder {
     LinearLayout item;
     TextView itemColor;

    public ColorViewHolder(View itemView) {
        super(itemView);
        this.item=(LinearLayout) itemView;
        this.itemColor=(TextView)itemView.findViewById(R.id.itemColor);
        }
}
