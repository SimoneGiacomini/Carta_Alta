package semi;

import interfaceSemi.SemeCarte;

public enum SemiItaliani implements SemeCarte{
	COPPE("COPPE"),
	DENARI("DENARI"), 
	SPADE("SPADE"), 
	BASTONI("BASTONI");

	private String seme;
	
	SemiItaliani(String seme) {
		this.seme = seme;
	}

	/**
	 * @return the seme
	 */
	public String getSeme() {
		return seme;
	}
	@Override
	public String toString() {
		
		return super.toString();
	}

}