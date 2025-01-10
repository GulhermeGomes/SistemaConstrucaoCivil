package teste;

import modelo.ProjetoDao;

public class TesteExcluiPorCnpj {

    public static void main(String[] args) {
        ProjetoDao projetoDao = new ProjetoDao();
        
        String cnpj = "11111111111111";
        
        projetoDao.excluiPorCnpj(cnpj);
    }
}

