package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private int id_comprar;
	private String data_compra;
	private double valor_compra;

	private Usuario usuario;
	private List<ItensCompra> itens = new ArrayList<ItensCompra>();
	
	
	public Compra() {
		
	}
	
	
	public Compra(int id_comprar, String data_compra, double valor_compra, Usuario usuario, List<ItensCompra> itens) {
		super();
		this.id_comprar = id_comprar;
		this.data_compra = data_compra;
		this.valor_compra = valor_compra;
		this.usuario = usuario;
		this.itens = itens;
	}


	public int getId_comprar() {
		return id_comprar;
	}


	public void setId_comprar(int id_comprar) {
		this.id_comprar = id_comprar;
	}


	public String getData_compra() {
		return data_compra;
	}


	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}


	public double getValor_compra() {
		return valor_compra;
	}


	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<ItensCompra> getItens() {
		return itens;
	}


	public void setItens(List<ItensCompra> itens) {
		this.itens = itens;
	}
}