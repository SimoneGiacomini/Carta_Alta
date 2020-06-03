package semi;

import interfaceSemi.SemeSimboloCarte;

public enum SemiFrancesi implements SemeSimboloCarte {
	CUORI("CUORI", '\u2665'), QUADRI("QUADRI", '\u2666'), PICCHE("PICCHE", '\u2660'), FIORI("FIORI", '\u2663');

	private String seme;
	private char simbolo;
/**Costruttore*/
	SemiFrancesi(String seme, char simbolo) {
		this.seme = seme;
		this.simbolo = simbolo;
	}

	public String getSeme() {
		return seme;
	}
/**@return {@linkplain String} tipo {@linkplain #seme}+{@link #simbolo}*/
	public String toString() {
		return seme + simbolo ;
	}

	public char getSimbolo() {
		return simbolo;
	}
}