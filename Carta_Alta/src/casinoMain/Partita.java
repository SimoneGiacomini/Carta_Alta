package casinoMain;

import mazzo.Banco;
import mazzo.Mazzo;
import mazzo.TipoMazzo;

public class Partita {

	private int credito = 0;
	private String giocatore;
	private Mazzo mazzoScelto;

	private Partita(String _scommettitore, int _denaro, Mazzo mazzoScelto) {
		this.giocatore = _scommettitore;
		setCredito(_denaro);
		setMazzoScelto(mazzoScelto);
	}
	public Partita(String _scommettitore, int _denaro, TipoMazzo mazzo) {
		this(_scommettitore,_denaro,new Mazzo(mazzo));
	}

	public Partita(String _scommettitore, int _denaro) {
		this(_scommettitore,_denaro,TipoMazzo.FRANCESE);
	}
	public Carta estraiCarta() {
		return this.mazzoScelto.estrai();
	}

	public Mazzo getMazzoScelto() {
		return mazzoScelto;
	}

	private void setMazzoScelto(Mazzo mazzo) {
		if(mazzo.equals(null))
			throw new NullPointerException("Il mazzo e' nullo");
		this.mazzoScelto = mazzo;
	}

	public String getNomeGiocatore() {
		return giocatore;
	}

	public int getCredito() {
		return this.credito;
	}

	private void setCredito(int credito) {
		if(credito<1)
			throw new IllegalArgumentException("Il credito non può essere negativo");
		this.credito = credito;
	}

	public boolean isFinita() {
		return this.credito <= 0;
	}

	public Banco scommetti( int incasso,Carta cartaGiocatore, Carta cartaBanco) {
		int risultato = cartaGiocatore.compareTo(cartaBanco);
		if (risultato > 0) {
			this.credito = credito + incasso;
			return Banco.perde;
		} else if (risultato == 0) {
			return Banco.pareggia;
		}
		this.credito = credito - incasso;
		return Banco.vince;
	}

	@Override
	public String toString() {
		return "Partita [credito=" + credito + ", giocatore=" + giocatore + ", mazzoScelto=" + mazzoScelto + "]";
	}

}
