package valoriCarte;
/**Indentifica i valori delle carte Tedesche
 * @author francesca*/
public enum ValoreCarteTedesche implements IValoreCarta {
	ASSO(14, "DAUS_ASSO"),
    SEI(7, "SEI"),
	SETTE(8, "SETTE"),
	OTTO(9, "OTTO"),
	NOVE(10, "NOVE"),
	DIECI(10,"DIECI"),
	VALLETTO(11, "VALLETTO"),
	DONNA(12, "DAMA"),
	RE(13, "RE");
	
	private int valore;
	private String nome;
	
	/**
	 * Costruttore
	 * 
	 * @param valore
	 *            e' il valore in punti che la specifica carta avra'
	 * @param nome
	 *            e' il nome della carta
	 */
	ValoreCarteTedesche(int valore, String nome) {
		this.valore = valore;
		this.nome = nome;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getValore() {
		return valore;
	}
	

}

