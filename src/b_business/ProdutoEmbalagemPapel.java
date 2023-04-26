/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b_business;

import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;

/**
 *
 * @author 13 - Rodrigo
 */
public class ProdutoEmbalagemPapel extends Produto {
    
    public ProdutoEmbalagemPapel(String designacao) {
        super(designacao);
    }

    public ProdutoEmbalagemPapel(String designacao, float preco, int taxaIva) throws TaxaIvaInvalidaException, ValorInvalidoException {
        super(designacao, preco, taxaIva);
    }
    
    @Override
    public String toString(){
        return super.toString();        
    }
    
}
