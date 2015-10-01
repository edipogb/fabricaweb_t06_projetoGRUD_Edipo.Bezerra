package br.com.fabricadeprogramador.persistencia.DAO;

import org.springframework.stereotype.Repository;

/**
 * Created by edipo on 30/09/15.
 */

@Repository
public interface CidadeDAO {

    public void salvar();
    public void remover();

}
