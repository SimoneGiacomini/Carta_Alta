package carta;

import util.mylib.InputDati;
import util.mylib.OutputArray;

public class Main {
	
	public static void main(String[] args) {
		Mazzo mazzoIta= new Mazzo(TipoMazzo.FRANCESE) ;
		//Character[] semi= new Character[]{'\u2660',	'\u2663',	'\u2665',	'\u2666'};
		while (true) {
		InputDati.isInvioPremuto(mazzoIta.estrai().toString());
		System.out.println("\u1F0A0");
		}
	}
	
	
} 





