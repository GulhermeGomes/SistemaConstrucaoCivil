package teste;

import modelo.Projeto;
import modelo.ProjetoDao;

public class TesteMostraPorCnpj {

	public static void main(String[] args) {
		ProjetoDao projetoDao = new ProjetoDao();

		
		String cnpj = "11111111111111";

		Projeto projeto = projetoDao.mostraPorCnpj(cnpj);

		if (projeto != null) {
			System.out.println("----------------------------------------------");
			System.out.println("CNPJ: " + projeto.getCnpj());
			System.out.println("Nome da Empresa: " + projeto.getNomeEmpresa());
			System.out.println("Nome do Projeto: " + projeto.getNomeProjeto());
			System.out.println("Quantidade de M2: " + projeto.getQuantidadeM2());
			System.out.println("Valor do Projeto: " + projeto.getValorProjeto());
			System.out.println("Status do Projeto: " + projeto.getStatusProjeto());
			System.out.println("Nome do Engenheiro: " + projeto.getNomeEngenheiro());
			System.out.println();
		} else {
			System.out.println("O CNPJ Não Existe!!!");
		}
	}
}
