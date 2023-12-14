package com.example.mercatec2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteOpenHelper;
public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Banco.db";
    public DBHelper(Context context) {
        super(context, DBNAME , null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table usuario(nomeUsuario TEXT primary key, senha TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists usuario");
    }
    public Boolean cadastra(String nomeUsuario, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("nomeUsuario", nomeUsuario);
        contentValues.put("senha", senha);
        long result = MyDB.insert("usuario", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean verificaNome(String nomeUsuario) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from usuario where nomeUsuario = ?", new String[]
                {nomeUsuario});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean verificaNomeSenha(String nomeUsuario, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from usuario where nomeUsuario = ? and senha = ?", new String[]
                {nomeUsuario,senha});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
