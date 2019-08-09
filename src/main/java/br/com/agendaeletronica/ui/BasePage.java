package br.com.agendaeletronica.ui;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class BasePage extends WebPage {

	private static final long serialVersionUID = -9203704355705999755L;

	public BasePage() {
		String userName = (String) getSession().getAttribute("userName");
		if (userName == null) {
			setResponsePage(Login.class);
			return;
		}

		add(new Link<Void>("sair") {

			private static final long serialVersionUID = 6662147488195682723L;

			@Override
			public void onClick() {
				getSession().invalidate();
				setResponsePage(Inicio.class);
			}
		});
	}
}
