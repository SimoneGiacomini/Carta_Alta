package carta;

public class Carta implements Comparable<Carta> {
	IValoreCarta valoreCarta;
	String seme;

	public Carta(String seme, IValoreCarta valore) {
		this.seme = seme;
		this.valoreCarta = valore;
	}

	public int getValore() {
		return valoreCarta.getValore();
	}

	@Override
	public String toString() {
		return "[" + this.seme + "]: " + this.valoreCarta.getNome() + " (" + getValore() + ")";
	}
/** @return Ordina dalle carte con valore pi� basso a quelle pi� alto 2-3-4-5-6-7-FANTE,CAVALLO,RE-ASSO*/
	@Override
	public int compareTo(Carta other) {
		return this.getValore() - other.getValore();
	}
	
	//Carta carta1=new Carta(CUORI,1);
	//Carta carta2= new Carta(CUORI,2);
	//carta2.compareTo();
}

