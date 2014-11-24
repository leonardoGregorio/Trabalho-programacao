/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fafiman.controle;

import br.fafiman.entidades.Motocicleta;
import br.fafiman.negocio.MotocicletaDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author leonardo
 */
@SessionScoped
@ManagedBean
public class MotocicletaControlador implements Serializable {
    private Motocicleta entidade;
    private MotocicletaDAO motocicletaDAO = new MotocicletaDAO();

    public Motocicleta getEntidade() {
        return entidade;
    }

    public void setEntidade(Motocicleta entidade) {
        this.entidade = entidade;
    }

    public MotocicletaDAO getMotocicletaDAO() {
        return motocicletaDAO;
    }

    public void setMotocicletaDAO(MotocicletaDAO motocicletaDAO) {
        this.motocicletaDAO = motocicletaDAO;
    }
    
    public void  novo(){
        entidade = new Motocicleta();
    }
    
    public void salvar(){
        motocicletaDAO.persistir(entidade);
        System.out.println("O objeto foi salvo com sucesso.");
    }
}
