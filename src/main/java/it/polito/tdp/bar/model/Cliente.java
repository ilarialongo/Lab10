package it.polito.tdp.bar.model;

public class Cliente {
	private int numeroPersone;
	private float tolleranza;
	public Cliente(int numeroPersone, float tolleranza) {
		super();
		this.numeroPersone = numeroPersone;
		this.tolleranza = tolleranza;
	}
	public int getNumeroPersone() {
		return numeroPersone;
	}
	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	@Override
	public String toString() {
		return "Persone: "+numeroPersone+" Tolleranza: " + tolleranza;
	}
	

}
