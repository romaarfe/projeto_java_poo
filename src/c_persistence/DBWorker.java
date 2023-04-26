/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_persistence;


import b_business.Encomenda;
import b_business.Loja;
import b_business.Produto;
import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 13 - Rodrigo
 */
public class DBWorker {
    private Connection conn;
    
    
    public DBWorker(String servidor, String user, String password, String baseDados) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://" + servidor + "/" + baseDados + "?" + "user=" + user + "&password=" + password);
    }
    
    public void guardarProduto(Produto p) throws SQLException {
        
        String stringSQL = "INSERT INTO produto(designacao, precoSemIva, taxaIva) VALUES(?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setString(1, p.getDesignacao());
        pst.setFloat(2, p.getPrecoSemIva());
        pst.setInt(3, p.getTaxaIva());
        
        pst.executeUpdate();
        
        if (pst != null) {
            pst.close();
        }
    }
    
    public void guardarEncomenda(Encomenda e) throws SQLException {
        
        String stringSQL = "INSERT INTO encomenda(cliente, data) VALUES(?, ?)";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setString(1, e.getNomeCliente());
        pst.setDate(2, (Date) e.getData());
       
        
        pst.executeUpdate();
        
        if (pst != null) {
            pst.close();
        }
    }
    
    public void guardarLoja(Loja l) throws SQLException {
        
        String stringSQL = "INSERT INTO loja(designacao) VALUES(?)";
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        pst.setString(1, l.getDesignacao());
       
        pst.executeUpdate();
        
        if (pst != null) {
            pst.close();
        }
    }
    
    
    public ArrayList<Produto> getAllProdutos() throws SQLException, TaxaIvaInvalidaException, ValorInvalidoException {
        ArrayList<Produto> produtos = new ArrayList<>();
        
        String stringSQL = "SELECT * FROM produto";
        
        PreparedStatement pst = conn.prepareStatement(stringSQL);
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
            Produto p = new Produto();
            p.setDesignacao(rs.getString("designacao"));
            p.setPrecoSemIva(rs.getFloat("precoSemIva"));
            p.setTaxaIva(rs.getInt("taxaIva"));
            
            produtos.add(p);
        }
        
        if (pst != null) {
            pst.close();
        }
        
        return produtos;
    }
    
}
