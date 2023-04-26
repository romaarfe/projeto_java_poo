/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package z_testes;

import b_business.Produto;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.util.ArrayList;

/**
 *
 * @author efapp0122
 */
public class TesteProduto {
    public static void main(String[] args) throws TaxaIvaInvalidaException, ValorInvalidoException {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        Produto p1 = new Produto("Camisa", 12, 6);
        produtos.add(p1);
        
        Produto p2 = new Produto("Bermuda", 15, 13);
        produtos.add(p2);
        
        System.out.println(produtos.toString());
        
    }
}