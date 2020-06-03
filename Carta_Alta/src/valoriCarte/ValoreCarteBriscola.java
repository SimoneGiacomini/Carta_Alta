package valoriCarte;

/** Indentifica i valori delle carte di briscola */
public enum ValoreCarteBriscola implements IValoreCarta {

	ASSO(11, "ASSO"), DUE(0, "DUE"), TRE(10, "TRE"), QUATTRO(0, "QUATTRO"), CINQUE(0, "CINQUE"), SEI(0, "SEI"), SETTE(0,
			"SETTE"), FANTE(2, "FANTE"), CAVALLO(3, "CAVALLO"), RE(4, "RE");

	private String nome;
	private int valore;

	/**
	 * Costruttore
	 * 
	 * @param valore
	 *            e' il valore in punti che la specifica carta avra'
	 * @param nome
	 *            e' il nome della carta
	 */
	private ValoreCarteBriscola(int valore, String nome) {
		this.nome = nome;
		this.valore = valore;
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
