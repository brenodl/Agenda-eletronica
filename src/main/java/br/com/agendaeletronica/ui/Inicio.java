package br.com.agendaeletronica.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class Inicio extends BasePage {
	
	private static final long serialVersionUID = 8270423525180506580L;
	
	public Inicio() {
		Label labelMensagemBoasVindas = new Label("mensagemBoasVindas", Model.of("Bem vindo a agenda eletrônica!"));
		add(labelMensagemBoasVindas);
	}
}