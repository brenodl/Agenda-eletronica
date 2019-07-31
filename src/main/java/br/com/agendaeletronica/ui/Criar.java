package br.com.agendaeletronica.ui;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import br.com.agendaeletronica.model.Contato;

public class Criar extends BasePage {

	private static final long serialVersionUID = -3849716323774882716L;

	public Criar() {

		add(new Label("titulo", "Criação de Contato"));

		CompoundPropertyModel<Contato> compoundPropertyModelContrato = new CompoundPropertyModel<Contato>(new Contato());
		Form<Contato> form = new Form<Contato>("formularioContato", compoundPropertyModelContrato) {

			private static final long serialVersionUID = 5613201142178594391L;

			@Override
			public void onSubmit() {
				Contato contatoSubmetido = getModelObject();
				System.out.println("Contato a inserir: " + contatoSubmetido);
				setResponsePage(Inicio.class);
			}
		};
		add(form);

		TextField<String> inputNome = new TextField<String>("nome");
		TextField<String> inputEmail = new TextField<String>("email");
		TextField<String> inputTelefone = new TextField<String>("telefone");
		form.add(inputNome, inputEmail, inputTelefone);
	}

}
