package carta;

import interfaceSemi.SemeSimboloCarte;

public enum SpecificheCarteFrancesi implements IValoreCarta {
	ASSO(14, "ASSO"), DUE(2, "DUE"), TRE(3, "TRE"), QUATTRO(4, "QUATTRO"), CINQUE(5, "CINQUE"), SEI(6, "SEI"), SETTE(7,
			"SETTE"), OTTO(8,
					"OTTO"), NOVE(9, "NOVE"), DIECI(10, "DIECI"), JACK(11, "JACK"), DONNA(12, "DONNA"), RE(13, "RE");

	private int valore;
	private String nome;

	SpecificheCarteFrancesi(int valore, String nome) {
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

	enum SEMI implements SemeSimboloCarte {
		CUORI("CUORI", '\u2665'), QUADRI("QUADRI", '\u2666'), PICCHE("PICCHE", '\u2660'), FIORI("FIORI", '\u2663');

		private String seme;
		private char simbolo;

		SEMI(String seme, char simbolo) {
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
			return seme + simbolo;
		}

		/**
		 * @return the simbolo
		 */
		public char getSimbolo() {
			return simbolo;
		}
	}

}
