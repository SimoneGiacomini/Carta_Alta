package semi;

import interfaceSemi.SemeSimboloCarte;

/**
 * @author Simone
 *
 */
public enum SemiTedeschi implements SemeSimboloCarte{
	CUORI("CUORI",'\u2665'),
	CAMPANELLE("CAMPANELLE",'\u237E'), 
	GHIANDE("GHIANDE",'\u235D'), //
	FOGLIE("FOGLIE",'\u2766');

	private String seme;
	private char simbolo;


	SemiTedeschi(String seme, char simbolo) {
		this.seme = seme;
		this.simbolo = simbolo;
	}


	/**
	 * @return the seme
	 */
	public String getSeme() {
		return seme;
	}
	@Override
	public String toString() {
		
		return seme + simbolo;
	}
	public char getSimbolo() {
		return simbolo;
	}

}