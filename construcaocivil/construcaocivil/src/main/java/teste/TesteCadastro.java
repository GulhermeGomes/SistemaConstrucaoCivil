package teste;

import modelo.Projeto;
import modelo.ProjetoDao;

public class TesteCadastro {

	public static void main(String[] args) {

		Projeto projeto = new Projeto("10090807060504", "Fabula", "Apartamento", 55, "");

		ProjetoDao projetoDao = new ProjetoDao();
		projetoDao.cadastra(projeto);

	}

}
