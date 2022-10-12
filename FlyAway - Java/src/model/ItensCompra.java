package model;

public class ItensCompra {

	private int qtd_itens;
	private double valor_itens;
	
	private Destinos destinos;
	private Compra compra;
	
	
	public ItensCompra() {
		
	}


	public ItensCompra(int qtd_itens, double valor_itens, Destinos destinos, Compra compra) {
		super();
		this.qtd_itens = qtd_itens;
		this.valor_itens = valor_itens;
		this.destinos = destinos;
		this.compra = compra;
	}


	public int getQtd_itens() {
		return qtd_itens;
	}


	public void setQtd_itens(int qtd_itens) {
		this.qtd_itens = qtd_itens;
	}


	public double getValor_itens() {
		return valor_itens;
	}


	public void setValor_itens(double valor_itens) {
		this.valor_itens = valor_itens;
	}


	public Destinos getDestinos() {
		return destinos;
	}


	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	
}
