import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Passagem passagem = new Passagem();
		PassagemDAO passagemDAO = new PassagemDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		CidadeDAO cidadeDAO = new CidadeDAO();
	

	
		Scanner receba = new Scanner(System.in);
		int opcao, id;

		do {
			System.out.println("=========AGÊNCIA DE VIAGEM ==========");
			System.out.println("1- Cadastro de Usuario");
			System.out.println("2- Editar Usuário");
			System.out.println("3- Excluir Usuário");
			System.out.println("4- Comprar passagem");
			System.out.println("5- Cancelar passagem");
			System.out.println("6- Buscar Destinos");
			System.out.println("7- Sair");

			opcao = receba.nextInt();

			switch (opcao) {
			case 1: {

				System.out.println("Digite seu nome ");
				cliente.setNome(receba.next());
				System.out.println("Digite seu email ");
				cliente.setEmail(receba.next());
				System.out.println("Digite seu a data de nascimento ");
				cliente.setDataNascimentoo(receba.next());
				System.out.println("Digite seu cpf ");
				cliente.setCpf(receba.next());
				System.out.println("Digite seu usuário ");
				cliente.getLogin().setUsuario(receba.next());
				System.out.println("Digite sua senha ");
				cliente.getLogin().setSenha(receba.next());
			
				clienteDAO.save(cliente);

				System.out.println("usuario cadastrado");

				break;
			}

			case 2: {
				
				System.out.println("Digite seu nome ");
				cliente.setNome(receba.next());
				System.out.println("Digite seu email ");
				cliente.setEmail(receba.next());
				System.out.println("Digite seu a data de nascimento ");
				cliente.setDataNascimentoo(receba.next());
				System.out.println("Digite seu cpf ");
				cliente.setCpf(receba.next());
				System.out.println("Digite seu usuário ");
				cliente.getLogin().setUsuario(receba.next());
				System.out.println("Digite sua senha ");
				cliente.getLogin().setSenha(receba.next());

				clienteDAO.update(cliente);

				System.out.println("cliente atualizado");
				
				break;
			}
			case 3: {
				
				String senha;
				System.out.println("Digite a senha do usuario que deseja excluir");
				senha= receba.next();
				clienteDAO.removeBySenha(senha);
				System.out.println("usuario removido");
				break;

			}
			case 4: {
				
				passagem.setCliente(cliente);
				
				System.out.println("Digite a data ");
				passagem.setData(receba.next());
				System.out.println("Digite a hora da partida ");
				passagem.setHoraPartida(receba.next());
				System.out.println("Digite a hora de chegada ");
				passagem.setHoraChegada(receba.next());
				System.out.println("Digite a cidade de origem ");
				passagem.setOrigem(receba.next());
				System.out.println("Digite a cidade destino ");
				passagem.setDestino(receba.next());
				System.out.println("Digite o tipo de voo ");
				passagem.setTiDeVoo(receba.next());
				System.out.println("Digite o valor da passagem ");
				passagem.setValor(receba.nextDouble());
				System.out.println("Digite se tem bagagem ");
				passagem.setBagagem(receba.next());
		
				
				
				passagemDAO.save(passagem);
				
				System.out.println("usuario cadastrado");
				
				break;

			}
			
			case 5:{
				
				System.out.println("Digite o numero da passagem para cancelar a compra");
				id= receba.nextInt();
				passagemDAO.removeBYId(id);
				
				
				System.out.println("compra cancelada!");
				break;
				
	
			}
			case 6: {
				
				for (Cidade c : cidadeDAO.getCidades()) {

					System.out.println("Nome: " + c.getNome());

					System.out.println("--------------------------------------------");

				}
				
				break;

			}
			case 7: {
				System.out.println("obrigado pela preferencia");
				break;
			}

			default:
				System.out.println("opcao inexistente por favor degite novamente");
			}

		} while (opcao != 7);

		receba.close();

	}

}


