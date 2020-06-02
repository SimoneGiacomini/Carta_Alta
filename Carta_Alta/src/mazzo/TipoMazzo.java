package mazzo;

import interfaceSemi.SemeCarte;
import semi.SemiFrancesi;
import semi.SemiItaliani;
import semi.SemiTedeschi;
import valoriCarte.IValoreCarta;
import valoriCarte.SpecificheCarteTedesche;
import valoriCarte.ValoreCarteBriscola;
import valoriCarte.ValoreCarteFrancesi;
import valoriCarte.ValoreCarteItaliane;

public enum TipoMazzo {
	ITALIANO("ITALIANO", SemiItaliani.values(), ValoreCarteItaliane.values()),
	
	FRANCESE("FRANCESE", SemiFrancesi.values(), ValoreCarteFrancesi.values()),
	
	
	TEDESCO("TEDESCO", SemiTedeschi.values(),SpecificheCarteTedesche.values()),
	
	BRISCOLA("BRISCOLA",SemiItaliani.values(),ValoreCarteBriscola.values());
	
	private String name;
	private SemeCarte[] semi;
	private IValoreCarta[] valori;
	
	TipoMazzo(String name, SemeCarte[] semi, IValoreCarta [] valori){
		this.name = name;
		this.valori = valori;
		this.semi = semi;
	}
	
	public String getName() {
		return name;
	}

	public SemeCarte[] getSemi() {
		return semi; 
	}
	
	public IValoreCarta[] getValori() {
		return valori;
	}
	}
	


