// PACKAGE ONDE SE ENCONTRA
package b_business;

// IMPORTS NECESSÁRIOS PARA BOM FUNCIONAMENTO DA CLASSE
import java.util.ArrayList;
import java.util.Objects;

/** CLASSE LOJA QUE É COMPOSTA POR ENCOMENDAS, QUE POR SUA VEZ É COMPOSTA DE PRODUTOS
 *
 * @author 13 - Rodrigo
 */
public class Loja {
    
    // VARIÁVEL DE CLASSE
    private String designacao;
    
    // ARRAYLIST PARA AGREGAR ENCOMENDAS
    private final ArrayList<Encomenda> encomendas;

    /** CONSTRUTOR LOJA QUE RECEBE UMA DESIGNACAO COMO ARGUMENTO
     * ALÉM DE INSTANCIAR UM NOVO ARRAYLIST DO TIPO ENCOMENDA
     * @param designacao
     */
    public Loja(String designacao) {
        this.designacao = designacao;
        this.encomendas = new ArrayList<>();
    }

    /** MÉTODO QUE BUSCA A DESIGNAÇÃO E RETORNA A STRING REFERENTE
     *
     * @return
     */
    public String getDesignacao() {
        return designacao;
    }

    /** MÉTODO QUE INSERE UMA DESIGNAÇÃO E FAZ A VARIÁVEL DA CLASSE RECEBER 
     * A STRING REFERENTE
     *
     * @param designacao
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /** MÉTODO QUE BUSCA AS ENCOMENDAS REGISTRADAS NO ARRAYLIST DO TIPO 
     * ENCOMENDA RETORNANDO AS MESMAS
     *
     * @return
     */
    public ArrayList<Encomenda> getEncomendas() {
        return encomendas;
    }

    /** MÉTODO QUE ADICIONA UMA NOVA ENCOMENDA NA INSTÂNCIA QUE FOI CRIADA
     * DO TIPO ENCOMENDA
     *
     * @param e
     */
    public void adicionaEncomenda(Encomenda e){
        encomendas.add(e);
    }
    
    /** MÉTODO PARA REMOVER ENCOMENDAS A PARTIR DE UM ÍNDICE RECEBIDO 
     * COMO ARGUMENTO
     *
     * @param i
     */
    public void removeEncomenda(int i){
        encomendas.remove(i);
    }

    /** MÉTODO QUE FORMATA UM CONTEÚDO E PODE SER INVOCADO PARA IMPRIMIR 
     * DE FORMA ADEQUADA AS ENCOMENDAS REGISTRADAS NESSA LOJA
     *
     * @return
     */
    @Override
    public String toString() {
        return "#### Loja ####" + "\nDesignacao: " + designacao + "\n" + encomendas + '}';
    }

    /** MÉTODO UTILIZADO PARA VERIFICAR (BUSCAR) UM ITEM, COMO NO CASO DE UM
     * HASHSET
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.designacao);
        hash = 97 * hash + Objects.hashCode(this.encomendas);
        return hash;
    }

    /** MÉTODO UTILIZADO PARA VERIFICAR A EXISTÊNCIA DE UM ITEM, COMO NO CASO
     * DE UM ARRAYLIST
     *
     * @param obj
     * @return
     */
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
        final Loja other = (Loja) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        return Objects.equals(this.encomendas, other.encomendas);
    }
}
