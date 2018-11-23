package br.usjt.ads.desmob.clienteads18.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ClienteDb {

    ClienteDbHelper dbHelper;

    public ClienteDb(Context context){
        dbHelper = new ClienteDbHelper(context);
    }

    public void insereClientes(ArrayList<Cliente> clientes){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(ClienteDbContract.Cliente.TABLE_NAME, null, null);

        ContentValues values = new ContentValues();
        for(Cliente cliente:clientes){
            values.put(ClienteDbContract.Cliente.ID, cliente.getId());
            values.put(ClienteDbContract.Cliente.NOME, cliente.getNome());
            values.put(ClienteDbContract.Cliente.DIRETOR, cliente.getDiretor());
            values.put(ClienteDbContract.Cliente.LANCAMENTO, cliente.getLancamento());
            values.put(ClienteDbContract.Cliente.DESCRICAO, cliente.getDescricao());
            values.put(ClienteDbContract.Cliente.POPULARIDADE, cliente.getPopularidade());
            values.put(ClienteDbContract.Cliente.ELENCO, cliente.getElenco());
            values.put(ClienteDbContract.Cliente.FOTO, cliente.getFigura());
            db.insert(ClienteDbContract.Cliente.TABLE_NAME, null, values);
        }
    }

    public ArrayList<Cliente> listarClientes(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Cliente> clientes = new ArrayList<>();

        String[] colunas = {
                ClienteDbContract.Cliente.ID,
                ClienteDbContract.Cliente.NOME,
                ClienteDbContract.Cliente.EMAIL,
                ClienteDbContract.Cliente.DIRETOR,
                ClienteDbContract.Cliente.ELENCO,
                ClienteDbContract.Cliente.LANCAMENTO,
                ClienteDbContract.Cliente.DESCRICAO,
                ClienteDbContract.Cliente.POPULARIDADE,
                ClienteDbContract.Cliente.FOTO
        };

        String ordem = ClienteDbContract.Cliente.NOME;

        Cursor c = db.query(ClienteDbContract.Cliente.TABLE_NAME, colunas, null, null, null, null, ordem);

        while(c.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setId(c.getInt(c.getColumnIndex(ClienteDbContract.Cliente.ID)));
            cliente.setNome(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.NOME)));
            cliente.setDiretor(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.DIRETOR)));
            cliente.setElenco(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.ELENCO)));
            cliente.setLancamento(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.LANCAMENTO)));
            cliente.setDescricao(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.DESCRICAO)));
            cliente.setPopularidade(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.POPULARIDADE)));
           // cliente.setFigura(c.getString(c.getColumnIndex(ClienteDbContract.Cliente.FOTO)));
            clientes.add(cliente);
        }
        c.close();
        return clientes;
    }
}
