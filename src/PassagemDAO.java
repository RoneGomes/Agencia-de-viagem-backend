import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class PassagemDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Passagem passagem) {


		String sql = "INSERT INTO passagem (dataPassagem,hora_partida,hora_chegada,origem,destino,tipoDeVoo,valor,bagagem,nome_cliente,cpf)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			
			conn = AgenciaConexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, passagem.getData());
			pstm.setString(2, passagem.getHoraPartida());
			pstm.setString(3, passagem.getHoraChegada());
			pstm.setString(4, passagem.getOrigem());
			pstm.setString(5, passagem.getDestino());
			pstm.setString(6, passagem.getTiDeVoo());
			pstm.setDouble(7, passagem.getValor());
			pstm.setString(8, passagem.getBagagem());
			pstm.setString(9, passagem.getCliente().getNome());
			pstm.setString(10, passagem.getCliente().getCpf());
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

	public void removeBYId(int id) {
		String sql = "DELETE FROM passagem WHERE id = ?";

		try {
			conn = AgenciaConexao.createConnectionToMySQL();

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

	public Passagem searchBYId(int id) {
		ResultSet rset = null;
		Passagem passagem = new Passagem();
		String sql = "SELECT *FROM passagem WHERE id = ?";

		try {
			conn = AgenciaConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			while (rset.next()) {

				passagem.setId(rset.getInt("id"));
				passagem.setData(rset.getString("dataPassagem"));
				passagem.setHoraPartida(rset.getString("hora_partida"));
				passagem.setHoraChegada(rset.getString("hora_chegada"));
				passagem.setOrigem(rset.getString("origem"));
				passagem.setDestino(rset.getString("destino"));
				passagem.setTiDeVoo(rset.getString("tipoDeVoo"));
				passagem.setValor(rset.getDouble("valor"));
				passagem.setBagagem(rset.getString("bagagem"));
				passagem.setCpf(rset.getString("cpf"));

			}

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
		return passagem;
	}

	public void update(Passagem passagem) {
		String sql = "UPDATE passagem SET nome_cliente = ?, data = ?,hora_partida = ?,hora_chegada = ?,origem = ?,destino = ?,tipoDeVoo = ?,valor = ?,bagagem = ?,cpf = ? " + "WHERE id = ?";
		try {				

			conn = AgenciaConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, passagem.getNomeCliente());
			pstm.setString(2, passagem.getData());
			pstm.setString(3, passagem.getHoraPartida());
			pstm.setString(4, passagem.getHoraChegada());
			pstm.setString(5, passagem.getOrigem());
			pstm.setString(6, passagem.getDestino());
			pstm.setString(7, passagem.getTiDeVoo());
			pstm.setDouble(8, passagem.getValor());
			pstm.setString(9, passagem.getBagagem());
			pstm.setString(10, passagem.getNomeCliente());
			pstm.setString(11, passagem.getCpf());
			pstm.setInt(12, passagem.getId());

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
