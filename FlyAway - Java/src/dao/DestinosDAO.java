package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.ConnectionMySQL;
import model.Destinos;

public class DestinosDAO {

	// CREATE
	public void save(Destinos destinos) {

		String sql = "INSERT INTO destinos (nome_destino) VALUES (?)";

		// Conecta
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destinos.getNome_destino());

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
	public List<Destinos> getDestinos() {

		String sql = "SELECT * FROM destinos";

		List<Destinos> destinos = new ArrayList<Destinos>();

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
				Destinos destino = new Destinos();

				destino.setId_destino(rset.getInt("id_destino"));
				destino.setNome_destino(rset.getString("nome_destino"));

				destinos.add(destino);
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
		return destinos;
	}

	// UPDATE

	public void update(Destinos destino) {

		String sql = "UPDATE Destinos SET nome_destino = ?, preco_destino = ? WHERE id_destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome_destino());
			pstm.setDouble(2, destino.getPreco_destino());
			pstm.setInt(3, destino.getId_destino());

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
		String sql = "DELETE FROM Destinos WHERE id_destino = ?";

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
