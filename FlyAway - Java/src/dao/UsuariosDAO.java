package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConnectionMySQL;
import model.Usuario;

public class UsuariosDAO {

	// CREATE
	public void save(Usuario usuarios) {

		String sql = "INSERT INTO usuario (nome_usuario, email_usuario, senha_usuario) VALUES (?, ?, ?)";

		// Conecta
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuarios.getNome_usuario());
			pstm.setString(2, usuarios.getEmail_usuario());
			pstm.setString(3, usuarios.getSenha_usuario());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Fecha a conexões
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	// READ
	public List<Usuario> getUsuario() {

		String sql = "SELECT * FROM usuario";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Recupera dados do bd
		ResultSet rset = null;

		try {
			// conecta no bd
			conn = ConnectionMySQL.createConnectionMySQL();

			// executa query
			pstm = conn.prepareStatement(sql);

			// pega o resultado da query
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();

				usuario.setId_usuario(rset.getInt("id_usuario"));
				usuario.setNome_usuario(rset.getString("nome_usuario"));
				usuario.setEmail_usuario(rset.getString("email_usuario"));
				usuario.setSenha_usuario(rset.getString("senha_usuario"));
				
				usuarios.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

				if (rset != null) {
					rset.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}

	// UPDATE

	public void update(Usuario usuario) {

		String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome_usuario());
			pstm.setString(2, usuario.getEmail_usuario());
			pstm.setString(3, usuario.getSenha_usuario());
			pstm.setInt(4, usuario.getId_usuario());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// DELETE
	public void delete(int id) {
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}