package com.example.mercatec2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class produtoDAO {
     private  Conexao con;
     private SQLiteDatabase dB;

    public produtoDAO(Context context){
        con = new Conexao(context);
        dB = con.getWritableDatabase();

    }
    public  long inserir (produto produto){
        ContentValues contentValues =  new ContentValues();

        contentValues.put("nome", produto.getNome());
        contentValues.put("quantidade", produto.getQuantidade());
        contentValues.put("estquantidade", produto.getEstquantidade());

        return dB.insert("produto", null, contentValues);
    }
    public List<produto> listar(){
        List<produto> lista =  new ArrayList<produto>();

        Cursor cursor = dB.rawQuery("SELECT * FROM produto", null);

        while (cursor.moveToNext()){
            lista.add( new produto(cursor.getString(1),cursor.getInt(2),cursor.getInt(3)));
        }
        return lista;
    }

}
