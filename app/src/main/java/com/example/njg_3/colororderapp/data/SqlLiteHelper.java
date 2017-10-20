package com.example.njg_3.colororderapp.data;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.njg_3.colororderapp.R;
import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class SqlLiteHelper extends SQLiteOpenHelper {


    public SqlLiteHelper(Context context) {
        super(context, SqlGlobal.BD_NOMBRE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           Log.d("nel_2","oncreateDB");
            db.execSQL(SqlGlobal.CREATE_TBL_COLORES);
            initColores(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IS EXITS "+SqlGlobal.TBL_COLORES);
        onCreate(db);

    }


    private void initColores(SQLiteDatabase db){
     Log.d("nel_2","initColores!!");
     ArrayList<Color> lsColors= new ArrayList<>();
        lsColors.add(new Color("c1","Rojo", R.color.color_rojo));
        lsColors.add(new Color("c2","Azul",R.color.color_azul));
        lsColors.add(new Color("c3","Verde",R.color.color_verde));

        /*lsColors.add(new Color("c4","color_4",R.color.color_4));
        lsColors.add(new Color("c5","color_5",R.color.color_5));
        lsColors.add(new Color("c6","color_6",R.color.color_6));
        lsColors.add(new Color("c7","color_7",R.color.color_7)); */

        int size=lsColors.size()-1;
        for (int i=size;i>=0;i--){
            Color color = lsColors.get(i);
            color.setTime(System.nanoTime());
        }

        for (Color color: lsColors){
            ContentValues contentValues = new ContentValues();
            contentValues.put(SqlGlobal.TBL_COLORES_CODE,color.getCode());
            contentValues.put(SqlGlobal.TBL_COLORES_NOMBRE,color.getNombre());
            contentValues.put(SqlGlobal.TBL_COLORES_HEXA,color.getHexa());
            contentValues.put(SqlGlobal.TBL_COLORES_TOUCH,color.getTouch());
            contentValues.put(SqlGlobal.TBL_COLORES_TIME,color.getTime());
            db.insert(SqlGlobal.TBL_COLORES,null,contentValues);
            Log.d("nel_2","insert:color-code: "+color.getCode());
        }



    }


}
