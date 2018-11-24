package br.usjt.ads.desmob.filmeads.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FilmeDb {

    FilmeDbHelper dbHelper;

    public FilmeDb(Context context){
        dbHelper = new FilmeDbHelper(context);
    }

    public void insereFilmes(ArrayList<Filme> filmes){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(FilmeDbContract.Filme.TABLE_NAME, null, null);

        ContentValues values = new ContentValues();
        for(Filme filme:filmes){
            values.put(FilmeDbContract.Filme.ID, filme.getId());
            values.put(FilmeDbContract.Filme.NOME, filme.getNome());
            values.put(FilmeDbContract.Filme.DIRETOR, filme.getDiretor());
            values.put(FilmeDbContract.Filme.LANCAMENTO, filme.getLancamento());
            values.put(FilmeDbContract.Filme.DESCRICAO, filme.getDescricao());
            values.put(FilmeDbContract.Filme.POPULARIDADE, filme.getPopularidade());
            values.put(FilmeDbContract.Filme.ELENCO, filme.getElenco());
            values.put(FilmeDbContract.Filme.FOTO, filme.getFigura());
            db.insert(FilmeDbContract.Filme.TABLE_NAME, null, values);
        }
    }

    public ArrayList<Filme> listarFilmes(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Filme> filmes = new ArrayList<>();

        String[] colunas = {
                FilmeDbContract.Filme.ID,
                FilmeDbContract.Filme.NOME,
                FilmeDbContract.Filme.EMAIL,
                FilmeDbContract.Filme.DIRETOR,
                FilmeDbContract.Filme.ELENCO,
                FilmeDbContract.Filme.LANCAMENTO,
                FilmeDbContract.Filme.DESCRICAO,
                FilmeDbContract.Filme.POPULARIDADE,
                FilmeDbContract.Filme.FOTO
        };

        String ordem = FilmeDbContract.Filme.NOME;

        Cursor c = db.query(FilmeDbContract.Filme.TABLE_NAME, colunas, null, null, null, null, ordem);

        while(c.moveToNext()){
            Filme filme = new Filme();
            filme.setId(c.getInt(c.getColumnIndex(FilmeDbContract.Filme.ID)));
            filme.setNome(c.getString(c.getColumnIndex(FilmeDbContract.Filme.NOME)));
            filme.setDiretor(c.getString(c.getColumnIndex(FilmeDbContract.Filme.DIRETOR)));
            filme.setElenco(c.getString(c.getColumnIndex(FilmeDbContract.Filme.ELENCO)));
            filme.setLancamento(c.getString(c.getColumnIndex(FilmeDbContract.Filme.LANCAMENTO)));
            filme.setDescricao(c.getString(c.getColumnIndex(FilmeDbContract.Filme.DESCRICAO)));
            filme.setPopularidade(c.getString(c.getColumnIndex(FilmeDbContract.Filme.POPULARIDADE)));
           // filme.setFigura(c.getString(c.getColumnIndex(FilmeDbContract.Filme.FOTO)));
            filmes.add(filme);
        }
        c.close();
        return filmes;
    }
}