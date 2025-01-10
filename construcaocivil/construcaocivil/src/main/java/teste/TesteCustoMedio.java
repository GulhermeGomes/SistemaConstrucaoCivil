package teste;

import java.sql.SQLException;

import modelo.ProjetoDao;

public class TesteCustoMedio {
	
	public static void main(String[] args) {
		
		ProjetoDao projetoDao = new ProjetoDao();
		
        try {
            double custoMedio = ProjetoDao.calcularCustoMedio();
            System.out.println("O custo médio dos itens na tabela é: " + custoMedio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

