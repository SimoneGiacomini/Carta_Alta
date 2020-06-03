package casinoMain;

import mazzo.Carta;
import mazzo.TipoMazzo;
import util.mylib.BelleStringhe;

import util.mylib.InputDati;
import util.mylib.MyMenu;

public class Manager {
	private static final String CREDITO_GIOCATORE = "Credito giocatore";
	private static final String MAZZO_SCELTO = "Si gioca con Mazzo %s%n";
	private static final String SCELTA_SPECIFICHE_MAZZO = "Scegli il tipo di mazzo:";
	private static final String FICHE_ESAURITE = "Spiacente HAI FINITO TUTTE LE FICHE ,devi smettere di giocare!!!";
	private static final char MONETA = '£';
	private static final String REGISTRAZIONE_GIOCATORE = "Inserisci il tuo nome prego : ";

	private static final int VALORE_FICHE_INZIALE = 100;

	private final static String MESS_GOODBYE = BelleStringhe.stampaStringaCorniceCentrato("ARRIVEDERCI");
	private final static String MESS_WELCOME = BelleStringhe.stampaStringaCorniceCentrato(String.format(
			"BENVENUTO AL CASINO'%nHai scelto il tavolo di CARTA PIU'ALTA%nRegistrati per ottenere le FICHE del credito iniziale"));

	/**
	 * Metodo usato per la scelto del {@linkplain TipoMazzo} da usare nel casino'
	 * 
	 * @return il Tipo di mazzo da utilizzare nelle scommesse
	 */
	public static TipoMazzo sceltaTipoMazzo() {
		new MyMenu<TipoMazzo>("MAZZI DISPONIBILI", TipoMazzo.values()).stampaMenu();

		int scelta = InputDati.leggiIntero(SCELTA_SPECIFICHE_MAZZO, 1, TipoMazzo.values().length);
		switch (scelta) {
		case 1:
			System.out.println(String.format(MAZZO_SCELTO, TipoMazzo.ITALIANO));
			break;
		case 2:
			System.out.println(String.format(MAZZO_SCELTO, TipoMazzo.FRANCESE));
			break;
		case 3:
			System.out.println(String.format(MAZZO_SCELTO, TipoMazzo.TEDESCO));
			break;
		case 4:
			System.out.println(String.format(MAZZO_SCELTO, TipoMazzo.BRISCOLA));
			break;

		}
		return TipoMazzo.values()[scelta-1];

	}

	/** Metodo principale */
	public static void gioca() {
		printWelcome();
		Partita unaScommessa = introPartita();
		do {
			if (InputDati.yesOrNo("Estrai una carta")) {
			Carta cartaGiocatore = unaScommessa.estraiCarta();
			System.out
					.println(BelleStringhe.stampaStringaCorniceCentrato(
							String.format("Hai estratto la carta %s %n" + "il tuo attuale credito ammonta a: %d %c %n",
									cartaGiocatore.toString(), unaScommessa.getCredito(), MONETA),
							BelleStringhe.GRADO));
			int puntata = InputDati.leggiIntero("Quante fiche punti su questa carta ?:", 1, unaScommessa.getCredito());
			System.out.println("Fiche puntata valore :" + puntata + MONETA);
			Carta cartaBanco = unaScommessa.estraiCarta();
			System.out.println(BelleStringhe.stampaStringaCorniceCentrato(
					String.format("Carta del BANCO %n %s", cartaBanco.toString()), BelleStringhe.GRADO));
			Banco esito = unaScommessa.scommetti(puntata, cartaGiocatore, cartaBanco);
			esitoGiocata(esito, unaScommessa);
			}	else {
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
	/** Metodo che riassume i vari tipi di esiti che accadono in una giocata */
	private static void esitoGiocata(Banco esito, Partita unaScommessa) {

		switch (esito) {
		case perde:
			System.out.println(
					String.format("Il BANCO HA PERSO il giocatore %s VINCE!!!%n", unaScommessa.getNomeGiocatore()));
			System.out.println(String.format("Nuovo %s %d%c", CREDITO_GIOCATORE, unaScommessa.getCredito(), MONETA));
			break;

		case vince:
			System.out.println(
					String.format("il BANCO HA  VINTO il giocatore %s PERDE!!%n", unaScommessa.getNomeGiocatore()));
			System.out.println(String.format("Nuovo %s %d%c", CREDITO_GIOCATORE, unaScommessa.getCredito(), MONETA));
			break;

		case pareggia:
			System.out.println("PARITA'!!!\n");
			System.out
					.println(String.format("%s invariato %d%c", CREDITO_GIOCATORE, unaScommessa.getCredito(), MONETA));
			break;
		default:
			break;
		}

	}

	/**
	 * Metodo iniziale usato all'inizio<br>
	 * crea la {@linkplain Partita} con tutte le sue specifiche
	 */
	public static Partita introPartita() {
		String nomeGiocatore = InputDati.leggiStringaNonVuota(REGISTRAZIONE_GIOCATORE);
		nomeGiocatore = nomeGiocatore.toUpperCase();
		int creditoIniziale = VALORE_FICHE_INZIALE;
		System.out.println(BelleStringhe.stampaStringaCorniceCentrato(String.format(
				"Molto bene %s sei pronto.%n"
						+ "Puoi giocare fino ad esurimento delle fiche che hai cambiato,%nper una somma pari a : "
						+ "%d %c.%nAdesso procedi a scegliere le specifiche di gioco >>>>>%n ",
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
		System.out.println(BelleStringhe.incorniciaCentrato(MESS_GOODBYE, MESS_GOODBYE.length() + 3));
	}
	/**Chiede se si vuole continuare a giocare*/
	public static boolean newPlay() {
		System.out.println();
		return InputDati.yesOrNo("Vuoi giocare ancora in questo tavolo ? ");
	}

}