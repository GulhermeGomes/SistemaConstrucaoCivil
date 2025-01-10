package teste;

import java.util.List;

import modelo.Projeto;
import modelo.ProjetoDao;

public class TesteMostraTodos {
	public static void main(String[] args) {

		ProjetoDao projetoDao = new ProjetoDao();
		List<Projeto> projetos = ProjetoDao.mostraTodos();

		for (Projeto projeto : projetos) {
			System.out.println("----------------------------------------------");
			System.out.println("CNPJ: " + projeto.getCnpj());
			System.out.println("Nome da Empresa: " + projeto.getNomeEmpresa());
			System.out.println("Nome do Projeto: " + projeto.getNomeProjeto());
			System.out.println("Quantidade de M2: " + projeto.getQuantidadeM2());
			System.out.println("Valor do Projeto: " + projeto.getValorProjeto());
			System.out.println("Status do Projeto: " + projeto.getStatusProjeto());
			System.out.println("Nome do Engenheiro: " + projeto.getNomeEngenheiro());
			System.out.println();
		}

	}

}
