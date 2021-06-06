package Aplicacao;

import java.util.Date;
import dao.MercadoDAO;
import model.Produto;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MercadoDAO mercadoDao = new MercadoDAO();
		
		Produto produto = new Produto();
		
		produto.setNome_Produto("merge");
		produto.setPreco_Produto(4.50);
		produto.setData_cadastro(new Date());
		
		
		//mercadoDao.save(produto);
		
		Produto p1= new Produto();
		p1.setNome_Produto("queijo");
		p1.setPreco_Produto(5.30);
		p1.setData_cadastro(new Date());
		p1.setId_Produto(5);
		
	mercadoDao.update(p1);
		
		/*DELETANDO PRODUTO*/
		
		//mercadoDao.deleteById(8);
		
		//visualizacao dos registros
		for(Produto p : mercadoDao.getProdutos()) {
			System.out.println("Id: "+p.getId_Produto() + "Produto: " + p.getNome_Produto() +" | "+ " Preço: " + p.getPreco_Produto() +" | " + " Data de Registro: " + p.getData_cadastro());
		}
		
	}

}
