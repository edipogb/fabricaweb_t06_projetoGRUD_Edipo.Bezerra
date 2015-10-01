package br.com.fabricadeprogramador.persistencia.DAO.exception;

/**
 * Created by edipo on 30/09/15.
 */
public class DAOException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DAOException (String msg){
        super(msg);
    }

    public DAOException (Throwable causa){
        super(causa);
    }

    public DAOException(String msg, Throwable causa){
        super(msg, causa);
    }
}
