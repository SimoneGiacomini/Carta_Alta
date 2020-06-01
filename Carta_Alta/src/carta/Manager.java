package carta;

import util.mylib.CharMenu;
import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Manager {
	private static final String FICHE_ESAURITE = "Spiacente hai finito le tue Fiche,devi smettere di giocare";
	private static char moneta = '£';
	private static final String REGISTRAZIONE_GIOCATORE = "registrati per ottenere le FISHE del credito iniziale"
			+ "il tuo nome prego:";
	private static final int VALORE_FICHE_INZIALE = 100;
	private static final String WARNING_ACCOUNT_BALANCE = "sei davvero sicuro di voler cambiare altre fiche ?";
	
//	
//	public static Mazzo sceltaTipoMazzo() {
//     MyMenu<TipoMazzo> mazzoScelto = new MyMenu<>("con che tipo di mazzo desideri scommettere ?",TipoMazzo.values());
//			int scelta = mazzoScelto.scegli();
//			do
//			switch (scelta) {
//			
//			
//	}while(scelta!=0);
//			return null;
//}
	


	
	
	
	
	public static TipoMazzo sceltaMazzo() {
		MyMenu sceltaMazzo = new MyMenu("scelta del tipo si mazzo", TipoMazzo.values());
		int scelta = sceltaMazzo.scegli();

		switch (scelta) {
		case 1:
		     System.out.println("Italiano");
			return TipoMazzo.ITALIANO;

		case 2:
		     System.out.println("Francese");
		     return TipoMazzo.FRANCESE;
		case 3:
			System.out.println("Tedesco");
			return TipoMazzo.TEDESCO;
		}
		return null;
		
	}

	public static void gioca() {
		String giocatore = InputDati.leggiStringaNonVuota(REGISTRAZIONE_GIOCATORE);
		boolean continua;
		while (continua = true) {

			int sommainzialeFish = VALORE_FICHE_INZIALE;
			Mazzo mazzoScelto = new Mazzo(sceltaMazzo());
			Partita scommetti = new Partita(giocatore, sommainzialeFish, mazzoScelto);
			do {
				
				Carta cartaGiocatore = scommetti.estraiCarta();
				int puntata = scommetti
						.puntata(InputDati.leggiIntero(
								String.format(
										"la tua carta :" + cartaGiocatore.toString() + "il tuo credito attuale :"
												+ scommetti.getCredito() + "quanto scommetti ?"),
								1, scommetti.getCredito()));
				Carta cartaBanco = scommetti.estraiCarta();
				scommetti.scommessa(cartaGiocatore, cartaBanco, puntata);
			    //esitoGiocata(scommetti);

			} while (scommetti.haiPerso());
			System.out.println(FICHE_ESAURITE);
		}
		continua = InputDati.yesOrNo(WARNING_ACCOUNT_BALANCE);
	}

	private static Banco esitoGiocata(Partita giocatore) {
		Banco esito = null;
		switch (esito) {
		case perde:
			System.out.println(String.format(("il banco ha perso il giocatore %s" + giocatore + "VINCE")));
			System.out.println(String.format("credito giocatore %d" + giocatore.getCredito() + "%c" + moneta));
			break;

		case vince:
			System.out.println(String.format("il banco ha vinto il giocatore %s" + giocatore + "PERDE"));
			System.out.println(String.format("credito giocatore %d" + giocatore.getCredito() + "%c" + moneta));
			break;

		case pareggia:
			System.out.println("PARITA'");
			System.out.println(String.format("credito giocatore %d" +giocatore.getCredito() + "%c" + moneta));
			break;
		default:
			break;
		}
		return esito;
	}
}