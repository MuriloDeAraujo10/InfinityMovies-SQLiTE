package br.usjt.ads.desmob.filmeads.model;

import android.provider.BaseColumns;

public class FilmeDbContract {
    public FilmeDbContract(){}

    public static abstract class Filme implements BaseColumns {
        public static final String TABLE_NAME = "filme";
        public static final String ID = "id";
        public static final String NOME = "nome";
        public static final String EMAIL = "email";
        public static final String DIRETOR = "diretor";
        public static final String ELENCO = "elenco";
        public static final String LANCAMENTO = "lancamento";
        public static final String DESCRICAO = "descricao";
        public static final String POPULARIDADE = "popularidade";
        public static final String FOTO = "foto";

    }
}
