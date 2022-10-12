package model;

public class Destinos {

	private int id_destino;
	private String nome_destino;
	private double preco_destino;
	
	public Destinos() {
		
	}
	
	public Destinos(int id_destino, String nome_destino, double preco_destino) {
		super();
		this.id_destino = id_destino;
		this.nome_destino = nome_destino;
		this.preco_destino = preco_destino;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_livros) {
		this.id_destino = id_livros;
	}

	public String getNome_destino() {
		return nome_destino;
	}

	public void setNome_destino(String nome_destino) {
		this.nome_destino = nome_destino;
	}

	public double getPreco_destino() {
		return preco_destino;
	}

	public void setPreco_destino(double preco_destino) {
		this.preco_destino = preco_destino;
	}

	
}
