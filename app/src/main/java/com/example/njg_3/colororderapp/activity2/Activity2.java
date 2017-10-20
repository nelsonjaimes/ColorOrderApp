package com.example.njg_3.colororderapp.activity2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.njg_3.colororderapp.R;
import com.example.njg_3.colororderapp.model.Color;

public class Activity2 extends AppCompatActivity {

    public  static  final String CODE_COLOR="CODE_COLOR";
    private int hexa;
    private Color color;
    private String nombre;
    private LinearLayout viewPadre;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        viewPadre=(LinearLayout)findViewById(R.id.viewPadre);
        toolbar=(Toolbar)findViewById(R.id.toolbar);

        Bundle bundle =  getIntent().getExtras();
        if (bundle!=null){
            color= (Color) bundle.getSerializable(CODE_COLOR);
            hexa=color.getHexa();
            nombre=color.getNombre();
         }

         initToolbar(toolbar);
         viewPadre.setBackgroundColor(getResources().getColor(hexa));
    }

    private void initToolbar(Toolbar toolbar){
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(hexa));
        setTitle(nombre);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         if (item.getItemId()==android.R.id.home){
             onBackPressed();
         }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.rigth_in,R.anim.rigth_out);
    }
}
