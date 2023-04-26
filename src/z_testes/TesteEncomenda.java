/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package z_testes;

import b_business.Encomenda;
import b_business.Produto;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author efapp0122
 */
public class TesteEncomenda {
    public static void main(String[] args) throws TaxaIvaInvalidaException, ValorInvalidoException {
        ArrayList<Encomenda> encomendas = new ArrayList<>();
        
        Encomenda e1 = new Encomenda("Juvenal");
        
        Produto p1 = new Produto("Camisa", 12, 6);
        e1.adicionarProduto(p1);
        
        Produto p2 = new Produto("Bermuda", 15, 13);
        e1.adicionarProduto(p2);
        
        System.out.println(e1.toString());
        
    }
}
