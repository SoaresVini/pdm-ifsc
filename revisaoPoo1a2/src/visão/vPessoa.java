package visão;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MinhaListaPessoa;
import model.Pessoa;

public class vPessoa {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		MinhaListaPessoa mlp = new MinhaListaPessoa();
		mlp = MinhaListaPessoa.getInstancia();
		
		Pessoa p = new Pessoa();
		
		ArrayList <Pessoa> pes = null ;
		
		Integer Acao = 0;
		String nome = "";
		String Email = "";
		
		
		while (Acao != 4) {
			
			System.out.println("O que você deseja:"
								+ "1-Cadastrar"
								+ "2-Excluir"
								+ "3-Consultar");
			Acao = s.nextInt();
			s.nextLine();
			
			if(Acao == 1) {
				System.out.println("Digite os Dados da Pessoa");
				System.out.println("Nome: ");
				nome = s.nextLine();
				
				System.out.println("Email: ");
				Email = s.nextLine();
				
				p.setNome(nome);
				p.setEmail(Email);
				
				mlp.inserir(p);
				
			}
			
			
			if(Acao == 2) {
				System.out.println("Nome: ");
				String nomeTeste = s.nextLine();
				for (Pessoa pessoa : pes) {
					if (nomeTeste.equals(pessoa.getNome()) )
						mlp.deletar(p, nome);
				}
				
			}
			if(Acao == 3) {
				for (Pessoa pessoa : pes) {
					System.out.println(pes);
				}
					
			}
			
			System.out.println("O que você deseja:"
					+ "1-Cadastrar"
					+ "2-Excluir"
					+ "3-Consultar");
			Acao = s.nextInt();
			s.nextLine();

		}
	}
}
