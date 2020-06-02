package valoriCarte;

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

