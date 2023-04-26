
package a_presentation;

import b_business.Encomenda;
import b_business.Loja;
import b_business.Produto;
import b_business.ProdutoEmbalagemPapel;
import b_business.ProdutoEmbalagemPlastico;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import lib.Console;



/**
 *
 * @author 13 - Rodrigo
 */
public class StartConsoleMode {
    
    public static void pause(){
        Console.readString("\n\n !! PRIMA ENTER PARA CONTINUAR !! \n\n");
    }
    
    public static void main(String[] args) throws TaxaIvaInvalidaException, ValorInvalidoException {
        
        // --- Criacao da loja -------------------------------------------------
        String designacaLoja = Console.readString("Indique a designacao da Loja: ");
        Loja lj = new Loja(designacaLoja);
        
        int opcao = 0;

        // --- INTERATIVO ------------------------------------------------------
        do{
            // --- MENU --------------------------------------------------------
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=== LOJA DO BOM SUCESSO ======================");
            System.out.println("1. Ver dados da loja");
            System.out.println("2. Total de Iva da Loja");
            System.out.println("------ ENCOMENDAS --------------------------- ");
            System.out.println("3. Nova Encomenda");
            System.out.println("4. Remover Encomenda");
            System.out.println("5. Ver Total da Encomenda com Iva");
            System.out.println("6. Ver Total da Encomenda sem Iva");
            System.out.println("------ PRODUTOS ------------------------ ");
            System.out.println("7. Adicionar Produtos a Encomenda Existente");
            System.out.println("8. Remover Produto de Encomenda Existente");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------- ");
            
            
            opcao = Console.readInt("[ESCOLHA OPCAO]# ");
            System.out.println("\n\n\n");
            switch(opcao){
                case 1:
                        // DADOS DA LOJA
                        System.out.println("=== Loja: " + lj.getDesignacao());
                        System.out.println("=== Total Encomendas: " + lj.getEncomendas().size());
                        System.out.println("--- ENCOMENDAS -------------------------");
                        System.out.println(lj.getEncomendas().toString());
                        pause();
                        break;
                
                case 2:
                        // TOTAL DE IVA LOJA
                        float totalIva = 0.0f;
                        for (Encomenda encomenda : lj.getEncomendas()) {
                            totalIva += (encomenda.calculaTotalComIva() - encomenda.calculaTotalSemIva());
                        }
                        System.out.println("\nTotal de IVA a Loja: " + totalIva);
                        pause();
                        break;
                
                case 3:
                        // NOVA ENCOMENDA
                        String nomeCliente = Console.readString("Nome do cliente: ");
                        int quantidadeProdutos = Console.readInt("Quantos produtos quer adicionar?");
                        
                        Encomenda encomendas = new Encomenda(nomeCliente);
                        Produto produtos = new Produto();
                        
                        for (int i = 1; i <= quantidadeProdutos; i++) {
                            float preco = (float)Console.readInt("Qual o valor do "+ i +"º produto? ");
                            try {
                                    produtos.setPrecoSemIva(preco);
                                } catch (ValorInvalidoException e) {
                                    System.out.println("Preco invalido! " + e.getMessage());
                                    continue;
                                }
                            int taxaIva = Console.readInt("Qual a tava IVA [6, 13 ou 23]? ");
                            try {
                                    produtos.setTaxaIva(taxaIva);
                                } catch (TaxaIvaInvalidaException e) {
                                    System.out.println("Taxa IVA Invalida! " + e.getMessage());
                                    continue;
                                }
                            int opcaoTipoProduto = Console.readInt("Digite [1] para Papel ou [2] para Plastico: ");
                            
                            if (opcaoTipoProduto == 1) {
                                ProdutoEmbalagemPapel papel = new ProdutoEmbalagemPapel("Embalagem Papel", preco, taxaIva);
                           
                                encomendas.adicionarProduto(papel);
                            }
                            else if (opcaoTipoProduto == 2) {
                                int taxaSuplementar = Console.readInt("Qual a taxa suplementar pelo plastico? ");
                                ProdutoEmbalagemPlastico plastico = new ProdutoEmbalagemPlastico("Embalagem Plastico", preco, taxaIva, taxaSuplementar);
                                
                                encomendas.adicionarProduto(plastico);
                            }
                            else {
                                System.out.println("Opção inválida");
                            }
                            
                        }
                        
                        lj.adicionaEncomenda(encomendas);
 
                        System.out.println("\n Criacao um nova encomenda realizada com sucesso!\n");
                        pause();
                        break;
                
                case 4:
                        // REMOVER ENCOMENDA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaRemocao = Console.readInt("Qual a encomenda a eliminar? ");
                        try{
                            lj.getEncomendas().remove(escolhaRemocao);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                        }
                        pause();
                        break;
                
                case 5:
                        // VER TOTAL DA ENCOMENDA COM IVA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaComIva = Console.readInt("Indique qual a encomenda: ");
                        try{
                            System.out.println("Total com Iva: " + lj.getEncomendas().get(escolhaEncomendaComIva).calculaTotalComIva());
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                            pause();
                        }
                        pause();
                        break;
                
                case 6:
                        // VER TOTAL DA ENCOMENDA SEM IVA
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaSemIva = Console.readInt("Indique qual a encomenda: ");
                        try{
                            System.out.println("Total sem Iva: " + lj.getEncomendas().get(escolhaEncomendaSemIva).calculaTotalSemIva());
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                            pause();
                        }
                        pause();
                        break;
                
                case 7:
                        // Adicionar produtos a encomenda existente
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaAdicionarProduto = Console.readInt("Indique qual a encomenda: ");
                        Encomenda encomAdicionarProduto = lj.getEncomendas().get(escolhaEncomendaAdicionarProduto);
                        
                        
                        Produto p = new Produto();
                        
                        
                        float preco = (float)Console.readInt("Qual o valor do produto? ");
                        try {
                            p.setPrecoSemIva(preco);
                        } catch (ValorInvalidoException e) {
                            System.out.println("Preco invalido! " + e.getMessage());
                            continue;
                        }
                        int taxaIva = Console.readInt("Qual a tava IVA [6, 13 ou 23]? ");
                        try {
                            p.setTaxaIva(taxaIva);
                        } catch (TaxaIvaInvalidaException e) {
                            System.out.println("Taxa IVA Invalida! " + e.getMessage());
                            continue;
                        }
                        int opcaoTipoProduto = Console.readInt("Digite [1] para Papel ou [2] para Plastico: ");
                            
                            if (opcaoTipoProduto == 1) {
                                ProdutoEmbalagemPapel papel = new ProdutoEmbalagemPapel("Embalagem Papel", preco, taxaIva);
                                try{
                                    encomAdicionarProduto.adicionarProduto(papel);
                                }catch(IndexOutOfBoundsException ex){
                                    System.out.println("\n !! ERRO: " + ex.getMessage());
                                    pause();
                                }
                            }
                            
                            else if (opcaoTipoProduto == 2) {
                                int taxaSuplementar = Console.readInt("Qual a taxa suplementar pelo plastico? ");
                                ProdutoEmbalagemPlastico plastico = new ProdutoEmbalagemPlastico("Embalagem Plastico", preco, taxaIva, taxaSuplementar);
                                try{
                                    encomAdicionarProduto.adicionarProduto(plastico);
                                }catch(IndexOutOfBoundsException ex){
                                    System.out.println("\n !! ERRO: " + ex.getMessage());
                                    pause();
                                }
                            }
                            else {
                                System.out.println("Opção inválida");
                            }
                
                        pause();
                        break;
                
                case 8:
                        // Remover produtos de encomenda existe
                        System.out.println("Lista de Encomendas");
                        for (int i = 0; i < lj.getEncomendas().size(); i++) {
                            Encomenda encomenda = lj.getEncomendas().get(i);
                            System.out.println(i + " - " + encomenda.getNomeCliente());
                        }
                        int escolhaEncomendaRemoverProduto = Console.readInt("Indique qual a encomenda: ");
                        Encomenda encomRemoverProduto = lj.getEncomendas().get(escolhaEncomendaRemoverProduto);
                        for (int i = 0; i < encomRemoverProduto.getProdutosEncomendados().size(); i++) {
                            System.out.println(i + " - " + encomRemoverProduto.getProdutosEncomendados().get(i).getDesignacao());                       
                        }
                        int produtoARemover = Console.readInt("Qual a produto a remover? ");
                        try{
                            encomRemoverProduto.removeProduto(produtoARemover);
                        }catch(IndexOutOfBoundsException ex){
                            System.out.println("\n !! ERRO: " + ex.getMessage());
                            pause();
                        }
                        break;
                                
                case 0:
                        System.out.println("Volte sempre");
                        pause();
                        break;
                default:
                        System.out.println("Opcao Invalida!!!!!");
                        pause();
            }
        }while(opcao != 0);
    }
}
