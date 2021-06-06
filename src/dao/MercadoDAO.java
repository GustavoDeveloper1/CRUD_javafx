package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import factory.ConnectionFactory;
import model.Produto;

public class MercadoDAO {

	/*
	 * CRUD CREATED READ UPDATE DELETE
	 */

	public void save(Produto produto) {
		String sql = "INSERT INTO Produto(nome_Produto,preco_Produto,data_cadastro) VALUES (?,?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

		
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, produto.getNome_Produto());
			pstm.setDouble(2, produto.getPreco_Produto());
			pstm.setDate(3, new Date(produto.getData_cadastro().getTime()));

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void update(Produto produto) {
		String sql = "UPDATE Produto SET nome_Produto = ?, preco_Produto=?,data_cadastro=?"+ "WHERE id_Produto=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, produto.getNome_Produto());			
			pstm.setDouble(2, produto.getPreco_Produto());
			pstm.setDate(3, new Date(produto.getData_cadastro().getTime()));
			pstm.setInt(4,produto.getId_Produto());
		
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
	
	public void deleteById(int id_Produto) {
		String sql = "DELETE FROM Produto WHERE id_Produto =?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm= (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1,id_Produto);
			
			pstm.execute();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
				}catch(Exception e ) {
					e.printStackTrace();
				}
			}
		}
		
	
	
	public  List<Produto> getProdutos(){
		String sql = "SELECT * FROM Produto";

		List<Produto> produtos = new ArrayList<Produto>();

		Connection conn = null;

		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Produto produto = new Produto();

				// recuperar os dados
				produto.setId_Produto(rset.getInt("id_produto"));
				produto.setNome_Produto(rset.getString("nome_produto"));
				produto.setPreco_Produto(rset.getDouble("preco_produto"));
				produto.setData_cadastro(rset.getDate("data_cadastro"));

				produtos.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return produtos;
	}


}
