package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DestinosDAO;
import model.Destinos;

public class DestinosCrud {

	public static void main(String[] args) {

		DestinosDAO destinoDAO = new DestinosDAO();

		Scanner input = new Scanner(System.in);

		// Var menu

		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";

		List<Destinos> destinos = new ArrayList<Destinos>();

		// Menu

		do {
			System.out.println("####### CRUD DESTINOS #####");
			System.out.println("1 - Cadastra destino");
			System.out.println("2 - Consulta destino");
			System.out.println("3 - Deleta destino");
			System.out.println("4 - Atualiza destino");
			System.out.println("0 - Sair");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				// Create
				System.out.println("####### Cadastra destino #######");
				System.out.println("Digite o nome: ");
				nome = input.nextLine();
				nome = input.nextLine();

				Destinos destino = new Destinos();

				destino.setNome_destino(nome);
				destinoDAO.save(destino);

				System.out.println("\n **** CADASTRADO REALIZADO COM SUCESSO ****");
				break;

			default:
				System.out.println(opcao != 0 ? "\n opcao invalida" : "");
				break;

				
				
				
			// READ
			case 2:
				for (Destinos a : destinoDAO.getDestinos()) {
					System.out.println("Id " + a.getId_destino() + ": Nome do destino: " + a.getNome_destino());
				}

				System.out.println("\n **** CONSULTA REALIZADA COM SUCESSO ****");
				break;
				
				
			// DELETE
			case 3:
				System.out.println("Digite o ID para exclusao");
				posicao = input.nextInt();

				destinoDAO.delete(posicao);

				System.out.println("\n **** ELEMENTO EXCLUIDO COM SUCESSO ****");
				break;
				
				
				
			// UPDATE
			case 4:
				System.out.println("Insira o ID do destino que ira ser modificado: ");
				id = input.nextInt();
				
				System.out.println("Inisira o novo nome do Destino:");
				nome = input.nextLine();
				
				double preco = 0.0;
				System.out.println("Inisira o novo valor:");
				preco = input.nextDouble();
				preco = input.nextDouble();
				
				Destinos destino1 = new Destinos(id, nome, preco);
				destinoDAO.update(destino1);
				break;
				
				
			}

		} while (opcao != 0);
		input.close();
		System.out.println("Finalizado");
	}

}
