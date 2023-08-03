package model;

import java.util.Date;

import helper.Utils;

public class Cliente {
	private static int contador = 1;
	
	private int codigo;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
	private Date dataCadastro;
	
	public Cliente(String nome, String email, String cpf, Date dataNascimento) {
		this.codigo = Cliente.contador++;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = new Date();
	}
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataCadastro() {
		return this.dataCadastro;
	}
	
	public String toString() {
		return "codigo: " + this.getCodigo()
				+ "\nnome: " + this.getNome()
				+ "\nemail: " + this.getEmail()
				+ "\ncpf: " + this.getCpf()
				+ "\nnascimento: " + Utils.dateParaString(this.getDataNascimento())
				+ "\ncadastro: " + Utils.dateParaString(this.getDataCadastro());
	}
}
