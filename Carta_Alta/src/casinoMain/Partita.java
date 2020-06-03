package casinoMain;

import mazzo.Carta;
import mazzo.Mazzo;
import mazzo.TipoMazzo;

public class Partita {

	private int credito = 0;
	private String giocatore;
	private Mazzo mazzoScelto;

	/**
	 * Costruttore utilizzato inizialmente, ma inutilizzato perche' faceva conflitto
	 * nei test
	 */
	@SuppressWarnings("unused")
	private Partita(String _scommettitore, int _denaro, Mazzo mazzoScelto) {
		this.giocatore = _scommettitore;
		setCredito(_denaro);
		setMazzoScelto(mazzoScelto);
	}

	/**
	 * Costruttore di una partita
	 * 
	 * @param scommettitore
	 *            e' il nome dello scommettitore
	 * @param denaro
	 *            e' il denaro iniziale di una nuova partita
	 * @param mazzo
	 *            e' il mazzo da usare per tutta la partita
	 */
	public Partita(String scommettitore, int denaro, TipoMazzo mazzo) {
		this.giocatore = scommettitore;
		setCredito(denaro);
		setTipoMazzo(mazzo);
	}

	/**
	 * Costruttore che crea una nuova partita utilizzando sempre il
	 * {@linkplain TipoMazzo#FRANCESE}
	 * 
	 * @param scommettitore
	 *            e' il nome dello scommettitore
	 * @param denaro
	 *            e' il denaro iniziale di una nuova partita
	 *
	 */
	public Partita(String scommettitore, int denaro) {
		this(scommettitore, denaro, TipoMazzo.FRANCESE);
	}

	/**
	 * Estrae casualmente una {@linkplain Carta} da {@code questo}
	 * {@linkplain Mazzo}
	 */
	public Carta estraiCarta() {
		return this.mazzoScelto.estrai();
	}

	/** @return il tipo di mazzo scelto */
	public String getMazzoScelto() {
		return mazzoScelto.getTipoDiMazzo();
	}

	/**
	 * Metodo che setta il {@linkplain TipoMazzo} scelto
	 * 
	 * @param mazzo
	 *            ovvero il {@linkplain TipoMazzo}
	 * @throws IllegalArgumentException
	 *             se mazzo e' null
	 */
	private void setTipoMazzo(TipoMazzo mazzo) {
		if (mazzo == null)
			throw new IllegalArgumentException("Il tipo di mazzo NON puo' essere nullo");
		this.mazzoScelto = new Mazzo(mazzo);

	}

	/**
	 * Metodo che setta il {@linkplain Mazzo} scelto
	 * 
	 * @param mazzo
	 *            ovvero il {@linkplain Mazzo} da settare
	 * @throws IllegalArgumentException
	 *             se mazzo e' null
	 */
	private void setMazzoScelto(Mazzo mazzo) {
		if (mazzo == (null))
			throw new IllegalArgumentException("Il mazzo e' nullo");
		this.mazzoScelto = mazzo;
	}

	/** @return il nome del giocatore */
	public String getNomeGiocatore() {
		return giocatore;
	}

	/** @return il credito disponibile */
	public int getCredito() {
		return this.credito;
	}

	/**
	 * Metodo che setta il credito passato
	 * 
	 * @param credito
	 *            ovvero il credito da settare
	 * @throws IllegalArgumentException
	 *             se il credito non e' positivo
	 */
	private void setCredito(int credito) {
		if (credito < 1)
			throw new IllegalArgumentException("Il credito non può essere negativo");
		this.credito = credito;
	}

	/**
	 * @return true se la partita e' finita (il {@link #credito}e' <=0), altrimenti
	 *         false
	 */
	public boolean isFinita() {
		return this.credito <= 0;
	}

	/**
	 * Metodo che permette di scommettere tra due carte.<br>
	 * Se la {@code cartaGiocatore} e' di punteggio maggiore di quella del
	 * <b>Banco</b> allora il giocatore incassa la <b>{@code puntata }</B>ed il
	 * <b>Banco</b> perde;<br>
	 * viceversa il {@link #giocatore} perde la puntata dal suo {@link #credito} ed
	 * il <b>Banco</b> vince
	 * 
	 * @param puntata
	 *            quanto il {@link #giocatore} punta
	 * @param cartaGiocatore
	 *            e' la {@linkplain Carta} che ha il {@link #giocatore}
	 * @param cartaBanco
	 *            e' la {@linkplain Carta} che ha il <b>{@code Banco}</B>
	 * @return {@linkplain Banco} con il messaggio
	 */
	public Banco scommetti(int puntata, Carta cartaGiocatore, Carta cartaBanco) {
		int risultato = cartaGiocatore.compareTo(cartaBanco);
		if (risultato > 0) {
			this.credito = credito + puntata;
			return Banco.perde;
		} else if (risultato == 0) {
			return Banco.pareggia;
		}
		this.credito = credito - puntata;
		return Banco.vince;
	}


	@Override
	public String toString() {
		return "Partita: credito disponibile = " + credito + "\nNome Giocatore = " + giocatore + "\nMazzo Scelto = "
				+ getMazzoScelto();
	}

}
