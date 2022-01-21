package poids.modele;

import java.text.DecimalFormat;

public class Poids {
	private float circonference;
	private int taille;
	private final DecimalFormat df = new DecimalFormat("##0.000 kg");
	
	public Poids(float circonference, int taille) {
		this.circonference = circonference;
		this.taille = taille;
		}
	/**
	* @return the circonference
	*/
	public float getCirconference() {
	return circonference;
	}
	/**
	* @param circonference the circonference to set
	*/
	public void setCirconference(float circonference) {
	this.circonference = circonference;
	}
	/**
	* @return the taille
	*/
	public int getTaille() {
	return taille;
	}
	/**
	* @param taille the taille to set
	*/
	public void setTaille(int taille) {
	this.taille = taille;
	}
	public double calculPoids() {
		double poids;
		poids = ((taille - 100) + (4 * circonference) ) / 2;
		return poids;
		}
	@Override
	public String toString() {
	final String MSG = "Votre poids idéal : ";
	return MSG + df.format(calculPoids());
	}	
}