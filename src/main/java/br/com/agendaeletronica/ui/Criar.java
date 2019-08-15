package br.com.agendaeletronica.ui;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.feedback.ErrorLevelFeedbackMessageFilter;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import br.com.agendaeletronica.enums.EstadoCivilEnum;
import br.com.agendaeletronica.model.Contato;
import br.com.agendaeletronica.model.ContatoDAO;

public class Criar extends BasePage {

	private static final long serialVersionUID = -6619311231415722854L;

	public Criar() {
		this(new Contato());
	}

	protected Criar(Contato contato) {
		add(new Label("titulo", "Criação de Contato"));
		CompoundPropertyModel<Contato> modelContrato = new CompoundPropertyModel<Contato>(contato);
		Form<Contato> form = new Form<Contato>("formularioContato", modelContrato) {
			private static final long serialVersionUID = -1620862938532623698L;

			@Override
			public void onSubmit() {
				Contato contatoSubmetido = getModelObject();
				salvar(contatoSubmetido);
				setResponsePage(Inicio.class);
			}
		};
		add(form);

		TextField<String> inputNome = new TextField<>("nome");
		TextField<String> inputEmail = new TextField<>("email");
		TextField<String> inputTelefone = new TextField<>("telefone");
		DropDownChoice<EstadoCivilEnum> comboEstadoCivil = new DropDownChoice<>("estadoCivil",
				Arrays.asList(EstadoCivilEnum.values()));
		form.add(inputNome, inputEmail, inputTelefone, comboEstadoCivil);
		
		   inputNome.setLabel(Model.of("Nome do contato")).setRequired(true).add(StringValidator.maximumLength(10));
	        inputEmail.setLabel(Model.of("E-mail do contato")).add(EmailAddressValidator.getInstance());
	        
	        add(new FeedbackPanel("feedbackMessage", new ErrorLevelFeedbackMessageFilter(FeedbackMessage.ERROR)));
	        
}

	protected void salvar(Contato contatoSubmetido) {
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.inserir(contatoSubmetido);
	}

}
