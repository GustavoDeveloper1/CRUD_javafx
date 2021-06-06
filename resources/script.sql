create database mercado;

create table Produto(
	id_Produto int(11) not null auto_increment primary key,
	nome_Produto varchar(10),
	preco_Produto double(11,2),
	data_cadastro date
);