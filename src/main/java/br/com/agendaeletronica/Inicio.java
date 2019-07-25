package br.com.agendaeletronica;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class Inicio extends WebPage {
	
	private static final long serialVersionUID = 8270423525180506580L;
	
	public Inicio(){
		
		Label labelMensagemBoasVindas = new Label("mensagemBoasVindas",Model.of("Bem vindo à agenda eletrônica!"));
		add(labelMensagemBoasVindas);
		
	}
	

	
	
	
}