package abreGen;
import java.util.ArrayList;

public class Ville {
	
	/**
	 * ======== Attributes
	 * */
	public String nomVile;
	public static ArrayList<Personne> listHab;
	
	/**
	 * ======== Constructor
	 * */

	Ville(int max, String ville) {
		this.nomVile = ville;
		listHab = new ArrayList<Personne>(max);
	}
	
	/**
	 * ======== Methode addHabitant | ajoute un nouveau habitant de type personne a la liste des habitants
	 * */

	public void addHabitant(Personne hab) {
		listHab.add(hab);
		System.out.println("New Person " + hab.toString() + " added successfully in " + this.nomVile);
	}
   
	/**
	 * ======== Methode listHabitan | output liste habitants
	 * */

	public void listHabitant() {
		for (int i = 0; i < listHab.size(); i++) {
			System.out.println(listHab);
		}
	}
	/**
	 * ======== Methode getNbHabitant | output nombre des habitants
	 * */
	public int getNbHabitant() {
		return listHab.size();
	}

	

}
