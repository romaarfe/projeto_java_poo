/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package z_testes;

import java.sql.SQLException;
import b_business.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import c_persistence.DBWorker;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;

/**
 *
 * @author 13 - Rodrigo
 */
public class TesteBD {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, TaxaIvaInvalidaException, ValorInvalidoException {
        
        DBWorker workerBD = new DBWorker("192.168.64.8:3306", "rodrigo", "123", "loja_rodrigo");
            
        Produto p = new Produto("Camisa", 12, 6);
        
        workerBD.guardarProduto(p);
     
        System.out.println(workerBD.getAllProdutos());
        
    }
    
}

