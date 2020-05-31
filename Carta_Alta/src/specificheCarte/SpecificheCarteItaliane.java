package carta;

import interfaceSemi.SemeCarte;

public enum SpecificheCarteItaliane implements IValoreCarta {
	ASSO(13, "ASSO"),
	DUE(2, "DUE"),
	TRE(3, "TRE"),
	QUATTRO(4, "QUATTRO"),
	CINQUE(5, "CINQUE"),
	SEI(6, "SEI"),
	SETTE(7, "SETTE"),
	FANTE(8, "FANTE"),
	CAVALLO(9, "CAVALLO"),
	RE(10, "RE");
	
	private int valore;
	private String nome;
	
	SpecificheCarteItaliane(int valore, String nome) {
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
	enum SEMI implements SemeCarte{
		COPPE("COPPE"),
		DENARI("DENARI"), 
		SPADE("SPADE"), 
		BASTONI("BASTONI");

		private String seme;
		
		SEMI(String seme) {
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
	
}
