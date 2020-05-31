package carta;

public enum ValoreCarteTedesche implements IValoreCarta {
	ASSO(14, "ASSO"),
	SETTE(7, "SETTE"),
	OTTO(8, "OTTO"),
	NOVE(9, "NOVE"),
	DIECI(10, "DIECI"),
	JACK(11, "VALLETTO"),
	DONNA(12, "DAMA"),
	RE(13, "RE");
	private int valore;
	private String nome;
	
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
