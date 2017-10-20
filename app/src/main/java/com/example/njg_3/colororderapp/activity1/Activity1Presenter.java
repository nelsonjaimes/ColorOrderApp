package com.example.njg_3.colororderapp.activity1;

import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public interface Activity1Presenter {
     void initOrderLsColores();
     void initDefaultLsColores();
     void updateColor(Color color);
     boolean isTouch3();
}
