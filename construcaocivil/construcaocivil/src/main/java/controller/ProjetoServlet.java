package controller;
	
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Projeto;
import modelo.ProjetoDao;

@WebServlet("/chamadaservlet")
public class ProjetoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("cadastro")) {
			String cnpj = request.getParameter("txtcnpj");
			String nome_empresa = request.getParameter("txtnomeempresa");
			String nome_projeto = request.getParameter("txtnomeprojeto");
			int quantidade_m2 = Integer.parseInt(request.getParameter("txtquantidadem2"));
			String status_projeto = request.getParameter("txtstatusprojeto");

			Projeto projeto = new Projeto(cnpj, nome_empresa, nome_projeto, quantidade_m2, status_projeto);

			ProjetoDao projetoDao = new ProjetoDao();
			projetoDao.cadastra(projeto);

			response.sendRedirect("chamadaservlet?acao=mostrar");
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equals("mostrar")) {
			List<Projeto> projetos = ProjetoDao.mostraTodos();

			request.setAttribute("projetos", projetos);
			RequestDispatcher rd = request.getRequestDispatcher("mostrartodos.jsp");
			rd.forward(request, response);
		} else if (acao.equals("excluir")) {
			String cnpj = request.getParameter("cnpj");

			ProjetoDao projetoDao = new ProjetoDao();
			projetoDao.excluiPorCnpj(cnpj);

			response.sendRedirect("chamadaservlet?acao=mostrar");
		} else if (acao.equals("contratar")) {
			String cnpj = request.getParameter("cnpj");

			String status_projeto = request.getParameter("txtstatus_projeto");
			String nome_engenheiro = request.getParameter("txtnome_engenheiro");

			Projeto projeto = new Projeto(status_projeto, nome_engenheiro, cnpj);

			ProjetoDao projetoDao = new ProjetoDao();
			projetoDao.altera(projeto);

			response.sendRedirect("chamadaservlet?acao=mostrar");
		} else if (acao.equals("estatistica")) {

			List<Projeto> projetos = ProjetoDao.mostraTodos();

			request.setAttribute("projetos", projetos);

			projetos.stream().count();
			;
			// Recupere as informações do banco de dados
			long quantidadeProjetos = projetos.stream().count();// consulta para obter a quantidade de projetos
			double precoMedio = projetos.stream().mapToDouble(Projeto::getValorProjeto).average().orElse(0.0);
			int quantidadeTotalM2 = projetos.stream().mapToInt(Projeto::getQuantidadeM2).sum();

			// Adicione as informações ao objeto de solicitação
			request.setAttribute("quantidadeProjetos", quantidadeProjetos);
			request.setAttribute("precoMedio", precoMedio);
			request.setAttribute("quantidadeTotalM2", quantidadeTotalM2);

			// Encaminhe a solicitação de volta para a página JSP
			request.getRequestDispatcher("mostrartodos.jsp").forward(request, response);
		}

	}

}
