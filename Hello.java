
import java.util.Scanner;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant à l'exercice 1 bis (éclipse) DEV Java
 */


public class Hello{
	
	private static Scanner scanner = new Scanner(System.in);	
	
	public static void main(String[] args){
		
		System.out.println("Bonjour et bienvenue dans mon programme java");
		
		// Si on a entré le nom en argument
		if (args.length > 0) {
			System.out.println("Bonjour " + args[0]);
			
		// Si pas de nom en arguments on demande à l'utilisateur le nom et le prénom 
		}else{
			String nom = input_string("Quel est votre nom: ");
			String prenom = input_string("Quel est votre prénom: ");
			
			System.out.println("Bonjour " + prenom + " " + nom);
		}
	}
	
	/** 
	 * Fonction qui permet de demander une saisie à l'utilisateur
	 * prompt = Prompt qui demande à l'utilisateur de saisir 
	 */
	public static String input_string(String prompt) {
		boolean is_input_ok = false;
		String input_user = "";
		while (!is_input_ok) {
			System.out.println(prompt);
			input_user = scanner.nextLine();
			
			if (input_user.trim().isEmpty()) {
				System.out.println("La saisie ne peut pas être à vide");
				is_input_ok = false;
			}else {		
				is_input_ok = true;
			}
		}
		return input_user.toLowerCase();
	}
	
}