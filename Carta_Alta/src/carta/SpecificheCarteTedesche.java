package carta;


import interfaceSemi.SemeSimboloCarte;

public enum SpecificheCarteTedesche implements IValoreCarta {
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
	
	SpecificheCarteTedesche(int valore, String nome) {
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
	enum SEMI implements SemeSimboloCarte{
		CUORI("CUORI",'\u2665'),
		CAMPANELLE("CAMPANELLE",'\u237E'), 
		GHIANDE("GHIANDE",'\u235D'), //
		FOGLIE("FOGLIE",'\u2766');

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
		@Override
		public String toString() {
			
			return seme + simbolo;
		}
		public char getSimbolo() {
			return simbolo;
		}

	}
	

}

