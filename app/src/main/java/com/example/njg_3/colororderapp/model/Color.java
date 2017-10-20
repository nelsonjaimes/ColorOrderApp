package com.example.njg_3.colororderapp.model;

import java.io.Serializable;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class Color  implements Serializable{
    private String code;
    private int  hexa;
    private String nombre;
    private int touch;
    private long time;


    public Color(String code,String nombre, int hexa) {
        this.code = code;
        this.hexa = hexa;
        this.touch=0;
        this.nombre=nombre;
        this.time=0;
    }

    public Color(String code, String nombre,int hexa, int touch, long time) {
        this.code = code;
        this.hexa = hexa;
        this.nombre = nombre;
        this.touch = touch;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Code:"+code+"/names:"+nombre+"/hexa:"+hexa+"/touch:"+touch+"/time:"+time;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getHexa() {
        return hexa;
    }

    public void setHexa(int hexa) {
        this.hexa = hexa;
    }

    public int getTouch() {
        return touch;
    }

    public void setTouch(int touch) {
        this.touch = touch;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
