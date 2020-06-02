package carta;

import util.mylib.BelleStringhe;
import util.mylib.CharMenu;
import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Manager {
	private static final String SCELTA_SPECIFICHE_MAZZO = "\nScegli il tipo di mazzo : ";
	private static final String FICHE_ESAURITE = "Spiacente HAI FINITO TUTTE LE FICHE ,devi smettere di giocare!!!";
	private static final char MONETA = '£';
	private static final String REGISTRAZIONE_GIOCATORE = "inserisci il tuo nome prego :";

	private static final int VALORE_FICHE_INZIALE = 100;
	private static final String WARNING_ACCOUNT_BALANCE = "sei davvero sicuro di voler cambiare altre fiche ?";
	private final static String MESS_GOODBYE = BelleStringhe.incorniciaCentrato("Arrivederci", 16 + 3);
	private final static String MESS_WELCOME = BelleStringhe.stampaStringaCorniceCentrato(String.format(
			"BENVENUTO AL CASINO'%nHai scelto il tavolo di CARTA PIU'ALTA%nRegistrati per ottenere le FICHE del credito iniziale"));

	
	
	public static TipoMazzo sceltaTipoMazzo() {
		MyMenu sceltaMazzo = new MyMenu("MAZZI DISPONIBILI", TipoMazzo.values());
		sceltaMazzo.stampaMenu();
		int scelta = InputDati.leggiIntero(SCELTA_SPECIFICHE_MAZZO, 1, TipoMazzo.values().length);
		switch (scelta) {
		case 1:
			System.out.println(String.format("si gioca con Mazzo %s", TipoMazzo.ITALIANO));
			return (TipoMazzo.ITALIANO);

		case 2:
			System.out.println(String.format("si gioca con Mazzo %s", TipoMazzo.FRANCESE));
			return (TipoMazzo.FRANCESE);
		case 3:
			System.out.println(String.format("si gioca con Mazzo %s", TipoMazzo.TEDESCO));
			return (TipoMazzo.TEDESCO);
		case 4:
			System.out.println(
					String.format("si gioca con Mazzo %s, coi punti di %s", TipoMazzo.ITALIANO, TipoMazzo.BRISCOLA));
			return (TipoMazzo.BRISCOLA);

		}
		return null;

	}

	public static void gioca() {
		printWelcome();
		Partita unaScommessa = introPartita();
		do {
			// InputDati.yesOrNo("estrai una carta");
			if (InputDati.yesOrNo("Estrai una carta")) {
				Carta cartaGiocatore = unaScommessa.estraiCarta();
				System.out
						.println(BelleStringhe.stampaStringaCorniceCentrato(
								String.format("Hai estratto la carta %s %nIl tuo attuale credito ammonta a: %d %c %n",
										cartaGiocatore.toString(), unaScommessa.getCredito(), MONETA),
								BelleStringhe.GRADO));
				int puntata = InputDati.leggiIntero("Quante fiche punti su questa carta ?:", 1,
						unaScommessa.getCredito());
				System.out.println("\nFiche puntata valore :" + puntata + MONETA);
				Carta cartaBanco = unaScommessa.estraiCarta();
				System.out.println(BelleStringhe.stampaStringaCorniceCentrato(
						String.format("Carta del BANCO %n %s", cartaBanco.toString()), BelleStringhe.GRADO));
				Banco esito = unaScommessa.scommetti(puntata, cartaGiocatore, cartaBanco);
				esitoGiocata(esito, unaScommessa);
			} else {
				System.out.println("Smetti di puntare dunque");
				if (newPlay() == false) {
					System.out.println("Prima di uscire puoi andare a cambiare le tue fiche");
					System.out.println( MESS_GOODBYE + unaScommessa.getNomeGiocatore()+" esce con  "+unaScommessa.getCredito()+MONETA);
					return ;
				}
			}
		} while (!unaScommessa.isFinita());
		System.out.println(FICHE_ESAURITE);

	}

	private static void esitoGiocata(Banco esito, Partita unaScommessa) {

		switch (esito) {
		case perde:
			System.out.println(
					String.format("Il BANCO HA PERSO il giocatore %s VINCE!!!%n", unaScommessa.getNomeGiocatore()));
			System.out.println(String.format("Nuovo credito giocatore %d%c", unaScommessa.getCredito(), MONETA));
			break;

		case vince:
			System.out.println(
					String.format("il BANCO HA  VINTO il giocatore %s PERDE!!%n", unaScommessa.getNomeGiocatore()));
			System.out.println(String.format("Nuovo credito giocatore %d%c", unaScommessa.getCredito(), MONETA));
			break;

		case pareggia:
			System.out.println("PARITA'!!!\n");
			System.out.println(String.format("Credito giocatore invariato %d%c", unaScommessa.getCredito(), MONETA));
			break;
		default:
			break;
		}

	}

	public static Partita introPartita() {
		String nomeGiocatore = InputDati.leggiStringaNonVuota(REGISTRAZIONE_GIOCATORE);
		nomeGiocatore = nomeGiocatore.toUpperCase();
		int creditoIniziale = VALORE_FICHE_INZIALE;
		System.out.println(BelleStringhe.stampaStringaCorniceCentrato(String.format(
				"Molto bene  %s sei pronto. %n "
						+ "Puoi giocare fino ad esurimento delle fiche che hai cambiato per una somma pari a : "
						+ " %n%d %c  %n" + " %n adesso procedi a scegliere le specifiche di gioco >>>>> ",
				nomeGiocatore.toString(), creditoIniziale, MONETA), BelleStringhe.STELLA));

		return new Partita(nomeGiocatore, creditoIniziale, sceltaTipoMazzo());
	}

	/**
	 * Prints welcome message
	 */
	public static void printWelcome() {
		System.out.println((MESS_WELCOME));
	}

	/**
	 * Prints a goodbye message
	 */
	public static void printGoodbye() {
		System.out.println(MESS_GOODBYE);
	}

	public static boolean newPlay() {
		System.out.println();
		return InputDati.yesOrNo("Vuoi giocare ancora ? ");
	}

}