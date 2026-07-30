import java.util.Scanner;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant au TP2 - DEV Java
 */

public class BaseTP2Resto{
	private static Scanner scanner = new Scanner(System.in);	
	private static int nb_choix = 5;
	
	
	private static enum Entree {
		SALADE, SOUPE, QUICHE, AUCUNE
	}
	private static enum Plat {
		POULET, BOEUF, POISSON, VEGETARIEN, VEGAN, AUCUN
		}
	private static enum Accompagnement {
		RIZ, PATES, FRITES, LEGUMES, AUCUN
		}
	private static enum Boisson {
		EAU_PLATE, EAU_GAZEUSE, SODA, VIN, AUCUNE
		}
	private static enum Dessert {
		TARTE_MAISON, MOUSSE_AU_CHOCOLAT, TIRAMISU, AUCUN
		}
	
	
	public static void main(String[] args){
		//On demande à l'utilisateur combien de menus il veut commander
		int nb_menus = input_int("Bonjour, combien de menus souhaitez vous ?", 1, 10);
		int [][] commandes = new int [nb_menus][nb_choix];
		
		//Pour chaque commande que souhaite faire l'utilisateur
		for (int i = 0; i < nb_menus; i++) {
			System.out.println("Commande numéro " + (i+1) + " : ");
			
			//On appelle la fonction qui demande à l'utilisateur sa commande			
			int [] commande = commande_menu();
			
			//On rajoute la commande dans le tableaux des commandes
			commandes[i] = commande;
			
			//On affiche le résumé de la commande (i+1)
			print_resume_commande(commandes[i],i+1);
		}
		
		//On referme le scanner
		scanner.close();
	}
	
	/**
	 * Méthode qui permet de demander et scanner ses choix à l'utilisateur, pour une commande
	 * @return
	 */
	public static int[] commande_menu(){
		//On demande à l'utilisateur son choix pour l'entrée
		System.out.print("Choix entrée : ");
		int choice_entree = input_choice_item("Que souhaitez vous comme entrée ? [Saisir le chiffre correspondant] ", Entree.values());
		//On demande à l'utilisateur son choix pour le plat
		System.out.print("Choix plat : ");
		int choice_plat = input_choice_item("Que souhaitez vous comme plat ? [Saisir le chiffre correspondant] ", Plat.values());
		//On demande à l'utilisateur son choix pour l'accompagnement
		System.out.print("Choix accompagnement : ");
		int choice_accompagnement = input_choice_item("Que souhaitez vous comme accompagnement ? [Saisir le chiffre correspondant] ", Accompagnement.values());
		//On demande à l'utilisateur son choix pour la boisson
		System.out.print("Choix boisson : ");
		int choice_boisson = input_choice_item("Que souhaitez vous comme boisson ? [Saisir le chiffre correspondant] ", Boisson.values());
		//On demande à l'utilisateur son choix pour le dessert
		System.out.print("Choix dessert : ");
		int choice_dessert = input_choice_item("Que souhaitez vous comme dessert ? [Saisir le chiffre correspondant] ", Dessert.values());
		
		int [] commande = {choice_entree, choice_plat, choice_accompagnement, choice_boisson, choice_dessert};
		return commande;
	}
	
	/**
	 * Méthode qui permet de proposer les items d'un enum (exemple proposer les entrées possibles pour une entrée), et de scanner le résultat de l'utilisateur 
	 * @param prompt
	 * @param choix
	 * @return
	 */
	public static int input_choice_item(String prompt, Enum[] choix) {
		int item_chosen;
		String item_str = "";
		for (int i = 1; i < choix.length+1; i++) {
			//On remplace les _ par des espaces pour l'affichage
			item_str = choix[i-1].name().replace('_', ' ');
	        System.out.print("[" + i + " - " + item_str  + "] ");
	    }
		System.out.println();
		//item_chosen = scanner.nextInt();
		item_chosen = input_int(prompt, 1, choix.length);
		//On enlève 1 car les enums commencent à zéro pour stocker le bon indice
		item_chosen --;
	    return item_chosen;
	    
	}
	
	/**
	 * Fonction générique pour faire saisir à l'utilisateur un int entre min_val et max_val
	 * @param prompt
	 * @param min_val
	 * @param max_val
	 * @return
	 */
	public static int input_int(String prompt, int min_val, int max_val) {
		int input_int_user = 0;
		boolean is_valid_input = false;
	    while (!is_valid_input) {
	    	System.out.println(prompt);
	    	String input_user = scanner.nextLine();

	        if (input_user.matches("\\d+")) {
	        	input_int_user = Integer.parseInt(input_user);

	            if (input_int_user >= min_val && input_int_user <= max_val) {
	            	is_valid_input = true;
	            } else {
	            	System.out.println("Le nombre doit être compris entre " + min_val + " et " + max_val);
	            }
	        } else {
	            System.out.println("Vous devez saisir un entier.");
	        }
	    }
		return input_int_user;
	}
	
	
	/**
	 * Méthode qui va afficher le résumé de la commande pour un menu de l'utilisateur
	 * @param commande
	 */
	public static void print_resume_commande(int[] commande, int num_commande) { 
		System.out.println("Résumé de la commande " + num_commande + " : ");
		String resume = "[";
		for (int i = 0; i < commande.length; i++) {
			switch (i) {
				case 0:
					if (!Entree.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Entree.values()[commande[i]] + " ";
					}
					break;
				case 1:
					if (!Plat.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Plat.values()[commande[i]] + " ";
					}
					break;
				case 2:
					if (!Accompagnement.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Accompagnement.values()[commande[i]] + " ";
					}
					break;
				case 3:
					if (!Boisson.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Boisson.values()[commande[i]] + " ";
					}
					break;
				case 4:
					if (!Dessert.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Dessert.values()[commande[i]] + " ";
					}
					break;
			}
		}
		//On remplace si plusieurs espaces par un seul espace (en cas de beaucoup de AUCUN/AUCUNE choisis)
		//resume = resume.replace("  ", " ");
		resume = resume.replaceAll("\\s+", " ");
		//On remplace les espaces par des virgules
		resume = resume.replace(" ", ",");
		//Si le résumé se termine par une virgule on supprime la virgule finale
		if (resume.endsWith(",")) {
			resume = resume.substring(0, resume.length() - 1);
		}
		//On remplace l'underscore (utilisé dans les enum) par un espace pour un affichage plus propre
		resume = resume.replace('_', ' ');
		//Et pour finir on rajoute le crochet fermé pour l'affichage
		resume += "]";
		System.out.println(resume);
	}
	
}