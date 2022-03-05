package com.gba.pokedexgrupo1;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class BBDD extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bd_pokemon.db";

    public BBDD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BBDD(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Pokemones.EntradaPokemones.NOMBRE_TABLA +
                " ("
                + Pokemones.EntradaPokemones._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Pokemones.EntradaPokemones.NOMBRE + " TEXT NOT NULL,"
                + Pokemones.EntradaPokemones.FOTO + " TEXT NOT NULL,"
                + "UNIQUE (" + Pokemones.EntradaPokemones.NOMBRE + "))");

        Pokemon pregunta1 = new Pokemon();
        this.save(pregunta1, db);
        Pokemon pregunta2 = new Pokemon();
        this.save(pregunta2, db);
        Pokemon pregunta3 = new Pokemon();
        this.save(pregunta3, db);
        Pokemon pregunta4 = new Pokemon();
        this.save(pregunta4, db);
        Pokemon pregunta5 = new Pokemon();
        this.save(pregunta5, db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void save(Pokemon pregunta) {
        this.save(pregunta, null);
    }
    // creamos nuevo método save() que se usa internamente en el onCreate
    private void save(Pokemon pregunta, SQLiteDatabase db) {
        if(db == null)
            db = getWritableDatabase();
        // Contenedor de valores
        ContentValues values = new ContentValues();
        // Pares clave-valor
        values.put(Pokemones.EntradaPokemones.NOMBRE, pregunta.getName());
        values.put(Pokemones.EntradaPokemones.FOTO, pregunta.getDescription());
        // Insertar...
        db.insert(Pokemones.EntradaPokemones.NOMBRE_TABLA, null, values);
    }

}

class Pokemones {
    /* contructor privado parar que no se pueda instanciar la clase
   accidentalmente */
    private Pokemones() {
    }

    public static class EntradaPokemones implements BaseColumns {
        public static final String NOMBRE_TABLA = "Pokemons";
        public static final String NOMBRE = "nombre";
        public static final String FOTO = "foto";
    }
}