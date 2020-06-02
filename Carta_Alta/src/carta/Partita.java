package carta;



public class Partita{
	
	
	private int credito =0;
	
	

	private String giocatore ;
	private Mazzo mazzoScelto;
	
	public Partita(String _scommettitore,int _denaro,Mazzo mazzoScelto){
		this.giocatore = _scommettitore;
		this.credito =_denaro;
		this.mazzoScelto = mazzoScelto;
		
	}
	
	public Carta estraiCarta() {
		return this.mazzoScelto.estrai();
	}

	public Mazzo getMazzoScelto() {
		return mazzoScelto;
	}
	public Mazzo setMazzoScelto() {
		return this.mazzoScelto =Manager.sceltaMazzo();
	}


	

	public String getNomeGiocatore() {
		return giocatore;
	}
	
	
	public int getCredito() {
		return this.credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}
	public boolean haiPerso() {
		return this.credito <= 0;
	}
	
	
	
	
	public  Banco scommessa(Carta cartaGiocatore , Carta cartaBanco,int incasso ) {
		int risultato =cartaGiocatore.compareTo(cartaBanco) ;
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
