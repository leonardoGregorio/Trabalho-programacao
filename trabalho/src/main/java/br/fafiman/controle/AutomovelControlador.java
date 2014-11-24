/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fafiman.controle;

import br.fafiman.entidades.Automovel;
import br.fafiman.negocio.AutomovelDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author leonardo
 */
@SessionScoped
@ManagedBean
public class AutomovelControlador implements Serializable {

    private Automovel entidade;
    private AutomovelDAO automovelDAO = new AutomovelDAO();

    public Automovel getEntidade() {
        return entidade;
    }

    public void setEntidade(Automovel entidade) {
        this.entidade = entidade;
    }

    public AutomovelDAO getAutomovelDAO() {
        return automovelDAO;
    }

    public void setAutomovelDAO(AutomovelDAO automovelDAO) {
        this.automovelDAO = automovelDAO;
    }

    public void novo() {
        entidade = new Automovel();
    }

    public void salvar() {
 automovelDAO.persistir(entidade);
        System.out.println("O obj foi inserido com sucesso");
    }
}
