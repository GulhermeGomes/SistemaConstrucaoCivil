package teste;

import modelo.Projeto;
import modelo.ProjetoDao;

public class TesteAltera {

    public static void main(String[] args) {

        Projeto projeto = new Projeto();
        projeto.setCnpj("11111111111111");
        projeto.setStatusProjeto(projeto.StatusEngenheiro());
        projeto.setNomeEngenheiro(projeto.ContrataEngenheiro());

        ProjetoDao projetoDao = new ProjetoDao();
        
        projetoDao.altera(projeto);
    }
}

