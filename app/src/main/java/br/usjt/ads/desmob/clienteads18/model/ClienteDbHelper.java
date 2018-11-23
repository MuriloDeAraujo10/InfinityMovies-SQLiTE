package br.usjt.ads.desmob.clienteads18.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClienteDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "clientes.db";
    public static final int DATABASE_VERSION = 2;
    public static final String SQL_CREATE_CLIENTE =
            "CREATE TABLE " + ClienteDbContract.Cliente.TABLE_NAME + "(" +
                    ClienteDbContract.Cliente._ID + " INTEGER PRIMARY KEY," +
                    ClienteDbContract.Cliente.ID + " INTEGER," +
                    ClienteDbContract.Cliente.NOME + " TEXT," +
                    ClienteDbContract.Cliente.DIRETOR + " TEXT," +
                    ClienteDbContract.Cliente.LANCAMENTO + " TEXT," +
                    ClienteDbContract.Cliente.DESCRICAO + " TEXT," +
                    ClienteDbContract.Cliente.POPULARIDADE + " TEXT," +
                    ClienteDbContract.Cliente.ELENCO+ " TEXT," +
                    ClienteDbContract.Cliente.FOTO + " TEXT)";

    public static final String SQL_DROP_CLIENTE =
            "DROP TABLE IF EXISTS " + ClienteDbContract.Cliente.TABLE_NAME;

    public ClienteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_CLIENTE);
        sqLiteDatabase.execSQL(SQL_CREATE_CLIENTE);
    }
}