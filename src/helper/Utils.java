package helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Utils {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	static NumberFormat nf = new DecimalFormat("R$ #,##0.00",
			new DecimalFormatSymbols(new Locale("pt", "BR")));
	
	public static String dateParaString(Date data) {
		return Utils.sdf.format(data);
	}
	
	public static String doubleParaString(Double valor) {
		return Utils.nf.format(valor);
	}
	
	public static Double stringParaDouble(String s) {
		try {
			return (double) Utils.nf.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static void pausar(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			System.out.println("erro ao pausar.");
		}
	}

	public static Date stringParaDate(String string) {
		try {
			return Utils.sdf.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static boolean validarNome(String nome) {
		String regex = "^(?![ ])(?!.*[ ]{2})((?:e|da|do|das|dos|de|d'|D'|la|las|el|los)\\s*?|(?:[A-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð'][^\\s]*\\s*?)(?!.*[ ]$))+$";
		if(nome.matches(regex)) {
			return true;
		}
		return false;
	}
	
	public static boolean validarEmail(String email) {
		String regex= "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if(email.matches(regex)) {
			return true;
		}
		return false;
	}
	
	public static boolean validarCpf(String cpf) {
		String regex = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})";
		if(cpf.matches(regex)) {
			return true;
		}
		return false;
	}
}
