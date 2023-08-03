package model;

import helper.Utils;

public class Conta {
	private static int codigo = 1001;
	
	private int numero;
	private Cliente cliente;
	private double saldo = 0.0;
	private double limite = 0.0;
	private double saldoTotal;
	
	public Conta(Cliente cliente) {
		this.cliente = cliente;
		
		this.numero = Conta.codigo++;
		this.setSaldoTotal();
	}
	
	



	public int getNumero() {
		return numero;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
		this.setSaldoTotal();
	}
	
	public double getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal() {
		this.saldoTotal = this.getSaldo() + this.getLimite();
		
	}
	
	public String toString() {
		return "numero: " + this.getNumero()
				+ "\ncliente: " + this.getCliente().getNome()
				+ "\nsaldo total: "+  Utils.doubleParaString(this.getSaldoTotal());
	}

	public void depositar(double valor) {
		if(valor > 0 ) {
			this.setSaldo(this.getSaldo() + valor);
			this.setSaldoTotal();
			System.out.println("deposito efetuado com sucesso!");

		} else {
			System.out.println("erro ao depositar");
		}
	}
	
	public void sacar(double valor) {
		if(valor > 0 && this.getSaldoTotal() >= valor) {
			if(this.getSaldo() >= valor) {
				this.setSaldo(this.getSaldo() - valor);
				this.setSaldoTotal();
				System.out.println("saque efetuado com sucesso");
			} else {
				Double restante = valor - this.getSaldo();
				this.setLimite(this.getLimite() - restante);
				this.setSaldo(0.0);
				this.setSaldoTotal();
				System.out.println("saque efetuado com sucesso");
			}
			
		} else { 
			System.out.println("saque não realizado.");
		}
	}
	
	public void transferir(Conta destino, double valor) {
		if(valor > 0 && this.getSaldoTotal() >= valor) {
			if(this.getSaldo() >= valor) {
				this.setSaldo(this.getSaldo() - valor);
				destino.setSaldo(destino.getSaldo() + valor);
				this.setSaldoTotal();
				destino.setSaldoTotal();
				System.out.println("transferencia realizada com sucesso");
			} else {
				Double restante = valor - this.getSaldo();
				this.setLimite(this.getLimite() - restante);
				this.setSaldo(0.0);
				this.setSaldoTotal();
				destino.setSaldo(destino.getSaldo() + valor);
				destino.setSaldoTotal();
				System.out.println("Transferencia realizada com sucesso");
			}
		} else {
			System.out.println("transferencia não realizada");
		}
	}
}
