package br.com.agendaeletronica.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agendaeletronica.enums.EstadoCivilEnum;

public class ContatoDAO {

	private static final String INSERT_SQL = "INSERT INTO Contato (NOME, SOBRENOME, EMAIL, TELEFONE, ENDERECO, CEP, ESTADO_CIVIL) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final static String UPDATE_SQL = "UPDATE Contato SET NOME=?, SOBRENOME=?, EMAIL=?, TELEFONE=?, ENDERECO=?, CEP=?, ESTADO_CIVIL=? WHERE ID_CONTATO=?";
	private static final String LIST_SQL = "SELECT ID_CONTATO, NOME, SOBRENOME, EMAIL, TELEFONE, ENDERECO, CEP, ESTADO_CIVIL FROM Contato WHERE NOME LIKE ?";

	private Connection conexao;

	public ContatoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void inserir(Contato contato) {
		PreparedStatement ps = null;
		try {
			ps = conexao.prepareStatement(INSERT_SQL);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getSobrenome());
			ps.setString(3, contato.getEmail());
			ps.setString(4, contato.getTelefone());
			ps.setString(5, contato.getEndereco());
			ps.setString(6, contato.getCep());
			ps.setString(7, contato.getEstadoCivil().name());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void atualizar(Contato contato) {
		PreparedStatement p = null;
		try {
			p = conexao.prepareStatement(UPDATE_SQL);
			p.setString(1, contato.getNome());
			p.setString(2, contato.getSobrenome());
			p.setString(3, contato.getEmail());
			p.setString(4, contato.getTelefone());
			p.setString(5, contato.getEndereco());
			p.setString(6, contato.getCep());
			p.setString(7, contato.getEstadoCivil().name());
			p.setLong(8, contato.getId());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (p != null) {
				try {
					p.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public List<Contato> listarPorNome(String nome) {
		List<Contato> contatos = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conexao.prepareStatement(LIST_SQL);
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Contato contato = new Contato();
				
				contato.setId(rs.getLong(1));
				contato.setNome(rs.getString(2));
				contato.setSobrenome(rs.getString(3));
				contato.setEmail(rs.getString(4));
				contato.setTelefone(rs.getString(5));
				contato.setEndereco(rs.getString(6));
				contato.setCep(rs.getString(7));
				contato.setEstadoCivil(EstadoCivilEnum.valueOf(rs.getString(8)));
				contatos.add(contato);
			}
			return contatos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}

	}
}
