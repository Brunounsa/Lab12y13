package com.baco.empresapolos.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatosOpenHelper extends SQLiteOpenHelper{
    public DatosOpenHelper(Context context){
        super(context, "DATOS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS PRODUCTO(");
        sql.append("ID VARCHAR(250), ");
        sql.append("MARCA VARCHAR(250), ");
        sql.append("COLOR VARCHAR(250), ");
        sql.append("TALLA VARCHAR(250))");

        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il){

    }
}
