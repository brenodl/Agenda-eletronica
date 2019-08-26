package br.com.agendaeletronica.model;

import java.io.Serializable;

import br.com.agendaeletronica.enums.EstadoCivilEnum;

public class Contato implements Serializable {

	private static final long serialVersionUID = -7904779829735820081L;

	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String cep;
	private String endereco;
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	private String telefone;
	private EstadoCivilEnum estadoCivil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}
	
	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Override
    public String toString() {
        return "{Contato: nome='" + nome + "' email='" + email + "' telefone='" + telefone + "' estadoCivil='" + estadoCivil.name() + "'}";
    }

}
