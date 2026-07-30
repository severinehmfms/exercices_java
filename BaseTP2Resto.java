import java.util.Scanner;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant au TP2 - DEV Java
 */

public class BaseTP2Resto{
	private static Scanner scanner = new Scanner(System.in);	
	private static int nb_choix = 5;
	
	/*
	private static enum Entree {
		SALADE("Salade"), SOUPE("Soupe"), QUICHE("Quiche"), AUCUNE("Aucune");
		
		private final String description;

		Entree(String description) {
		this.description = description;
		}

		public String getDescription() {
		return description;
		}
	
	}*/
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
		
		//Test enum description
		//Entree salade = Entree.SALADE;
		//System.out.println(salade.getDescription());
		
		//On demande à l'utilisateur combien de menus il veut commander
		int nb_menus = input_int("Bonjour, combien de menus souhaitez vous ?", 1, 10);
		int [][] commandes = new int [nb_menus][nb_choix];
		for (int i = 0; i < nb_menus; i++) {
			System.out.println("Commande numéro " + (i+1) + " : ");
			
			//On appelle la fonction qui demande à l'utilisateur sa commande			
			int [] commande = commande_menu();
			//On rajoute la commande dans le tableaux des commandes
			commandes[i] = commande;
			//On affiche le résumé de la commande pour ce menu là
			print_resume_subcommande(commandes[i],i+1);
		}
		
		//On referme le scanner
		scanner.close();
	}
		
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
		int input_int_user;
		System.out.println(prompt);
		input_int_user = scanner.nextInt();
		while (input_int_user > max_val || input_int_user < min_val) {
			System.out.println("Le chiffre entré doit être entre " + min_val + " et " + max_val);
			input_int_user = scanner.nextInt();
		}
		return input_int_user;
	}
	
	/** 
	 * Méthode générique pour afficher un tableau simple
	 * @param tab
	 */
	public static void print_tab(int[] tab) {
		for (int valeur : tab) {
            System.out.print(valeur + " ");
        }
		System.out.println();
	}
	
	/**
	 * Méthode qui va afficher le résumé du menu de l'utilisateur
	 * @param commande
	 */
	public static void print_resume_subcommande(int[] commande, int num_commande) { 
		System.out.println("Résumé de la commande " + num_commande + " : ");
		String resume = "[";
		for (int i = 0; i < commande.length; i++) {
			switch (i) {
				case 0:
					if (!Entree.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Entree.values()[commande[i]];
						
						if ( (!resume.endsWith("[")) && (!resume.endsWith(",")) ) {
							resume += " ";
						}
					}
					break;
				case 1:
					if (!Plat.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Plat.values()[commande[i]];
						
						if ( (!resume.endsWith("[")) && (!resume.endsWith(",")) ) {
							resume += " ";
						}
					}
					break;
				case 2:
					if (!Accompagnement.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Accompagnement.values()[commande[i]];
						
						if ( (!resume.endsWith("[")) && (!resume.endsWith(",")) ) {
							resume += " ";
						}
					}
					break;
				case 3:
					if (!Boisson.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Boisson.values()[commande[i]];
						
						if ( (!resume.endsWith("[")) && (!resume.endsWith(",")) ) {
							resume += ",";
						}
					}
					break;
				case 4:
					if (!Dessert.values()[commande[i]].name().startsWith("AUCUN")){
						resume += Dessert.values()[commande[i]];
					}
					break;
			}
		}
		resume += "]";
		resume = resume.replace('_', ' ');
		System.out.println(resume);
	}
	
}