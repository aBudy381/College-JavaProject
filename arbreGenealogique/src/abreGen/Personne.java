package abreGen;

import java.util.Scanner;

public class Personne {
	
		
/**
 * ======== Attributes
 * */
		private String nom, prenom;
		private int age;
		private char genre;
		private Personne pere;
		private Personne mere;
		
/**
* ======== Constructors
* */  
		//1
		private Scanner sc = new Scanner(System.in);

		Personne(String n, String p, int a, char g) {
		this.nom = n;
		this.prenom = p;
		this.age = a;
		this.genre = g;
		this.pere = null;
		this.mere = null;
		}
				
      //2
	  Personne(String n, String p, int a, char g, Personne pr, Personne m) {
					this.nom = n;
					this.prenom = p;
					this.age = a;
					this.genre = g;
					this.pere = pr;
					this.mere = m;
				}
		        //3
				Personne() {
					System.out.print("Nom: ");
					nom = sc.next();
					System.out.print("Prenom: ");
					prenom = sc.next();
					boolean test = false;
					
					while (test ){
						//sexe
						System.out.print("Sexe(H/F): ");
						
						char s = sc.next().charAt(0);
						if (s == 'h' || s == 'f') {
							genre = s;
							test = true;
						} 
					} 

					test = false;
					while (test == false){
						while (!sc.hasNextInt()) {
							String ch = sc.next();
							System.out.println(ch + " n'est pas un nombre entier !!!");
							System.out.print("Age: ");
						}
						age = sc.nextInt();
						test = true;
					} 

					while(test) {
						System.out.print("Avez vous des informations sur la mere de " + this + "? (1 si vous avez): ");
						while (!sc.hasNextInt()) {
							String ch = sc.next();
							System.out.println(ch + " n'est pas un nombre entier !!!");
							System.out.print("Avez vous des informations sur la mere de " + this + "? (1 si vous avez): ");
						}
						int inf = sc.nextInt();
						if (inf == 1) {
							Personne p = new Personne();
							this.setMere(p);
						}
						test = true;
					} 
					test = false;
					while(test) {
						System.out.print("Avez vous des informations sur le pere de " + this + "? (1 si vous avez): ");
						while (!sc.hasNextInt()) {
							String ch = sc.next();
							System.out.println(ch + " n'est pas un nombre entier !!!");
							System.out.print("Avez vous des informations sur le pere de " + this + "? (1 si vous avez): ");
						}
						int inf = sc.nextInt();
						if (inf == 1) {
							Personne p = new Personne();
							this.setPere(p);
						}
						test = true;
					} 
				}
			
/**
* ======== Getters and Setters
* */
		//nom
		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}
       //prenom
		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
        //age
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
        //genre
		public char getGenre() {
			return genre;
		}

		public void setGenre(char genre) {
			this.genre = genre;
		}
        //pere
		public Personne getPere() {
			return pere;
		}
		public void setPere(Personne p) {
			this.pere = p;
			System.out.println(
					"Rattachement effectué entre " + this.nom + " " + this.prenom + " et " + p.nom + " " + p.prenom);
		}
        //mere
		public Personne getMere() {
			return mere;
		}
		public void setMere(Personne p) {
			this.mere = p;
			System.out.println(
					"Rattachement effectué entre " + this.nom + " " + this.prenom + " et " + p.nom + " " + p.prenom);
		}


		public boolean equals(Personne p) {
			if (this.nom == p.nom && this.prenom == p.prenom) {
				return true;
			} else
				return false;
		}

		public static boolean equals(Personne p1, Personne p2) {
			if (p1.equals(p2)) {
				return true;
			} else
				return false;
		}

		public boolean memePere(Personne p) {
			if (this.pere != null && p.pere != null && (this.pere == p.pere)) {
				return true;
			} else
				return false;
		}

		public boolean memeMere(Personne p) {
			if (this.mere != null && p.mere != null && (this.mere == p.mere)) {
				return true;
			} else
				return false;
		}
		//methode afficheArbre
		public void afficheArbre(int i) {
			if (this.pere == null && this.mere == null) {
				System.out.println(this + " " + age + " ans");
			} else if (this.pere == null && this.mere != null) {
				System.out.println(this + " " + age + " ans");
				for (int j = 0; j < i; j++) {
					System.out.print("\t");
				}
				System.out.print("Mere:");
				this.mere.afficheArbre(i + 1);
			} else if (this.pere != null && this.mere == null) {
				System.out.println(this + " " + age + " ans");
				for (int j = 0; j < i; j++) {
					System.out.print("\t");
				}
				System.out.print("Pere: ");
				this.pere.afficheArbre(i + 1);
			} else {
				System.out.println(this + " " + age + " ans");
				for (int j = 0; j < i; j++) {
					System.out.print("\t");
				}
				System.out.print("Pere: ");
				this.pere.afficheArbre(i + 1);
				for (int j = 0; j < i; j++) {
					System.out.print("\t");
				}
				System.out.print("Mere: ");
				this.mere.afficheArbre(i + 1);

			}
		}


		public static boolean sontFrere(Personne p1, Personne p2) {
			if (p1.memeMere(p2) || p1.memePere(p2)) {
				return true;
			} else
				return false;
		}

		//methode estUnFils
		public static boolean estUnFils(Personne p1, Personne p2) {
			if (p1.mere == p2 || p1.pere == p2) {
				return true;
			} else
				return false;
		}
        //methode estUnAsc
		public static boolean estUnAsc(Personne p1, Personne p2) {
			boolean bool = false;
			if (p2.pere != null) {
				if (p2.pere.pere != null) {
					if (p2.pere.pere == p1) {
					  bool = true;
					} else
						bool = false;
				}
				if (p2.pere.mere != null) {
					if (p2.pere.mere == p1) {
						bool = true;
					} else
						bool = false;
				} else
					bool = false;
			}
			if (p2.mere != null) {
				if (p2.mere.pere != null) {
					if (p2.mere.pere == p1) {
						bool = true;
					} else
						bool = false;
				}
				if (p2.mere.mere != null) {
					if (p2.mere.mere == p1) {
						bool = true;
					} else
						bool = false;
				} else
					bool = false;
			} else
				bool = false;
			return bool;
		}
        
		public static boolean estUnProche(Personne p1, Personne p2) {
			if (!equals(p1, p2) && (estUnAsc(p1, p2) || estUnFils(p1, p2))) 
				return true;
			
				else	return false;
		}

		//methode quelleRelation
		public static String quelleRelation(Personne p1, Personne p2) {
			if (estUnProche(p1, p2)) {
				return (p1 + " et " + p2 + " : Proches");
			} else if (estUnFils(p1, p2)) {
				return (p1 + " et " + p2 + " : Fils");
			} else if (equals(p1, p2)) {
				return (p1 + " et " + p2 + " : Meme");
			} else if (estUnAsc(p1, p2)) {
				return (p1 + " et " + p2 + " : Ascendant");
			} else
				return (p1 + " et " + p2 + " : Aucune");
		}
		//methode toString
		public String toString() {
			return (nom + " " + prenom);
		}


		public void inviter(Ville v) {
			System.out.println("Les invités de " + this + " sont :");
			for (int i = 0; i < v.getNbHabitant(); i++) {
				if (Personne.estUnProche(this, Ville.listHab.get(i))) {
					System.out.println("\t" + Ville.listHab.get(i));
				}
			}
		}
		}

	

