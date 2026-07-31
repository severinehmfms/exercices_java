
/**
 * Séverine Hori Maitrehut
 * Classe correspondant à l'exercice 7 (6 mais ça doit être 7) - DEV Java
 */

public class Factorielle {
	/**
	 * Classe Factorielle 
	 * 
	 * @param args
	 */
	
	
	public static void main(String[] args){
		int nb = 5;
		int factorielle = get_factorielle(nb);
		System.out.println("Factorielle de "+ nb + " : " + factorielle);
		int factorielle2 = get_factorielle_recursivite(nb);
		System.out.println("Factorielle (fonction récursive) de "+ nb + " : " + factorielle2);
		
	}
	
	/**
	 * Méthode SANS RECURSIVITE qui renvoie le chiffre correspondant à la factorielle de l'entier nb passé en paramètre
	 * @param nb
	 * @return
	 */
	public static int get_factorielle(int nb) {
		if (nb == 0) {
			return 1;
		}
		int factorielle = nb;
		for (int i = nb - 1; i > 0; i--) {
			System.out.println("Calcul : "+ factorielle + " X " + i );
	        factorielle = factorielle * i;
		}
		return factorielle;
	}
	
	/**
	 * Méthode AVEC RECURSIVITE qui renvoie le chiffre correspondant à la factorielle de l'entier nb passé en paramètre
	 * @param nb
	 * @return
	 */
	public static int get_factorielle_recursivite(int nb) {
		if (nb == 0) {
			return 1;
		}else {
			return nb * get_factorielle_recursivite(nb-1);
		}
	}
	
	
}