package com.example.njg_3.colororderapp.activity1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.njg_3.colororderapp.data.SqlGlobal;
import com.example.njg_3.colororderapp.data.SqlLiteHelper;
import com.example.njg_3.colororderapp.model.Color;

import java.util.ArrayList;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class Activity1InteractorImp implements  Activity1Interactor{

    private Context context;
    private SqlLiteHelper sqlLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public Activity1InteractorImp(Context context) {
        this.context = context;
        Log.d("nel_2","initInteractor!!");
        this.sqlLiteHelper=new SqlLiteHelper(context);
        this.sqLiteDatabase=sqlLiteHelper.getWritableDatabase();

      }

    @Override
    public ArrayList<Color> getListaColoresBD() {
        ArrayList<Color> lsColores=new ArrayList<>();
        Cursor cursor =sqLiteDatabase.query(SqlGlobal.TBL_COLORES,SqlGlobal.campos,null,null,null,null,null);
        try{
        if (cursor.moveToFirst()) {
            do {
                String code = cursor.getString(SqlGlobal.INDEX_TBLCOLORES_CODE);
                String nombre = cursor.getString(SqlGlobal.INDEX_TBLCOLORES_NAME);
                int hexa = cursor.getInt(SqlGlobal.INDEX_TBLCOLORES_HEXA);
                int touch = cursor.getInt(SqlGlobal.INDEX_TBLCOLORES_TOUCH);
                long time = cursor.getLong(SqlGlobal.INDEX_TBLCOLORES_TIME);
                Color color = new Color(code, nombre, hexa, touch, time);
                lsColores.add(color);
                Log.d("nel_3", color.toString());
            } while (cursor.moveToNext());
        }
        }catch (Exception e){
            Log.d("nel_","ERROR EN LA BD AL LEER LOS DATOS...");
        }
        return lsColores;
    }

    @Override
    public void updateColorBD(Activity1Inteface activity1Inteface, Color color) {
        String cod=color.getCode();
        String arg[]={cod};
        Long time;
        Cursor cursor = sqLiteDatabase.query(SqlGlobal.TBL_COLORES,SqlGlobal.campos,SqlGlobal.TBL_COLORES_CODE+"=?",arg,null,null,null);
        try{
            if (cursor.moveToFirst()) {
                int touch = cursor.getInt(SqlGlobal.INDEX_TBLCOLORES_TOUCH);
                touch++;
                if (touch<=3){
                    time = System.nanoTime();
                }else{
                    time=cursor.getLong(SqlGlobal.INDEX_TBLCOLORES_TIME);
                }
                //Update
                ContentValues contentValues= new ContentValues();
                contentValues.put(SqlGlobal.TBL_COLORES_TOUCH,touch);
                contentValues.put(SqlGlobal.TBL_COLORES_TIME,time);
                sqLiteDatabase.update(SqlGlobal.TBL_COLORES,contentValues,SqlGlobal.TBL_COLORES_CODE+"= '"+cod+"'",null);

                if (activity1Inteface!=null){
                    activity1Inteface.successSaveColor(color);
                }
                Log.d("nel_4","Touch:"+touch+"//Time:"+time);
            }
        }catch (Exception e){
            Log.d("nel_","ERROR EN LA BD AL LEER LOS DATOS...");
        }

    }


    @Override
    public void resetContadores(Activity1Inteface activity1Inteface, ArrayList<Color> lsColors) {
        sqLiteDatabase.execSQL(SqlGlobal.DELETE_TBL_COLORES);

        Log.d("nel_","La tatable colores se limpio");
        int size=lsColors.size()-1;
        for (int i=size;i>=0;i--){
         Color color = lsColors.get(i);
         color.setTime(System.nanoTime());
        }

        for (Color color: lsColors){
            color.setTouch(0);
            ContentValues contentValues = new ContentValues();
            contentValues.put(SqlGlobal.TBL_COLORES_CODE,color.getCode());
            contentValues.put(SqlGlobal.TBL_COLORES_NOMBRE,color.getNombre());
            contentValues.put(SqlGlobal.TBL_COLORES_HEXA,color.getHexa());
            contentValues.put(SqlGlobal.TBL_COLORES_TOUCH,color.getTouch());
            contentValues.put(SqlGlobal.TBL_COLORES_TIME,color.getTime());
            sqLiteDatabase.insert(SqlGlobal.TBL_COLORES,null,contentValues);
            Log.d("nel_6","insert:color-code: "+color.getCode());
        }

    }
}
