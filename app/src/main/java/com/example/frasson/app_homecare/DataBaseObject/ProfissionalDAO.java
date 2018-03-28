package com.example.frasson.app_homecare.DataBaseObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.frasson.app_homecare.usuarios.Profissional;

import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO extends SQLiteOpenHelper{


    public ProfissionalDAO(Context context) {
        super(context, "Profissional", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Profissional (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, telefone TEXT NOT NULL, especialidade TEXT NOT NULL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXIST Profissional";
        db.execSQL(sql);
        onCreate(db);

    }

    public void insere(Profissional profissional) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", profissional.getNome());
        dados.put("telefone", profissional.getTelefone());
        dados.put("especialidade", profissional.getEspecialidade());


        db.insert("Profissional", null, dados);
    }

    public List<Profissional> buscaProfissionais() {
        String sql = "SELECT * FROM Profissional;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Profissional> profissionais = new ArrayList<Profissional>();
        while (c.moveToNext()){
            Profissional profissional = new Profissional();
            profissional.setId(c.getLong(c.getColumnIndex("id")));
            profissional.setNome(c.getString(c.getColumnIndex("nome")));
            profissional.setTelefone(c.getString(c.getColumnIndex("telefone")));
            profissional.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));

            profissionais.add(profissional);

        }
        return profissionais;
    }
}

