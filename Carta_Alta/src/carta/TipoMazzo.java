package carta;

import interfaceSemi.SemeCarte;

public enum TipoMazzo {
	ITALIANO("ITALIANO", SpecificheCarteItaliane.SEMI.values(), SpecificheCarteItaliane.values()),
	
	FRANCESE("FRANCESE", SpecificheCarteFrancesi.SEMI.values(), SpecificheCarteFrancesi.values()),
	TEDESCO("TEDESCO", SpecificheCarteTedesche.SEMI.values(),SpecificheCarteTedesche.values());
	
	private String name;
	private SemeCarte[] semi;
	private IValoreCarta[] valori;
	
	TipoMazzo(String name, SemeCarte[] semi, IValoreCarta[] valori){
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
