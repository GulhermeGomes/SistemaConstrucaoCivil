package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Projeto {

	/* public Projeto(String cnpj, String nomeEmpresa, String nomeProjeto, int quantidade_m2, String nomeEngenheiro) {
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
		this.nomeProjeto = nomeProjeto;
		this.quantidadeM2 = quantidade_m2;
		this.valorProjeto = this.CalcularValor();
		this.statusProjeto = this.VerificaStatus();
		this.nomeEngenheiro = nomeEngenheiro;
	}*/
	
	public Projeto(String statusProjeto, String nomeEngenheiro, String cnpj) {
		this.statusProjeto = this.StatusEngenheiro();
		this.nomeEngenheiro = this.ContrataEngenheiro();
		this.cnpj = cnpj;
	}

	public Projeto(String cnpj, String nomeEmpresa, String nomeProjeto, int quantidadeM2, String statusProjeto) {
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
		this.nomeProjeto = nomeProjeto;
		this.quantidadeM2 = quantidadeM2;
		this.valorProjeto = this.CalcularValor();
		this.statusProjeto = this.VerificaStatus();
	}

	public Projeto(String cnpj, String nomeEmpresa, String nomeProjeto, double valorM2, int quantidadeM2,
			double valorProjeto, String statusProjeto, String nomeEngenheiro) {
		this.cnpj = cnpj;
		this.nomeEmpresa = nomeEmpresa;
		this.nomeProjeto = nomeProjeto;
		this.valorM2 = valorM2;
		this.quantidadeM2 = quantidadeM2;
		this.valorProjeto = this.CalcularValor();
		this.statusProjeto = this.VerificaStatus();
		this.nomeEngenheiro = this.ContrataEngenheiro();
	}

	public Projeto() {
	}

	private String cnpj;
	private String nomeEmpresa;
	private String nomeProjeto;
	private double valorM2 = 7200;
	private int quantidadeM2;
	private double valorProjeto;
	private String statusProjeto;
	private String nomeEngenheiro = "";

	public double CalcularValor() {
		return (this.valorM2 * quantidadeM2);
	}

	public String ContrataEngenheiro() {
		List<String> nomes = new ArrayList<>();

		nomes.add("Gustave Eiffel");
		nomes.add("Robert Maillart");
		nomes.add("Francisco Prestes Maia");
		nomes.add("Elmina Wilson");
		nomes.add("Olive Dennis");
		nomes.add("Emily Warren");

		Random random = new Random();

		int indiceAleatorio = random.nextInt(nomes.size());

		String nomeAleatorio = nomes.get(indiceAleatorio);
		
		return nomeAleatorio;
	}
	
	public String StatusEngenheiro() {
		return("Contratado");
	}
	
	public String VerificaStatus() {
		return("Iniciado");
	}

	
	
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public double getValorM2() {
		return valorM2;
	}

	public void setValorM2(double valorM2) {
		this.valorM2 = valorM2;
	}

	public int getQuantidadeM2() {
		return quantidadeM2;
	}

	public void setQuantidadeM2(int quantidadeM2) {
		this.quantidadeM2 = quantidadeM2;
	}

	public double getValorProjeto() {
		return valorProjeto;
	}

	public void setValorProjeto(double valorProjeto) {
		this.valorProjeto = valorProjeto;
	}

	public String getStatusProjeto() {
		return statusProjeto;
	}

	public void setStatusProjeto(String statusProjeto) {
		this.statusProjeto = statusProjeto;
	}

	public String getNomeEngenheiro() {
		return nomeEngenheiro;
	}

	public void setNomeEngenheiro(String nomeEngenheiro) {
		this.nomeEngenheiro = nomeEngenheiro;
	}
}
