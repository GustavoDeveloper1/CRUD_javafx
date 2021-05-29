package Aplicacao;

import java.util.Date;
import dao.MercadoDAO;
import model.Produto;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MercadoDAO mercadoDao = new MercadoDAO();
		
		Produto produto = new Produto();
		
		produto.setNome_Produto("Macarrao");
		produto.setPreco_Produto(15.5);
		produto.setData_cadastro(new Date());
		
		
		mercadoDao.save(produto);
	}

}
