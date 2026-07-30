
/**
 * Séverine Hori Maitrehut
 * Classe correspondant à l'exercice 6 DEV Java
 */

public class BaseEx6Operation{
	
	
	public static void main(String[] args){
		
		//Exercice 6.1
		System.out.println(add(5,2)); 
		System.out.println(sub(5,2)); 
		System.out.println(mul(5,2));
		System.out.println(div(5,2));
		System.out.println(div(3,0));
		
		//Exercice 6.2
		print_tree(13);
		
		//Exercice 6.3
		double [] tab = { 78, 6, -250, 2, 12, 9 };
		double totalmax = get_total_max(tab);
		System.out.println(Double.toString(totalmax));
		
		//Exercice 6.4
		//Voir classe Matrice
		
		
	}
	
	/**
	 * Méthode addition de deux entiers a et b
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b){
		return a + b;
	}
	
	/**
	 * Méthode soustraction entier a - entier b
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sub(int a, int b){
		return a - b;
	}
	
	/**
	 * Méthode multiplication de deux entiers a et b
	 * @param a
	 * @param b
	 * @return
	 */
	public static int mul(int a, int b){
		return a * b;
	}
	
	/**
	 * Méthode division de l'entier a par l'entier b
	 * @param a
	 * @param b
	 * @return
	 */
	public static int div(int a, int b){
		if (b == 0) {
			System.out.println("Impossible de diviser par 0");
			return a;
		}
		return a * b;
	}
	
	
	public static double get_total_max(double[] my_tab) {
		//On va rechercher les deux chiffres maximaux dans le tableau
		double nb_max = 0;
		double nb_max2 = 0;
		for (int i = 0 ; i < my_tab.length ; i++) {
			//Si la case en cours a une valeur supérieur à nb_max, nb_max prend la valeur de la case en cours, et nb_max2 prend la valeur de nb_max
			//De cette façon, nb_max sera toujours la valeur la plus élevée (en cours), et nb_max2 prend la valeur suivante la plus élevée
			if (my_tab[i] > nb_max) { 
				nb_max2 = nb_max; 
				nb_max = my_tab[i]; 
			//Si la case en cours a une valeur supérieur à nb_max2, alors ce dernier prend la valeur de la case en cours
			}else if (my_tab[i] > nb_max2) { 
				nb_max2 = my_tab[i];
			}
		}
		//On retourne la somme de ces deux chiffres
		return nb_max + nb_max2;
	}
	
	
	/**
	 * Fonction qui affiche un arbre dont la taille maxi est passée en paramètre et doit être impair
	 */
	public static void print_tree(int taille_maxi) {
		if (taille_maxi % 2 == 0) {
			System.out.println("La largeur maxi de l'arbre doit être un chiffre impair ! ");	
		}else {
			String tree = "";
			int nb_spaces;
			for (int nb_stars = 1; nb_stars <= 13; nb_stars += 2) {
				nb_spaces = (taille_maxi - nb_stars)/2;
				
				//repeat ne marche pas avec java 8...
				//System.out.println(" ".repeat(taille_maxi));
				for (int i = 0; i < nb_spaces; i++) {
			        tree += (" ");
			    }
				for (int i = 0; i < nb_stars; i++) {
			        tree += ("*");
			    }
				for (int i = 0; i < nb_spaces; i++) {
			        tree += (" ");
			    }
				tree += "\n";			
	        }
			System.out.println(tree);	
		}
		
	}
	
	
	
}
