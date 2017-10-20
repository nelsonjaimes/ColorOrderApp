package com.example.njg_3.colororderapp.activity1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.njg_3.colororderapp.R;
import com.example.njg_3.colororderapp.activity1.ui.CallbacksColor;
import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class ColorAdapter  extends RecyclerView.Adapter<ColorViewHolder>{
    private Context context;
    private ArrayList<Color> lsColors;
    private CallbacksColor callbacksColor;

    public ColorAdapter(Context context, ArrayList<Color> lsColors, CallbacksColor callbacksColor) {
        this.context = context;
        this.lsColors = lsColors;
        this.callbacksColor = callbacksColor;
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_color,parent,false);
        return new ColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        final Color color = lsColors.get(position);
        holder.item.setBackgroundColor(context.getResources().getColor(color.getHexa()));
        holder.itemColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callbacksColor!=null){
                    callbacksColor.onClickItem(color);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return lsColors.size();
    }
}
