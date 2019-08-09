package br.com.agendaeletronica.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class Login extends WebPage {

	private static final long serialVersionUID = 2000737244342477774L;

	public Login() {
		
		final TextField<String> campoNomeUsuario = new TextField<String>("nomeUsuario", new Model<String>());
		final PasswordTextField campoPassword = new PasswordTextField("password", new Model<String>());

		final Label mensagemErroLogin = new Label("mensagemErroLogin", Model.of("Erro ao realizar login."));
		mensagemErroLogin.setOutputMarkupId(true).setVisible(false);

		Form<String> formularioLogin = new Form<String>("formularioLogin") {
			private static final long serialVersionUID = 8881526555984605535L;

			@Override
			public final void onSubmit() {
				String nomeUsuario = campoNomeUsuario.getModelObject();
				String senha = campoPassword.getModelObject();
				if (nomeUsuario.toUpperCase().equals("BRENO") && senha.equals("12345")) {
					getSession().setAttribute("userName", nomeUsuario);
					setResponsePage(Inicio.class);
				} else {
					mensagemErroLogin.setVisible(true);
				}
			}
		};
		add(formularioLogin);
		formularioLogin.add(campoNomeUsuario, campoPassword, mensagemErroLogin);
		
	}

}
