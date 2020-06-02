package carta;

import util.mylib.BelleStringhe;
import util.mylib.CharMenu;
import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Manager {
	private static final String SCELTA_SPECIFICHE_MAZZO = "scegli il tipo di mazzo:";
	private static final String FICHE_ESAURITE = "Spiacente hai finito le tue Fiche,devi smettere di giocare";
	private static char moneta = '£';
	private static final String REGISTRAZIONE_GIOCATORE = " Benvenuto ,registrati per ottenere le FICHE del credito iniziale"
			+ "il tuo nome prego:";
	private static final int VALORE_FICHE_INZIALE = 100;
	private static final String WARNING_ACCOUNT_BALANCE = "sei davvero sicuro di voler cambiare altre fiche ?";
	
	
		
	public static Mazzo sceltaMazzo() {
		MyMenu sceltaMazzo = new MyMenu(SCELTA_SPECIFICHE_MAZZO, TipoMazzo.values());
		int scelta = sceltaMazzo.scegli();
        switch (scelta) {
		case 1:
		     System.out.println(String.format("si gioca con Mazzo %s", TipoMazzo.ITALIANO));
			return  new Mazzo(TipoMazzo.ITALIANO);

		case 2:
			System.out.println(String.format("si gioca con Mazzo %s", TipoMazzo.FRANCESE));
		     return  new Mazzo(TipoMazzo.FRANCESE);
		case 3:
			System.out.println(String.format("si gioca con Mazzo %s", TipoMazzo.TEDESCO));
			 return  new Mazzo(TipoMazzo.TEDESCO);
		}
		return null;
	}

	public static void gioca() {
	Partita unaScommessa = introPartita();
    Carta cartaGiocatore =unaScommessa.getMazzoScelto().estrai();
    System.out.println("carta"+cartaGiocatore);
//				
	
//				int puntata =
//						unaScommessa.puntata(InputDati.leggiIntero(
//								String.format(
//										"la tua carta :" + cartaGiocatore.toString() + "il tuo credito attuale :"
//												+ unaScommessa+ "quanto scommetti ?")));
//				Carta cartaBanco = mazzoScelto.estrai();
//				
//			scommetti.scommessa(cartaGiocatore, cartaBanco, puntata);
//			    //esitoGiocata(scommetti);
//		} while (unaScommessa.haiPerso());
//			System.out.println(FICHE_ESAURITE);
//	}
//		
	}

	private static Banco esitoGiocata(Partita unaScommessa) {
		Banco esito = null;
		switch (esito) {
		case perde:
			System.out.println(String.format(("il banco ha perso il giocatore %s" + unaScommessa.getNomeGiocatore().toString() + "VINCE")));
			System.out.println(String.format("credito giocatore %d" + unaScommessa.getCredito() + "%c" + moneta));
			break;

		case vince:
			System.out.println(String.format("il banco ha vinto il giocatore %s" +  unaScommessa.getNomeGiocatore().toString() + "PERDE"));
			System.out.println(String.format("credito giocatore %d" + unaScommessa.getCredito() + "%c" + moneta));
			break;

		case pareggia:
			System.out.println("PARITA'");
			System.out.println(String.format("credito giocatore %d %c" +unaScommessa.getCredito(), moneta));
			break;
		default:
			break;
		}
		return esito;
	}
	public static  Partita introPartita() {
	     String nomeGiocatore = InputDati.leggiStringaNonVuota(REGISTRAZIONE_GIOCATORE);
	     nomeGiocatore =nomeGiocatore.toUpperCase();
	    int creditoIniziale = VALORE_FICHE_INZIALE;
		System.out.println(BelleStringhe.stampaStringaCorniceCentrato(String.format("molto bene  %s sei pronto %n "
				+ " gioca fino ad esurimento delle fiche che hai cambiato per una somma pari a : "
				+ " %n%d %c  %n"
				+ " %n adesso procedi a scegliere le specifiche di gioco >>>>>%n ",nomeGiocatore.toString(),creditoIniziale,moneta),BelleStringhe.GRADO));
	    Mazzo mazzoScelto = sceltaMazzo();
		return new Partita(nomeGiocatore,creditoIniziale,mazzoScelto);
	}
}