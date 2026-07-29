import java.util.Scanner;
import java.util.Random;

public class TP1Game extends Exception{
	/**
	 * Classe TP1Game 
	 * Jeu qui propose au joueur de trouver un nombre aléatoire choisi par le programme.
	 * @param args
	 */
	
	public static void new_game(int min,int max,Scanner scanner){
		/** Fonction qui démarre une nouvelle partie**/
		Random random = new Random();
		int random_nb = random.nextInt((max - min) + 1) + min;
		Boolean is_nb_found = false;	
		int cpt = 0;
		System.out.println("Saisissez une valeur comprise entre 1 et 100");
		while (! is_nb_found) {
			cpt ++;
			try {
				int nb_input = scanner.nextInt();
				//On retourne à la ligne pour le scanner sinon ça ne fonctionnera pas quand je voudrais effectuer ma nouvelle saisie
				scanner.nextLine();
				if (nb_input > random_nb) {
					System.out.println("Saisissez une valeur plus petite");
				}else if (nb_input < random_nb) {
					System.out.println("Saisissez une valeur plus grande");
				}else{
					System.out.println("Vous avez trouvé en " + cpt + " coups");
					is_nb_found = true;
				}				
			} catch (Exception e) {
				System.out.println("Erreur" + e);
				break;
			} 
		}
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int min = 1;
		int max = 100;
		try {
			System.out.println("Bonjour souhaitez vous jouer à mon jeu O/N ?");
			String input_start = scanner.nextLine();
			input_start = input_start.toLowerCase();
			// Tant que l'utilisateur accepte de jouer
			while (input_start.equals("oui") || input_start.equals("o")) {
				// On démarre une nouvelle partie
				new_game(min, max, scanner);
				System.out.println("Voulez-vous rejouer ? O/N");
				input_start = scanner.nextLine();
			}
			System.out.println("Au-revoir !");
		} catch (Exception e) {
			System.out.println("Erreur" + e);
		} finally {
			scanner.close();
		}
		
		
	}
}