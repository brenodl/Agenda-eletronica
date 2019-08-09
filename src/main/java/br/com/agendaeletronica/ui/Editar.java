package br.com.agendaeletronica.ui;

import java.sql.Connection;

import org.apache.wicket.markup.html.basic.Label;

import br.com.agendaeletronica.model.Contato;
import br.com.agendaeletronica.model.ContatoDAO;


public class Editar extends Criar {

	private static final long serialVersionUID = -7015139871654484352L;

	public Editar(Contato contato) {
		super(contato);
		replace(new Label("titulo", "Edição de Contato"));
	}
	
	@Override
	protected void salvar(Contato contatoSubmetido) {
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.atualizar(contatoSubmetido);
	}
	
}
