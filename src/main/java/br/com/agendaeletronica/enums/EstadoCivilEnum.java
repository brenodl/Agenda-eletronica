package br.com.agendaeletronica.enums;

public enum EstadoCivilEnum {
	
	SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUVO("Viúvo");
	
	private final String label;

	private EstadoCivilEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
