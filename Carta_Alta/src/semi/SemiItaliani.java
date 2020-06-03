package semi;

import interfaceSemi.SemeCarte;

public enum SemiItaliani implements SemeCarte{
	COPPE("COPPE"),
	DENARI("DENARI"), 
	SPADE("SPADE"), 
	BASTONI("BASTONI");

	private String seme;
	/**Costruttore*/
	SemiItaliani(String seme) {
		this.seme = seme;
	}

	public String getSeme() {
		return seme;
	}

}