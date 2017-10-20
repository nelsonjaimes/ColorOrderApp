package com.example.njg_3.colororderapp.activity1;

import android.content.Context;
import android.util.Log;

import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class Activity1PresenterImp implements  Activity1Presenter, Activity1Inteface{
    private Context context;
    private Activity1ViewModel activity1ViewModel;
    private Activity1Interactor activity1Interactor;

    public Activity1PresenterImp(Context context) {
        this.context = context;
        this.activity1ViewModel = (Activity1ViewModel)context;
        Log.d("nel_2","initPresente!!");
        this.activity1Interactor=new Activity1InteractorImp(context);
    }

    @Override
    public void initOrderLsColores() {
        if (activity1ViewModel!=null && activity1Interactor!=null){
                ArrayList<Color> lsColors=activity1Interactor.getListaColoresBD();
                ArrayList<Color> lsOrderColors=getLsOrderColor(lsColors);
                /*reseteo de los contadores*/
                activity1Interactor.resetContadores(this,lsOrderColors);
                activity1ViewModel.initRecyclerView(lsOrderColors);
            }
      }

    @Override
    public void initDefaultLsColores() {
        if (activity1ViewModel!=null && activity1Interactor!=null){
            ArrayList<Color> lsColors=activity1Interactor.getListaColoresBD();
            activity1ViewModel.initRecyclerView(lsColors);
        }
    }

    @Override
    public boolean isTouch3() {
        boolean state=false;
        if (activity1Interactor!=null){
            state=isTouch3(activity1Interactor.getListaColoresBD());
        }
        return state;
    }

    @Override
    public void updateColor(Color color) {
        if (activity1Interactor!=null){
            activity1Interactor.updateColorBD(this,color);

        }

    }
    private boolean isTouch3(ArrayList<Color> lsColors){
        for (Color color: lsColors){
             if (color.getTouch()>=3){
                 return true;
             }
         }
         return false;
    }

    private ArrayList<Color> getLsOrderColor(ArrayList<Color>  lsColor){
        int size=lsColor.size();
        Color aux=null;
        for (int i=0;i<size-1;i++){
            for (int j=i+1;j<size;j++){
                Color colorAct =lsColor.get(i);
                Color colorPost=lsColor.get(j);
                aux=colorAct;
                if (colorAct.getTouch()>=3 && colorPost.getTouch()>=3){
                        if (colorAct.getTime()<colorPost.getTime()){
                            lsColor.set(i,colorPost);
                            lsColor.set(j,aux);
                        }
                }else{
                    if (colorAct.getTouch()<colorPost.getTouch()){
                        lsColor.set(i,colorPost);
                        lsColor.set(j,aux);

                    }else if (colorAct.getTouch()==colorPost.getTouch()){
                        if (colorAct.getTime()<colorPost.getTime()){
                            lsColor.set(i,colorPost);
                            lsColor.set(j,aux);
                        }
                    }
                }

            }
        }

         for (Color color:lsColor){
            Log.d("nel_5","Color: "+color.toString());
         }

        return lsColor;
    }

    /* Interface  Interactor->Presenter*/

    @Override
    public void successSaveColor(Color color) {
        if (activity1ViewModel!=null){
            activity1ViewModel.navigationActivity2(color);
        }
    }
}
