package com.example.njg_3.colororderapp.activity1;

import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public interface Activity1Interactor {

    ArrayList<Color> getListaColoresBD();
    void updateColorBD(Activity1Inteface activity1Inteface, Color color);
    void resetContadores(Activity1Inteface activity1Inteface,ArrayList<Color> lsColors);

}
