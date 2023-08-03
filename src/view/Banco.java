package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Banco {
	
	static String nome = "PKSBank";
	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contas;

	public static void main(String[] args) {
		Banco.contas = new ArrayList<>();
		Banco.menu();
		
		

	}

	private static void menu() {
		System.out.println("==========================================================");
		System.out.println("======================== " + Banco.nome +" =========================");
		System.out.println("==================== ESCOLHA UMA OPÇÃO: ==================");
		System.out.println("1 - Criar Conta");
		System.out.println("2 - Efetuar saque");
		System.out.println("3 - Efetuar Deposito");
		System.out.println("4 - Efetuar Transferencia");
		System.out.println("5 - Listar contas");
		System.out.println("0 - Sair");
		
		String input = Banco.teclado.nextLine();
		
		switch (input) {
		case "1":
			Banco.criarConta();
			break;
		case "2":
			Banco.efetuarSaque();
			break;
		case "3":
			Banco.efetuarDeposito();
			break;
		case "4":
			Banco.efetuarTransferencia();
			break;
		case "5":
			Banco.listarContas();
			break;
		case "0":
			Banco.Sair();
			break;
		default:
			Banco.ValorInvalido();
			break;
		}
	}

	private static void ValorInvalido() {
		System.out.println("==========================================================");
		System.out.println("================= INSIRA UM VALOR VALIDO =================");
		System.out.println("==========================================================");
		Utils.pausar(2);
		Banco.menu();
		
	}
	//concluido
	private static void Sair() {
		System.out.println("==========================================================");
		System.out.println("================== APLICAÇÃO ENCERRADA ===================");
		System.out.println("==========================================================");
		System.exit(0);
		
	}
	
	//concluido
	private static void listarContas() {
		System.out.println("==========================================================");
		System.out.println("===================== LISTAR CONTAS ======================");
		System.out.println("==========================================================");
		
		if(Banco.contas.size() == 0) {
			System.out.println("NENHUMA CONTA CADASTRADA NO SISTEMA");
			Utils.pausar(2);
			Banco.menu();
		} else {
			for(int i=0; i < Banco.contas.size(); i++) {
				System.out.println(Banco.contas.get(i) + "\n");
			}	
		}
		
		Utils.pausar(2);
		Banco.menu();
		
	}

	//concluido
	private static void efetuarTransferencia() {
		System.out.println("==========================================================");
		System.out.println("================= EFETUAR TRANSFERÊNCIA ==================");
		System.out.println("==========================================================");
		
		Conta c = Banco.verificarConta();
		
		if(c == null) {
			System.out.println("NÃO FOI POSSÍVEL ENCONTRAR A CONTA");		
		} else { 
			System.out.println("CONTA PARA TRANSFERENCIA");
			Conta c2 = Banco.verificarConta();
			
			System.out.println("TRANSFERINDO DE " + c.getCliente().getNome() + " PARA " + c2.getCliente().getNome());
			Utils.pausar(2);
			
			System.out.println("DIGITE O VALOR PARA TRANSFERÊNCIA");
			try {
				double valor = Banco.teclado.nextDouble();
				c.transferir(c2, valor);				
			} catch (InputMismatchException e) {
				System.out.println("INSIRA UM VALOR VÁLIDO");
			}
		}
		
		Utils.pausar(2);
		Banco.menu();
		
	}
	
	//concluido
	private static void efetuarDeposito() {
		System.out.println("==========================================================");
		System.out.println("==================== EFETUAR DEPÓSITO ====================");
		System.out.println("==========================================================");
		
		Conta c = Banco.verificarConta();
		
		if(c == null) {
			System.out.println("NÃO FOI POSSÍVEL ENCONTRAR A CONTA");
				
		} else {
			System.out.println("EFETUANDO DEPOSITO NA CONTA:");
			System.out.println(c);
			Utils.pausar(2);
			
			System.out.println("\nVALOR DO DEPÓSITO:");
			
			try {
				double deposito = Banco.teclado.nextDouble();
				c.depositar(deposito);					
			} catch (InputMismatchException e) {
				System.out.println("INSIRA UM VALOR VÁLIDO");
			}
		}	
		Utils.pausar(2);
		Banco.menu();
	}

	//concluido
	private static Conta verificarConta() {
		Conta c = null;
		System.out.println("digite o numero da conta:");
		String numConta = Banco.teclado.nextLine();
		
		if(Banco.contas.size() == 0) {
			System.out.println("\nNÃO HÁ CONTAS CADASTRADAS NO SISTEMA");
			Utils.pausar(2);
			Banco.menu();
		} else {
			for(int i = 0; i < Banco.contas.size(); i++) {
				if(Integer.parseInt(numConta) == Banco.contas.get(i).getNumero()) {
					c = Banco.contas.get(i);
				}
			}		
		}
		return c;
		
	}

	//concluido
	private static void efetuarSaque() {
		System.out.println("==========================================================");
		System.out.println("===================== EFETUAR SAQUE ======================");
		System.out.println("==========================================================");
		
		Conta c = Banco.verificarConta();
		
		if(c == null) {
			System.out.println("NÃO FOI POSSÍVEL ENCONTRAR A CONTA");
		} else {
			System.out.println("EFETUANDO SAQUE NA CONTA: ");
			System.out.println(c);
			Utils.pausar(2);
			
			System.out.println("\nVALOR DO SAQUE:");
		}
			
		
		Utils.pausar(2);
		Banco.menu();
		
	}
	
	//Pronto
	private static void criarConta() {
		System.out.println("==========================================================");
		System.out.println("====================== CRIAR CONTA =======================");
		System.out.println("==========================================================");
		
		System.out.println("informe os dados do cliente:");
		
		System.out.println("nome:");
		String nome = Banco.teclado.nextLine();
		
		System.out.println("email:");
		String email = Banco.teclado.nextLine();
		
		System.out.println("CPF:");
		String cpf = Banco.teclado.nextLine();
		
		System.out.println("data de nascimento:");
		String nascimento = Banco.teclado.nextLine();
		
		if(Utils.validarNome(nome) 
		   && Utils.validarEmail(email) 
		   && Utils.validarCpf(cpf) 
		   && Utils.stringParaDate(nascimento) != null) {
			
			Cliente cliente = new Cliente(nome, email, cpf, Utils.stringParaDate(nascimento));
			System.out.println("Cliente cadastrado com sucesso");
			
			Conta conta = new Conta(cliente);
			
			Banco.contas.add(conta);
			System.out.println("Conta criada com sucesso!");
			System.out.println("Dados da conta: ");
			System.out.println("\n" + conta);
		} else {
			System.out.println("ERRO AO CADASTRAR TENTE NOVAMENTE");
		}
		
		
		
		
		Utils.pausar(5);
		Banco.menu();
			
		
	}

}


