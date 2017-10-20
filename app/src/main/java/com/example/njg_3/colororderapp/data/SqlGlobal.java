package com.example.njg_3.colororderapp.data;

/**
 * Created by NJG_3 on 16/10/2017.
 */

public class SqlGlobal {

    //Constates index columnas
    public static  final  int INDEX_TBLCOLORES_CODE=0;
    public static  final  int INDEX_TBLCOLORES_NAME=1;
    public static  final  int INDEX_TBLCOLORES_HEXA=2;
    public static  final  int INDEX_TBLCOLORES_TOUCH=3;
    public static  final  int INDEX_TBLCOLORES_TIME=4;

    public  static final  String BD_NOMBRE="BD_COLORES";
    public static final  String  TBL_COLORES="tbl_colores";
    // constantes  tbl colores
    public static  final String TBL_COLORES_CODE="code";
    public static  final String TBL_COLORES_NOMBRE="nombre";
    public static  final  String TBL_COLORES_HEXA="hexa";
    public static  final  String TBL_COLORES_TOUCH="touch";
    public static  final  String TBL_COLORES_TIME="time";

    public static  final  String[] campos = new String[] {
            SqlGlobal.TBL_COLORES_CODE,
            SqlGlobal.TBL_COLORES_NOMBRE,
            SqlGlobal.TBL_COLORES_HEXA,
            SqlGlobal.TBL_COLORES_TOUCH,
            SqlGlobal.TBL_COLORES_TIME};

    public static   final String CREATE_TBL_COLORES =" CREATE TABLE " +TBL_COLORES+ "( "
            +TBL_COLORES_CODE+ " VARCHAR(5) PRIMARY KEY , "
            +TBL_COLORES_NOMBRE+" VARCHAR(10) , "
            +TBL_COLORES_HEXA + " INTEGER , "
            +TBL_COLORES_TOUCH +" INTEGER ,"
            +TBL_COLORES_TIME +" LONG )";



      /*Limipar tabla  */
    public static  final  String DELETE_TBL_COLORES="delete from "+TBL_COLORES;


}
