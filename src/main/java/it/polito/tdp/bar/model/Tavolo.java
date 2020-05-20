package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo> {
	private int num_Posti;
	private boolean is_Libero;
	public Tavolo(int num_Posti, boolean is_Libero) {
		super();
		this.num_Posti = num_Posti;
		this.is_Libero = is_Libero;
	}
	public int getNum_Posti() {
		return num_Posti;
	}
	public void setNum_Posti(int num_Posti) {
		this.num_Posti = num_Posti;
	}
	public boolean isIs_Libero() {
		return is_Libero;
	}
	public void setIs_Libero(boolean is_Libero) {
		this.is_Libero = is_Libero;
	}
	@Override
	public int compareTo(Tavolo o) {
		return this.num_Posti-o.getNum_Posti();
	}
	@Override
	public String toString() {
		return "Tavolo num_Posti:" + num_Posti+ " "+ is_Libero ;
	}
	
	

	

}
