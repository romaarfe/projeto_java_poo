
package b_business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 13 - Rodrigo
 */
public class Encomenda {
    
    private static int contadorEncomendas = 1;

    public static int getContadorEncomendas() {
        return contadorEncomendas;
    }

    public static void incContadorEncomendas() {
        contadorEncomendas++;
    }
    
    private final ArrayList<Produto> produtosEncomendados;
    private String nomeCliente;
    private Date data;
    private final int numeroEncomenda;
    
    public Encomenda(String nomeCliente) {
        this.produtosEncomendados = new ArrayList<>();
        this.nomeCliente = nomeCliente;
        data = new Date();
        numeroEncomenda = getContadorEncomendas();
        incContadorEncomendas();
    }
    
    public int getNumeroEncomenda() {
        return numeroEncomenda;
    }    
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<Produto> getProdutosEncomendados() {
        return produtosEncomendados;
    }

    public void adicionarProduto(Produto p){
        produtosEncomendados.add(p);
    }
    
    public void removeProduto(int i){
        produtosEncomendados.remove(i);
    }
    
    public float calculaTotalComIva(){
        float total = 0.0f;

        for (Produto produtoEncomendado : produtosEncomendados) {
            float taxaIva = (float)produtoEncomendado.getTaxaIva() / 100.0f;
            total += produtoEncomendado.getPrecoSemIva() * (1+ taxaIva);
        }
        
        return total;
    }

    public float calculaTotalSemIva(){
        float total = 0.0f;

        for (Produto produtoEncomendado : produtosEncomendados) {
            total += produtoEncomendado.getPrecoSemIva();
        }
        
        return total;        
    }

    @Override
    public String toString() {
        return "### Encomenda ### " + "\n" + produtosEncomendados + "\n\nNome Cliente: " + nomeCliente + "\nData: " + data + "\nNumero Encomenda: " + numeroEncomenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.produtosEncomendados);
        hash = 79 * hash + Objects.hashCode(this.nomeCliente);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + this.numeroEncomenda;
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
        final Encomenda other = (Encomenda) obj;
        if (this.numeroEncomenda != other.numeroEncomenda) {
            return false;
        }
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.produtosEncomendados, other.produtosEncomendados)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }



}
