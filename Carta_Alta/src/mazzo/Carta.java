package mazzo;

import interfaceSemi.SemeCarte;
import valoriCarte.IValoreCarta;

/** Classe che identifica un unica carta */
public class Carta implements Comparable<Carta> {
	IValoreCarta valoreCarta;
	String seme;

	/**
	 * Costruttore
	 * 
	 * @param seme
	 *            e' il seme da assegnare a questa carta
	 * @param valore
	 *            e' il valore che questa carta ha
	 */
	public Carta(String seme, IValoreCarta valore) {
		this.seme = seme;
		this.valoreCarta = valore;
	}

	/** @return il valore di questa carta in termini di punti */
	public int getValore() {
		return valoreCarta.getValore();
	}

	/**
	 * @return il {@linkplain SemeCarte} ed il nome del valore della
	 *         {@linkplain Carta}
	 */
	@Override
	public String toString() {
		return "[" + this.seme + "]: " + this.valoreCarta.getNome();
	}

	/**
	 * @return il valore di {@code questa Carta} <b>{@code -}</b> il valore dell' altra carta
	 * @param altraCarta e' la carta con cui confrontare il valore
	 */
	@Override
	public int compareTo(Carta altraCarta) {
		return this.getValore() - altraCarta.getValore();
	}

}
