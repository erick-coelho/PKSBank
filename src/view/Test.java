package view;

import helper.Utils;
import model.Cliente;
import model.Conta;

public class Test {

	public static void main(String[] args) {
		
		Cliente felicity = new Cliente 
				("Felicity Jones", 
				 "felicity@email.com", 
				 "123.456.789.00", 
				 Utils.stringParaDate("17/06/1991")
				 );
		Cliente claudio = new Cliente 
				( "claudo Brando",
				  "claudio@email.com",
				  "009.876.543.21",
				  Utils.stringParaDate("24/12/1961")
				);
		
		Conta c1 = new Conta(felicity);
		Conta c2 = new Conta(claudio);
		
		c1.setLimite(200);
		c2.setLimite(50);

		c1.depositar(500);
		c2.depositar(0);
		
		System.out.println();
		
		c1.sacar(600);
		c2.sacar(20);
		
		System.out.println();
		
		c1.transferir(c2, 100);
		
		System.out.println();
		
		System.out.println(c1);
		System.out.println();
		System.out.println(c2);
	}

}
