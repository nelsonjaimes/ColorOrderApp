package com.example.njg_3.colororderapp.activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.njg_3.colororderapp.R;
import com.example.njg_3.colororderapp.activity1.adapter.ColorAdapter;
import com.example.njg_3.colororderapp.activity1.ui.CallbacksColor;
import com.example.njg_3.colororderapp.activity2.Activity2;
import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity  implements CallbacksColor, Activity1ViewModel {
    private RecyclerView recyclerColor;
    private Activity1Presenter activity1Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        recyclerColor=(RecyclerView)findViewById(R.id.colorsRecycler);
        activity1Presenter=new Activity1PresenterImp(this);

        if (activity1Presenter!=null){
            if (activity1Presenter.isTouch3()){
                Log.d("nel_","Si hay un elemento mayor q 3");
                activity1Presenter.initOrderLsColores();
            }else{
                Log.d("nel_","no hay un elemento mayor q 3");
                activity1Presenter.initDefaultLsColores();
            }
        }

    }

    @Override
    public void initRecyclerView(ArrayList<Color> lsColor) {
        ColorAdapter colorAdapter= new ColorAdapter(this,lsColor,this);
        recyclerColor.setLayoutManager(new LinearLayoutManager(this));
        recyclerColor.setAdapter(colorAdapter);
    }


    @Override
    public void onClickItem(Color color) {
        if (activity1Presenter!=null){
            activity1Presenter.updateColor(color);
        }

    }

    @Override
    public void navigationActivity2(Color color) {
        Intent intent=new Intent(Activity1.this, Activity2.class);
        intent.putExtra(Activity2.CODE_COLOR,color);
        startActivity(intent);
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("nel_","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("nel_","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("nel_","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("nel_","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("nel_","onDestroy");
    }
}
