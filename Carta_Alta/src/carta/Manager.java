package carta;


import util.mylib.CharMenu;
import util.mylib.EstrazioniCasuali;
import util.mylib.InputDati;
import util.mylib.MyMenu;
import util.mylib.OutputArray;

public class Manager {
	
	public static void sceltaMazzo(){
	MyMenu sceltaMazzo = new CharMenu("scelta del tipo si mazzo",TipoMazzo.values());
	int  scelta = TipoMazzo.values().length;
	
	switch (scelta=sceltaMazzo.scegli()) {
	case 1:
	case 'F':
		System.out.println("");
	
		
		break;
	case 2:
	case 'I':
		
		break;
	case 3:
	case 'T':
		;
		break;
	}
	
    
}
