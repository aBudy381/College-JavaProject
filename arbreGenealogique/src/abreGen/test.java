package abreGen;

import java.util.Scanner;

public class test {
	
	private static Scanner sc;


	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		Personne p1 = new Personne("Khelifa", "Afifa", 35, 'F');
		Personne p2 = new Personne("Khelifa", "Bechir", 60, 'H');
		Personne p3 = new Personne("Helaoui", "Fatma", 55, 'F');

		p1.setPere(p2);
		p1.setMere(p3);

		Personne p4 = new Personne("Zguerni", "Helmi", 8, 'H');
		p4.setMere(p1);
		Personne p5 = new Personne("Khelifa", "Afifa", 35, 'F');
		p5.setPere(p2);
		p5.setMere(p3);

		Personne p6 = new Personne("Khelifa", "Hanen", 37, 'F');
		p6.setPere(p2);
		p6.setMere(p3);

		Ville v = new Ville(100, "Mahdia");
		v.addHabitant(p1);
		v.addHabitant(p2);
		v.addHabitant(p3);
		v.addHabitant(p4);
		v.addHabitant(p5);
		v.addHabitant(p6);
		Personne p7 = new Personne("Nahla", "Mejri", 38, 'F');
		v.addHabitant(p7);
		

		for (;;) {
			System.out.println("\n\n\n********************Arbre Généalogique**********************\n");
			System.out.println("\t1-Afficher le resultat de Test de ce projet");
			System.out.println("\t2-Afficher la liste des habitants de Mahdia");
			System.out.println("\t3-Ajouter une personne");
			System.out.println("\t4-Modifier Qqe parametre d'une personne");
			System.out.println("\t5-supprimer une personne");
			System.out.println("\t6-Relation de deux personnes");
			System.out.println("\t7-Les invités d'une personne");
			System.out.println("\t8-Quitter");
			System.out.print("\nVotre Choix(1..8): ");
			int x = sc.nextInt();
			
			switch (x) {
			case 1:
				System.out.println("|Case 1|");
				p1.afficheArbre(1);
				p2.afficheArbre(1);
				p3.afficheArbre(1);
				p4.afficheArbre(1);

				if (Personne.equals(p3, p5)) {
					System.out.println("Les deux personnes sont les memes !!!");
				} else
					System.out.println("Les deux personnes ne sont pas les memes !!!");

				if (Personne.sontFrere(p1, p6)) {
					System.out.println(p1 + " et " + p6 + " sont freres");
				} else
					System.out.println(p1 + " et " + p6 + " ne sont pas freres");

				if (Personne.estUnProche(p4, p6)) {
					System.out.println(p4 + " est un proche de " + p6);
				} else
					System.out.println(p4 + " n' est pas un proche de " + p6);

				p1.inviter(v);

				String relation;
				relation = Personne.quelleRelation(p1, p2);
				System.out.println(relation);
				relation = Personne.quelleRelation(p1, p3);
				System.out.println(relation);
				relation = Personne.quelleRelation(p2, p1);
				System.out.println(relation);
				relation = Personne.quelleRelation(p3, p1);
				System.out.println(relation);
				relation = Personne.quelleRelation(p1, p4);
				System.out.println(relation);
				relation = Personne.quelleRelation(p1, p6);
				System.out.println(relation);
				relation = Personne.quelleRelation(p1, p7);
				System.out.println(relation);
				relation = Personne.quelleRelation(p2, p7);
				System.out.println(relation);
				relation = Personne.quelleRelation(p1, p5);
				System.out.println(relation);
				relation = Personne.quelleRelation(p3, p4);
				System.out.println(relation);
				relation = Personne.quelleRelation(p4, p3);
				System.out.println(relation);
				System.out.println("||Nouvelle personne !");
				Personne p = new Personne();
				Ville.listHab.add(p);
				break;
			case 2:
				System.out.println("|Case 2|");
				System.out.println("La liste des personnes : ");
				for (int j = 0; j < Ville.listHab.size(); j++) {
					System.out.print(j + "-");
					Ville.listHab.get(j).afficheArbre(1);
				}
				break;
			case 3:
				System.out.println("|Case 3|");
				System.out.println("Ajout de nouvelle personne: ");
				Ville.listHab.add(new Personne());
				break;
			case 4:
				System.out.println("|Case 4|");
				for (int j = 0; j < Ville.listHab.size(); j++) {
					System.out.print(j + "-");
					Ville.listHab.get(j).afficheArbre(1);
				}
				System.out.print("Choisir La Personne desirer: ");
				int y = sc.nextInt();

				System.out.println("1-Changer le nom");
				System.out.println("2-Changer Prenom");
				System.out.println("3-Changer l'age");
				System.out.println("4-changer le sexe");
				System.out.println("5-Mere ?");
				System.out.println("6-Pere ?");
				System.out.print("Choisir que vous voulez faire : ");
				int z = sc.nextInt();
				switch (z) {
				case 1:
					System.out.print("Donner le nouveau nom: ");
					Ville.listHab.get(y).setNom(sc.nextLine());
					break;
				case 2:
					System.out.print("Donner le nouveau prenom: ");
					Ville.listHab.get(y).setPrenom(sc.nextLine());
					break;
				case 3:
					System.out.print("donner le nouveau age: ");
					Ville.listHab.get(y).setAge(sc.nextInt());
					break;
				case 4:
					System.out.print("Donner le nouveau sexe: ");
					Ville.listHab.get(y).setGenre(sc.nextLine().charAt(0));
					break;
				case 5:
					System.out.print("Donner la mere: ");
					Ville.listHab.get(y).setMere(new Personne());
					break;
				case 6:
					System.out.print("Donner le pere: ");
					Ville.listHab.get(y).setPere(new Personne());
					break;
				default:
					System.out.println("choix non valide !");
					break;
				}
				break;
			case 5:
				System.out.println("|Case 5|");
				for (int j = 0; j < Ville.listHab.size(); j++) {
					System.out.print(j + "-");
					Ville.listHab.get(j).afficheArbre(1);
				}
				System.out.print("Choisir La Personne desirer: ");
				y = sc.nextInt();
				Ville.listHab.remove(y);
				break;
			case 6:
				System.out.println("|Case 6|");
				for (int j = 0; j < Ville.listHab.size(); j++) {
					System.out.print(j + "-");
					Ville.listHab.get(j).afficheArbre(1);
				}
				System.out.println("Choisir Les Personne desirer: ");
				System.out.print("P1::: ");
				y = sc.nextInt();
				System.out.print("P2:::");
				x = sc.nextInt();
				String ch = Personne.quelleRelation(Ville.listHab.get(y), Ville.listHab.get(x));
				System.out.println(ch);
				break;
			case 7:
				System.out.println("|Case 7|");
				for (int j = 0; j < Ville.listHab.size(); j++) {
					System.out.print(j + "-");
					Ville.listHab.get(j).afficheArbre(1);
				}
				System.out.print("Choisir La Personne desirer: ");
				y = sc.nextInt();
				Ville.listHab.get(y).inviter(v);
				break;
			case 8:
				System.out.println("|Case 8|");
				System.exit(0);
				
			default:
				System.out.println("\tChoix non valide !!!");
			}
		}

	}
	

}
