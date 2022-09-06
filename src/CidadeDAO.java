
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public List<Cidade> getCidades() {

		String sql = "SELECT * FROM  Cidade";

		List<Cidade> cidades = new ArrayList<Cidade>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = AgenciaConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Cidade cidade = new Cidade();

				// Recupera o id do banco e atribui ele ao objeto
				cidade.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				cidade.setNome(rset.getString("nome_cidade"));

				// Recupera a idade do banco e atribui ele ao objeto
				cidade.setCategoria(rset.getString("categoria"));               

				// Recupera a data do banco e atribui ela ao objeto
				cidade.setPais(rset.getString("pais"));
				
				cidade.setAeroporto(rset.getString("aeroporto"));                    
				
				

				// Adiciono o contato recuperado, a lista de contatos
				cidades.add(cidade);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

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

		return cidades;
	}
	public Cidade searchBYId(String nome) {
		ResultSet rset = null;
		Cidade cidade = new Cidade();
		String sql = "SELECT *FROM cidade WHERE nome_cidade = ?";

		try {
			conn = AgenciaConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, nome);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {

				

				// Recupera o id do banco e atribui ele ao objeto
				cidade.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				cidade.setNome(rset.getString("nome_cidade"));

				// Recupera a idade do banco e atribui ele ao objeto
				cidade.setCategoria(rset.getString("categoria"));

				// Recupera a data do banco e atribui ela ao objeto
				cidade.setAeroporto(rset.getString("pais"));
				
				cidade.setPais(rset.getString("aeroporto"));

				
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
		return cidade;
	}

}
