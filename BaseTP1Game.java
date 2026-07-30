import java.util.Scanner;
import java.util.Random;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant au TP1 - DEV Java
 */

public class BaseTP1Game extends Exception{
	/**
	 * Classe TP1Game 
	 * Jeu qui propose au joueur de trouver un nombre aléatoire choisi par le programme.
	 * @param args
	 */
	
	private static Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args){
		int min = 1;
		int max = 100;
		
		//Utilisation de la fonction input_yes_no pour recevoir oui/o ou non/n 
		String input_start = input_yes_no("Bonjour souhaitez vous jouer à mon jeu O/N ?");
		
		// Tant que l'utilisateur accepte de jouer/rejouer
		while (input_start.equals("oui") || input_start.equals("o")) {
			// On démarre une nouvelle partie
			new_game(min, max);
			
			System.out.println("Voulez-vous rejouer ? O/N");
			input_start = scanner.nextLine();
		}
		System.out.println("Au-revoir !");
		
		//On referme le scanner
		scanner.close();
	}
	
	/**
	 * Fonction qui démarre une nouvelle partie du jeu
	 * @param min
	 * @param max
	 * @param scanner
	 */
	public static void new_game(int min,int max){
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
	
	
	/** 
	 * Fonction qui permet de demander une saisie à l'utilisateur : Attendu oui non o n (peu importe la casse)
	 * prompt = Prompt qui demande à l'utilisateur de saisir 
	 */
	public static String input_yes_no(String prompt) {
		boolean is_input_ok = false;
		String input_user = "";
		while (!is_input_ok) {
			System.out.println(prompt);
			input_user = scanner.nextLine();
			//On enlève les espaces
			input_user = input_user.trim();
			//On met en minuscules
			input_user = input_user.toLowerCase();
			if (input_user.trim().isEmpty()) {
				System.out.println("La saisie ne peut pas être à vide");
				is_input_ok = false;
			}else if (!input_user.equals("oui") && !input_user.equals("o") && !input_user.equals("non") && !input_user.equals("n"))  {
				System.out.println("Saisie incorrecte");
				is_input_ok = false;
			}else {		
				is_input_ok = true;
			}
		}
		return input_user;
	}
	
}