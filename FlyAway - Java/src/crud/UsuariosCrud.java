package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.UsuariosDAO;
import model.Destinos;
import model.Usuario;

public class UsuariosCrud {

	public static void main(String[] args) {

		UsuariosDAO usuarioDAO = new UsuariosDAO();

		Scanner input = new Scanner(System.in);

		// Var menu

		int opcao = 0;
		int posicao = 0;

		int id = 0;
		String nome = "";
		String email = "";
		String senha = "";
		
		List<Destinos> destinos = new ArrayList<Destinos>();

		// Menu

		do {
			System.out.println("####### CRUD USUARIOS #####");
			System.out.println("1 - Cadastra usuario");
			System.out.println("2 - Consulta usuario");
			System.out.println("3 - Deleta usuario");
			System.out.println("4 - Atualiza usuario");
			System.out.println("0 - Sair");

			opcao = input.nextInt();

			switch (opcao) {
			case 1:
				// Create
				System.out.println("####### Cadastra usuario #######");
				
				System.out.println("Digite o nome: ");
				nome = input.nextLine();
				nome = input.nextLine();
				
				System.out.println("Digite o email: ");
				email = input.nextLine();
				
				System.out.println("Digite a senha: ");
				senha = input.nextLine();

				Usuario usuario = new Usuario();
				

				usuario.setNome_usuario(nome);
				usuario.setSenha_usuario(senha);
				usuario.setEmail_usuario(email);
				usuarioDAO.save(usuario);

				System.out.println("\n **** CADASTRADO REALIZADO COM SUCESSO ****");
				break;

			default:
				System.out.println(opcao != 0 ? "\n opcao invalida" : "");
				break;

				
				
				
			// READ
			case 2:
				for (Usuario a : usuarioDAO.getUsuario()) {
					System.out.println("Id " + a.getId_usuario() + ": Nome do usuario: " + a.getNome_usuario() + " Email:" + a.getEmail_usuario() + " Senha: " + a.getSenha_usuario());
				}

				System.out.println("\n **** CONSULTA REALIZADA COM SUCESSO ****");
				break;
				
				
			// DELETE
			case 3:
				System.out.println("Digite o ID para exclusao");
				posicao = input.nextInt();

				usuarioDAO.delete(posicao);

				System.out.println("\n **** ELEMENTO EXCLUIDO COM SUCESSO ****");
				break;
				
				
				
			// UPDATE
			case 4:
				System.out.println("Insira o ID do usuario que ira ser modificado: ");
				id = input.nextInt();
				
				System.out.println("Inisira o novo nome do usuario:");
				nome = input.nextLine();
				nome = input.nextLine();
				
				System.out.println("Inisira o novo email do usuario:");
				email = input.nextLine();
				
				System.out.println("Inisira a nova senha do usuario:");
				senha = input.nextLine();
				
				Usuario usuario1 = new Usuario(id, nome, email, senha);
				usuarioDAO.update(usuario1);
				break;
				
				
			}

		} while (opcao != 0);
		input.close();
		System.out.println("Finalizado");
	}

}