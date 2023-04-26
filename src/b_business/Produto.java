
package b_business;

import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.util.Objects;

/**
 *
 * @author 13 - Rodrigo
 */
public class Produto {

    public static void setProdutoNumero(int aProdutoNumero) {
        produtoNumero = aProdutoNumero;
    }
    
    public int getProdutoNumero() {
        return produtoNumero;
    }

    public static void incrementaNumero(Produto p) {
        produtoNumero++;
    }
    
    private int referencia = produtoNumero;
    private String designacao;
    private float precoSemIva;
    private int taxaIva;
    private static int produtoNumero;
   
    public Produto() {
    }
    
    public Produto(String designacao) {
        incrementaNumero(this);
        this.referencia = produtoNumero;
        this.designacao = designacao;
    }

    public Produto(String designacao, float preco, int taxaIva) throws TaxaIvaInvalidaException, ValorInvalidoException {
        incrementaNumero(this);
        this.referencia = produtoNumero;
        this.designacao = designacao;
        setPrecoSemIva(preco);
        setTaxaIva(taxaIva);
    }
    
    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public float getPrecoSemIva() {
        return precoSemIva;
    }

    public void setPrecoSemIva(float precoSemIva) throws ValorInvalidoException {
        if(precoSemIva >= 0){
            this.precoSemIva = precoSemIva;            
        }else{
            throw new ValorInvalidoException("Preco introduzido invalido ("+precoSemIva+").");
        }
    }
    
    public void setTaxaIva(int taxaIva) throws TaxaIvaInvalidaException {
        if (taxaIva == 6 || taxaIva == 13 || taxaIva == 23) {
            this.taxaIva = taxaIva;
        }else{
            throw new TaxaIvaInvalidaException("Taxa IVA introduzida invalida ("+taxaIva+").");
        }
    }
    
    public int getTaxaIva() {
        return taxaIva;
    }

    @Override
    public String toString() {
        return "\n\n## Produto ##" + "\nReferencia = " + referencia + "\nDesignacao = " + designacao + "\nPreco sem IVA = " + precoSemIva + "\nTaxa IVA = " + taxaIva;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.referencia);
        hash = 67 * hash + Objects.hashCode(this.designacao);
        hash = 67 * hash + Float.floatToIntBits(this.precoSemIva);
        hash = 67 * hash + this.taxaIva;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (Float.floatToIntBits(this.precoSemIva) != Float.floatToIntBits(other.precoSemIva)) {
            return false;
        }
        if (this.taxaIva != other.taxaIva) {
            return false;
        }
        if (!Objects.equals(this.referencia, other.referencia)) {
            return false;
        }
        return Objects.equals(this.designacao, other.designacao);
    }

    
    
    
}
