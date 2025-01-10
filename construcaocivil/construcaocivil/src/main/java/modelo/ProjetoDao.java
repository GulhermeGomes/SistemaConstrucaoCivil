package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDao {
	public void cadastra(Projeto projeto) {

		Connection con = Conexao.obterConexao();

		String sql = "INSERT INTO Projeto(cnpj,nome_empresa,nome_projeto,quantidade_m2,valor_projeto,status_projeto,nome_engenheiro) VALUES(?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, projeto.getCnpj());
			preparador.setString(2, projeto.getNomeEmpresa());
			preparador.setString(3, projeto.getNomeProjeto());
			preparador.setInt(4, projeto.getQuantidadeM2());
			preparador.setDouble(5, projeto.getValorProjeto());
			preparador.setString(6, projeto.getStatusProjeto());
			preparador.setString(7, projeto.getNomeEngenheiro());

			preparador.execute();

			preparador.close();

			System.out.println("O Projeto Foi Iniciado!!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluiPorCnpj(String cnpj) {

		Connection con = null;
		PreparedStatement preparador = null;

		String sql = "DELETE FROM Projeto WHERE cnpj = ?";

		try {
			con = Conexao.obterConexao();
			preparador = con.prepareStatement(sql);
			preparador.setString(1, cnpj);

			int rowsDeleted = preparador.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("Projeto excluído com sucesso!");
			} else {
				System.out.println("Nenhum projeto encontrado com o CNPJ fornecido!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparador != null) {
					preparador.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Projeto> mostraTodos() {

		Connection con = Conexao.obterConexao();
		List<Projeto> projetos = new ArrayList<>();
		String sql = "SELECT * FROM Projeto";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {

				Projeto projeto = new Projeto();
				projeto.setCnpj(resultado.getString("cnpj"));
				projeto.setNomeEmpresa(resultado.getString("nome_empresa"));
				projeto.setNomeProjeto(resultado.getString("nome_projeto"));
				projeto.setQuantidadeM2(resultado.getInt("quantidade_m2"));
				projeto.setValorProjeto(resultado.getDouble("valor_projeto"));
				projeto.setStatusProjeto(resultado.getString("status_projeto"));
				projeto.setNomeEngenheiro(resultado.getString("nome_engenheiro"));

				projetos.add(projeto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return projetos;
	}

	public Projeto mostraPorCnpj(String cnpj) {

		Connection con = null;
		PreparedStatement preparador = null;
		ResultSet resultado = null;
		Projeto projeto = null;

		String sql = "SELECT * FROM Projeto WHERE cnpj = ?";

		try {
			con = Conexao.obterConexao();
			preparador = con.prepareStatement(sql);
			preparador.setString(1, cnpj);

			resultado = preparador.executeQuery();

			if (resultado.next()) {
				projeto = new Projeto();
				projeto.setCnpj(resultado.getString("cnpj"));
				projeto.setNomeEmpresa(resultado.getString("nome_empresa"));
				projeto.setNomeProjeto(resultado.getString("nome_projeto"));
				projeto.setQuantidadeM2(resultado.getInt("quantidade_m2"));
				projeto.setValorProjeto(resultado.getDouble("valor_projeto"));
				projeto.setStatusProjeto(resultado.getString("status_projeto"));
				projeto.setNomeEngenheiro(resultado.getString("nome_engenheiro"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultado != null) {
					resultado.close();
				}
				if (preparador != null) {
					preparador.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return projeto;
	}

	public void altera(Projeto projeto) {
        Connection con = null;
        PreparedStatement preparador = null;
        
        String sql = "UPDATE Projeto SET status_projeto=?, nome_engenheiro=? WHERE cnpj=?";

        try {
            con = Conexao.obterConexao();
            preparador = con.prepareStatement(sql);
            preparador.setString(1, projeto.getStatusProjeto());
            preparador.setString(2, projeto.getNomeEngenheiro());
            preparador.setString(3, projeto.getCnpj());

            int rowsUpdated = preparador.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("O Engenheiro Foi Contratado Com Sucesso!!!");
            } else {
                System.out.println("Nenhum projeto encontrado com o CNPJ fornecido.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparador != null) {
                    preparador.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public static double calcularCustoMedio() throws SQLException {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        double somaCustos = 0.0;
	        int quantidadeItens = 0;

	        try {
	            con = Conexao.obterConexao();

	            String valorProjeto = "valor_projeto";
	            String tabelaProjeto = "Projeto";

	            String sql = "SELECT SUM(" + valorProjeto + "), COUNT(*) FROM " + tabelaProjeto;
	            stmt = con.prepareStatement(sql);
	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                somaCustos = rs.getDouble(1);
	                quantidadeItens = rs.getInt(2);
	            }

	            if (quantidadeItens == 0) {
	                return 0.0;
	            }

	            return somaCustos / quantidadeItens;

	        } finally {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        }
	    }
	
}

