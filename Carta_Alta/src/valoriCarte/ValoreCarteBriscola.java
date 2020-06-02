package valoriCarte;

public enum ValoreCarteBriscola implements IValoreCarta {
	
	ASSO(11, "ASSO"),
	DUE(0, "DUE"),
	TRE(10, "TRE"),
	QUATTRO(1, "QUATTRO"),
	CINQUE(1, "CINQUE"),
	SEI(1, "SEI"),
	SETTE(1, "SETTE"),
	FANTE(2, "FANTE"),
	CAVALLO(3, "CAVALLO"),
	RE(4, "RE");
	

	private String nome;
	private int valore;

	private ValoreCarteBriscola( int valore,String nome) {
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
