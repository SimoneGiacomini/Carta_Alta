package mazzo;

import interfaceSemi.SemeCarte;
import semi.SemiFrancesi;
import semi.SemiItaliani;
import semi.SemiTedeschi;
import valoriCarte.IValoreCarta;
import valoriCarte.ValoreCarteTedesche;
import valoriCarte.ValoreCarteBriscola;
import valoriCarte.ValoreCarteFrancesi;
import valoriCarte.ValoreCarteItaliane;

public enum TipoMazzo {
	ITALIANO("ITALIANO", SemiItaliani.values(), ValoreCarteItaliane.values()),
	
	FRANCESE("FRANCESE", SemiFrancesi.values(), ValoreCarteFrancesi.values()),
	
	
	TEDESCO("TEDESCO", SemiTedeschi.values(),ValoreCarteTedesche.values()),
	
	BRISCOLA("BRISCOLA",SemiItaliani.values(),ValoreCarteBriscola.values());
	
	private String nome;
	private SemeCarte[] semi;
	private IValoreCarta[] valori;
	/**Costruttore 
	 * @param name*/
	TipoMazzo(String nome, SemeCarte[] semi, IValoreCarta [] valori){
		this.nome = nome;
		this.valori = valori;
		this.semi = semi;
	}
	/**@return il nome che ha quel {@code TipoMazzo}*/
	public String getNome() {
		return nome;
	}
/**@return i vari semi di quel {@code TipoMazzo}*/
	public SemeCarte[] getSemi() {
		return semi; 
	}
	/**@return i vari Valori di quel {@code TipoMazzo}*/
	public IValoreCarta[] getValori() {
		return valori;
	}
	}
	


