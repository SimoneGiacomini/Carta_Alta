package semi;

import interfaceSemi.SemeSimboloCarte;

public enum SemiFrancesi implements SemeSimboloCarte {
	CUORI("CUORI", '\u2665'), QUADRI("QUADRI", '\u2666'), PICCHE("PICCHE", '\u2660'), FIORI("FIORI", '\u2663');

	private String seme;
	private char simbolo;

	SemiFrancesi(String seme, char simbolo) {
		this.seme = seme;
		this.simbolo = simbolo;
	}

	/**
	 * @return the seme
	 */
	public String getSeme() {
		return seme;
	}

	public String toString() {
		return seme + simbolo ;
	}

	/**
	 * @return the simbolo
	 */
	public char getSimbolo() {
		return simbolo;
	}
}