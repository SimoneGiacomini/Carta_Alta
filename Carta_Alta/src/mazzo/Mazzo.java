package mazzo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaceSemi.SemeCarte;
import util.mylib.EstrazioniCasuali;
import valoriCarte.IValoreCarta;

public class Mazzo {

	private List<Carta> listaCarte = new ArrayList<Carta>();
	private String tipoDiMazzo;

	/**
	 * Costruttore del mazzo
	 * 
	 * @param tipo
	 *            e' uno dei tipi presenti in {@linkplain TipoMazzo}
	 */
	public Mazzo(TipoMazzo tipo) {
		listaCarte = costruisciMazzo(tipo.getSemi(), tipo.getValori());
		tipoDiMazzo = tipo.getNome();
	}

	/**
	 * Costruisce il mazzo con tutte le sue {@linkplain Carta}, utilizzando i
	 * {@linkplain SemeCarte} e i valori di esse
	 * 
	 * @return una {@linkplain List} immodificabile
	 * @param semi
	 *            sono i semi da settare
	 * @param valori
	 *            sono i valori di ogni {@linkplain Carta}
	 * @author Simone
	 */
	private List<Carta> costruisciMazzo(SemeCarte[] semi, IValoreCarta[] valori) {
		List<Carta> result = new ArrayList<Carta>();
		for (SemeCarte seme : semi) {
			for (IValoreCarta valore : valori) {
				result.add(new Carta(seme.toString(), valore));
			}
		}
		return Collections.unmodifiableList(result);
	}

	/** Estrae una carta casualmente dal mazzo */
	public Carta estrai() {
		int estratto = EstrazioniCasuali.estraiIntero(0, listaCarte.size() - 1);
		return listaCarte.get(estratto);
	}

	/** Riordina il mazzo dalle carte con valore piu' basso a quelle piu' alte */
	public void ordinaMazzo() {

		listaCarte.sort(Carta::compareTo);
	}

	/**
	 * @return the tipoDiMazzo
	 */
	public String getTipoDiMazzo() {
		return tipoDiMazzo;
	}

}
