package model;

import java.util.Date;

public class Produto {
	private int id_Produto;
	private String nome_Produto;
	private double preco_Produto;
	public int getId_Produto() {
		return id_Produto;
	}
	public void setId_Produto(int id_Produto) {
		this.id_Produto = id_Produto;
	}
	public String getNome_Produto() {
		return nome_Produto;
	}
	public void setNome_Produto(String nome_Produto) {
		this.nome_Produto = nome_Produto;
	}
	public double getPreco_Produto() {
		return preco_Produto;
	}
	public void setPreco_Produto(double preco_Produto) {
		this.preco_Produto = preco_Produto;
	}
	public Date getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	private Date data_cadastro;
}
