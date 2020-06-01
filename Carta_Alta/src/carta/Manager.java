package carta;


import util.mylib.CharMenu;
import util.mylib.EstrazioniCasuali;
import util.mylib.InputDati;
import util.mylib.MyMenu;
import util.mylib.OutputArray;

public class Manager {
	
	private static final String REGIATRAZIONE_GIOCATORE = "registrati per ottenere le FISHE del credito iniziale,+"
			+ "il tuo nome prego:";
	private static final int VALORE_FICHE_INZIALE = 100;
	public static TipoMazzo sceltaMazzo(){
	MyMenu sceltaMazzo = new CharMenu("scelta del tipo si mazzo",TipoMazzo.values());
	int  scelta=sceltaMazzo.scegli() ;
	
	switch (scelta) {
	case 1:
	case 'A':
		System.out.println("Italiano");
        return TipoMazzo.ITALIANO;
		
	case 2:
	case 'B':
		System.out.println("Francese");
		return TipoMazzo.FRANCESE;
	case 3:
	case 'C':
		System.out.println("Tedesco");
	     return TipoMazzo.TEDESCO;
	}
	return null;
    
	}
	private static void scommessa(Partita scommetti)
	 {
		inserisciGiocatore();
		
		do {
			Manager.sceltaMazzo();
//			Mazzo mazzo= new Mazzo(Manager.sceltaMazzo()) ;
//			InputDati.isInvioPremuto(mazzo.estrai());
			InputDati.isInvioPremuto(new Mazzo(Manager.sceltaMazzo()).estrai());
		 
		} while(scommetti.haiPerso());
	 }
	private static void inserisciGiocatore() {
		String giocatore = InputDati.leggiStringaNonVuota(REGIATRAZIONE_GIOCATORE);
		int sommainzialeFish =VALORE_FICHE_INZIALE;
	}

}