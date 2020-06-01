package carta;

public class Puntata {
	
	private static char moneta ='£';
	private int denaro =0;
	private String credito = "moneta +denaro";
	private String giocatore ;
	private TipoMazzo[]mazzoScelto;
	
	public Puntata(String _scommettitore,int _denaro,TipoMazzo[] _tipoMazzo){
		this.giocatore = _scommettitore;
		this.denaro =_denaro;
		this.mazzoScelto =_tipoMazzo;
		
	}
	

}
