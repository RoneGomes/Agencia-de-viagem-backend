
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {

		

		String sql = "INSERT INTO cliente_login (nome,cpf,email,data_nascimento,usuario,senha)" + " VALUES(?,?,?,?,?,?)";

		try {
			
			conn = AgenciaConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, cliente.getNome());
		
			pstm.setString(2, cliente.getCpf());
		
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getDataNascimento());
			pstm.setString(5, cliente.getLogin().getUsuario());
			pstm.setString(6, cliente.getLogin().getSenha());
	
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

	public void removeBySenha(String senha) {

		String sql = "DELETE FROM cliente_login WHERE senha = ?";

		try {
			conn = AgenciaConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, senha);

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

	public void update(Cliente cliente) {
		String sql = "UPDATE cliente_login SET nome = ?, cpf = ?, email = ?, data_nascimento = ?,usuario = ? " + "WHERE senha = ?";
		try {

			conn = AgenciaConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getDataNascimento());
			pstm.setString(5, cliente.getLogin().getUsuario());
			pstm.setString(6, cliente.getLogin().getSenha());

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

	public List<Cliente> getCliente() {

		String sql = "SELECT * FROM  Cliente_login";

		List<Cliente> clientes = new ArrayList<Cliente>();


		ResultSet rset = null;

		try {
			conn = AgenciaConexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

	
			while (rset.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setEmail(rset.getString("email"));
				cliente.setDataNascimentoo(rset.getString("data_nascimento"));                       
				cliente.getLogin().setUsuario(rset.getString("usuario")); 
				
				cliente.getLogin().setSenha(rset.getString("senha"));

				
				clientes.add(cliente);
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

		return clientes;
	}

}
