package semi;

import interfaceSemi.SemeSimboloCarte;

/**
 * @author Francesca
 *
 */
public enum SemiTedeschi implements SemeSimboloCarte{
	CUORI("CUORI",'\u2665'),
	CAMPANELLE("CAMPANELLE",'\u237E'), 
	GHIANDE("GHIANDE",'\u235D'), //
	FOGLIE("FOGLIE",'\u2766');

	private String seme;
	private char simbolo;

	/**Costruttore*/
	SemiTedeschi(String seme, char simbolo) {
		this.seme = seme;
		this.simbolo = simbolo;
	}


	
	public String getSeme() {
		return seme;
	}
	/**@return {@linkplain String} tipo {@linkplain #seme}+{@link #simbolo}*/
	@Override
	public String toString() {
		
		return seme + simbolo;
	}
	public char getSimbolo() {
		return simbolo;
	}

}