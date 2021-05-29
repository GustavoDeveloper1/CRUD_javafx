package dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Produto;

public class MercadoDAO {

	/*CRUD
	 * CREATED
	 * READ
	 * UPDATE
	 * DELETE
	 * */
	
	public void save(Produto produto) {
		String sql = "INSERT INTO Produto(nome_Produto,preco_Produto,data_cadastro) VALUES (?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			
			//CRIAR CONEXÃO COM O DB
			conn = ConnectionFactory.createConnectionToMySQL();
		
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			
			pstm.setString(1, produto.getNome_Produto());
			pstm.setDouble(2,produto.getPreco_Produto());
			pstm.setDate(3, new Date(produto.getData_cadastro().getTime()));
		
			 pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	}
}
