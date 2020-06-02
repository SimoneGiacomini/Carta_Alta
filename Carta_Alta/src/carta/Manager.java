package carta;

import util.mylib.BelleStringhe;
import util.mylib.CharMenu;
import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Manager {
	private static final String SCELTA_SPECIFICHE_MAZZO = "scegli il tipo di mazzo:";
	private static final String FICHE_ESAURITE = "Spiacente HAI FINITO TUTTE LE FICHE ,devi smettere di giocare!!!";
	private static char moneta = '£';
	private static final String REGISTRAZIONE_GIOCATORE = "inserisci il tuo nome prego :";
			
	private static final int VALORE_FICHE_INZIALE = 100;
	private static final String WARNING_ACCOUNT_BALANCE = "sei davvero sicuro di voler cambiare altre fiche ?";
	private final static String frame = "********************************************************";
	private final static String MESS_GOODBYE = "\n ARRIVEDERCI \n  ";
	private final static String MESS_WELCOME = "               BENVENUTO AL CASINO'\n    hai scelto il tavolo di CARTA PIU'ALTA\n   registrati per ottenere le FICHE del credito iniziale >>>\n ";

	
		
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
	printWelcome();
	Partita unaScommessa = introPartita();
do {
	InputDati.yesOrNo("estrai una carta");
	Carta cartaGiocatore = unaScommessa.getMazzoScelto().estrai();
	System.out.println( BelleStringhe.stampaStringaCorniceCentrato(String.format("hai estratto la carta %s %n"
			+ "il tuo attuale credito ammonta a: %d %c %n"
			,cartaGiocatore.toString(),unaScommessa.getCredito(),moneta),BelleStringhe.GRADO));
     int puntata = InputDati.leggiIntero("quanto fiche punti su questa carta ?:", 1, unaScommessa.getCredito());
	 System.out.println("fiche puntata valore :"+ puntata+moneta);
     Carta cartaBanco = unaScommessa.getMazzoScelto().estrai();
     System.out.println(BelleStringhe.stampaStringaCorniceCentrato(String.format("Carta del BANCO %n %s",cartaBanco.toString()),BelleStringhe.GRADO));
     Banco esito = unaScommessa.scommessa(cartaGiocatore, cartaBanco,puntata);
     esitoGiocata(esito, unaScommessa);
     
	} while (!unaScommessa.haiPerso());
			System.out.println(FICHE_ESAURITE);
	
		
}

	private static void esitoGiocata(Banco esito,Partita unaScommessa) {
		
		switch (esito) {
		case perde:
			System.out.println(String.format(("il BANCO HA PERSO il giocatore " + unaScommessa.getNomeGiocatore()+" VINCE!!!\n " )));
			System.out.println(String.format(" nuovo credito giocatore " + unaScommessa.getCredito() + "" + moneta));
			break;

		case vince:
			System.out.println(String.format("il BANCO HA  VINTO il giocatore " +  unaScommessa.getNomeGiocatore().toString() + " PERDE!!\n"));
			System.out.println(String.format("nuovo credito giocatore " + unaScommessa.getCredito() + "" + moneta));
			break;

		case pareggia:
			System.out.println("PARITA'!!!\n");
			System.out.println(String.format("credito giocatore invariato " +unaScommessa.getCredito(), moneta));
			break;
		default:
			break;
		}
		
	}
	public static  Partita introPartita() {
	     String nomeGiocatore = InputDati.leggiStringaNonVuota(REGISTRAZIONE_GIOCATORE);
	     nomeGiocatore =nomeGiocatore.toUpperCase();
	    int creditoIniziale = VALORE_FICHE_INZIALE;
		System.out.println(BelleStringhe.stampaStringaCorniceCentrato(String.format("molto bene  %s sei pronto %n "
				+ " puoi giocare fino ad esurimento delle fiche che hai cambiato per una somma pari a : "
				+ " %n%d %c  %n"
				+ " %n adesso procedi a scegliere le specifiche di gioco >>>>>%n ",nomeGiocatore.toString(),creditoIniziale,moneta),BelleStringhe.STELLA));
	    Mazzo mazzoScelto = sceltaMazzo();
		return new Partita(nomeGiocatore,creditoIniziale,mazzoScelto);
	}
	/**
	* Prints welcome message
	*/
	public static void printWelcome() {
		System.out.println(frame);
		System.out.println(MESS_WELCOME);
		System.out.println(frame);
	}

	/**
	 * Prints a goodbye message
	 */
	public static void printGoodbye() {
		System.out.println(frame);
		System.out.println(MESS_GOODBYE);
		System.out.println(frame);
	}
}