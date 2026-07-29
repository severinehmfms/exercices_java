import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class StudentManagement{
	
	private static Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Double>> students = new HashMap<>();
    

    /** 
     * Classe de gestion des élèves
     * @param args
     */
	public static void main(String[] args){
		
		//TODO Données de test à supprimer ensuite
		students.put("pierre dupont", Arrays.asList(15.0, 12.5, 18.0));
		students.put("alix smith", Arrays.asList(14.0, 16.5));
		students.put("alice martin", Arrays.asList(14.0, 16.5));
		students.put("martin durant", Arrays.asList(14.0, 16.5));
		students.put("marc durand", Arrays.asList(10.0, 13.5, 17.0));
		students.put("william smith", Arrays.asList(10.0, 13.5, 7.0));
		students.put("benoit smith", Arrays.asList(14.0, 16.5));
		students.put("bruno dupont", Arrays.asList(5.0, 10.5, 14.0));

		String choice_user = "";
		while (!choice_user.equals("q")) {
			System.out.println("\n MENU :\n 1: Saisir un élève et ses notes\n 2: Rechercher un élève \n 3: Afficher la liste \n 4: Afficher la liste dans l'ordre décroissant \n 5: Pareil mais à la mano \n 6: Ordre croissant à la mano \n Q: Quitter le programme ");
			choice_user = scanner.nextLine();
			choice_user = choice_user.toLowerCase();
			switch(choice_user) {
				case "1":
					// Saisie des élèves
					input_student();
					break;
				case "2":
					// On demande à l'utilisateur de rentrer le nom et le prénom de l'élève
					String last_name = input_string("Entrez le nom de l'élève");
					String first_name = input_string("Entrez le prénom de l'élève");
					if (is_exists_student(first_name, last_name)) {
						get_notes_by_student(first_name, last_name);
					}
					break;
				case "3":
					// Affichage du tableau 
					display_list_students();
					break;
				case "4":
					// Afficher les élèves triés par le prénom décroissant
					display_list_order_by("first_name", "decroissant");
					break;
				case "5":
					// Afficher les élèves triés par le prénom décroissant (pareil que précédemment mais à la mano)
					display_list_order_by_bis("first_name", "decroissant");
					break;
				case "6":
					// Afficher les élèves triés par le prénom dans l'ordre croissant
					display_list_order_by_bis("first_name", "croissant");
					break;
				case "q":
					System.out.println("Au-revoir et à bientôt !");
					break;
				default:
					System.out.println("Saisie incorrecte, veuillez recommencer.");
					break;
			}	
		}
	}
	
	/**
	 * Fonction qui renvoie la moyenne des notes du tableau de notes passé en paramètre
	 * @param notes
	 * @return  
	 */
	public static double get_average_notes(List<Double> notes){
		double sum_notes = 0;
		for (Double note : notes) {
			sum_notes += note;
	    }
		return sum_notes/notes.size();
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
	
	/** 
	 * Fonction qui permet au professeur de saisir les élèves et leurs notes 
	**/
	public static void input_student(){		
		String input_start = "oui";
		while (input_start.equals("oui") || input_start.equals("o")) {
			List<Double> notes = new ArrayList<>();
			String last_name = input_string("Entrez le nom de l'élève");
			String first_name = input_string("Entrez le prénom de l'élève");
			String string_student = first_name + " " + last_name;			
			
			System.out.println("Entrez les notes de l'élève, une par une et validez avec Entrée. A la fin de la saisie des notes, tapez Fin ");
			while (scanner.hasNextDouble()) {
			  // A près avoir récupéré la note. On la "consomme" pour libérer le tampon. 
			  double note = scanner.nextDouble(); scanner.nextLine();  
			  System.out.println("On ajoute la note " + Double.toString(note) + " pour l'élève " + string_student + " ");
			  notes.add(note);
			}
			// Correction du bug : Consomme le "Fin"
			scanner.nextLine();
			students.put(string_student, notes);			
			System.out.println("On vient d'ajouter l'élève  "+ string_student + " - Moyenne : " + get_average_notes(notes) + " ");
				
			System.out.println("Voulez vous ajouter un autre élève ? oui/non ");
			input_start = scanner.nextLine();
			input_start = input_start.toLowerCase();
			if (input_start.equals("non") || input_start.equals("n")) {
				System.out.println("Au-revoir");
			}
		}
	}
	
	/** 
	 * Fonction qui vérifie si un élève a déjà été saisie
	 * Renvoie un booléen true/false
	**/
	public static boolean is_exists_student(String first_name, String last_name) {
		// Pour chaque entrée de la map sous forme chaine et liste double 
		for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
			if (entry.getKey().equals(first_name + " " + last_name)) {
				return true;
			}
		}
		return false;		
	}
	
	/** 
	 * Méthode qui affiche les notes d'un élève dont la chaine prénom nom est passée en paramètre
	**/
	public static void get_notes_by_student(String first_name, String last_name) {
		// Pour chaque entrée de la map sous forme chaine et liste double 
		for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
			if (entry.getKey().equals(first_name + " " + last_name)) {
				System.out.println("Voici les notes de l'élève " + first_name + " " + last_name + " : ");
				for (Double note : entry.getValue()) {
			        System.out.print(note + " ");
			    }
				System.out.println("\n Moyenne de l'élève  : " + get_average_notes(entry.getValue()) + "  ");
			}
		}
	}
	
	/** 
	 * Méthode pour afficher la Map proprement
	**/
	public static void display_list_students(){
		// Pour chaque entrée de la map sous forme chaine et liste double 
		for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
		    System.out.print(entry.getKey() + " : ");

		    for (Double note : entry.getValue()) {
		        System.out.print(note + " ");
		    }

		    System.out.println();
		}
	}
	
	/**
	 * Fonction qui trie la liste des prénoms par ordre croissant si sens_tri = croissant,
	 * var_order_by = first_name / last_name
	 * sens_tri = croissant / decroissant
	*/
	public static void display_list_order_by(String var_order_by, String sens_tri) {
		if (sens_tri.equals("croissant")) {
			System.out.println("Tri des élèves dans l'ordre croissant : ");
		}else{
			System.out.println("Tri des élèves dans l'ordre décroissant : ");
		}
		String first_name_student;
		String last_name_student;
		List<String> list_order = new ArrayList<String>();
		//On récupère les prénoms de la liste (ou les noms)
		for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
			//On va séparer prénom et nom avec un split
			String[] names_student = entry.getKey().split(" ");
			if (names_student.length > 0){
				//On récupère prénom et nom
				first_name_student = names_student[0];
				last_name_student = names_student[1];
				//Si le tri est sur le prénom on ajoute le prénom 
				if (var_order_by.equals("first_name")) {
					list_order.add(first_name_student + " " + last_name_student);
				}else {
					list_order.add(last_name_student + " " + first_name_student);
				}
			}			
		}
		if (sens_tri == "croissant") {
			// Tri croissant
			Collections.sort(list_order);
		    System.out.println(list_order);
		}else {
			// Tri décroissant
	        Collections.sort(list_order, Collections.reverseOrder());
	        System.out.println(list_order);
		}
	}
	
	/** 
	 * Fonction qui trie la liste des prénoms par ordre croissant si sens_tri = croissant,
	 * Idem mais cette fois, méthode faite "à la mano" pour entrainement.
	 * var_order_by = first_name / last_name
	 * sens_tri = croissant / decroissant
	*/
	public static void display_list_order_by_bis(String var_order_by, String sens_tri) {
		if (sens_tri.equals("croissant")) {
			System.out.println("Tri des élèves dans l'ordre croissant : ");
		}else{
			System.out.println("Tri des élèves dans l'ordre décroissant : ");
		}
		
		String first_name_student;
		String last_name_student;
		String [] array_students = new String[students.size()];
		int cpt = 0;
		
		//On récupère les prénoms de la liste (ou les noms) dans un tableau
		for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
			//On va séparer prénom et nom avec un split
			String[] names_student = entry.getKey().split(" ");
			if (names_student.length > 0){
				//On récupère prénom et nom
				first_name_student = names_student[0];
				last_name_student = names_student[1];
				//Si le tri est sur le prénom on ajoute le prénom 
				if (var_order_by.equals("first_name")) {
					array_students[cpt] = first_name_student + " " + last_name_student;
				}else {
					array_students[cpt] = last_name_student + " " + first_name_student;
				}
			}
			cpt ++;
		}
		
		//On va maintenant trier ce tableau
		int indice_min;
		int indice_max;
		
		//On parcoure une première fois le tableau avec l'indice i
		for (int i = 0 ; i < array_students.length ; i ++ ) {
			
			//L'indice minimum pour parcourir à nouveau le tableau devient i.
			indice_min = i;
			
			//Pour chaque valeur de i, on reparcoure le tableau de l'indice i jusqu'à la fin du tableau 
			for (int j = i+1 ; j < array_students.length ; j++) {
				
				// Tri croissant
				if (sens_tri.equals("croissant")) {
					//On va comparer la première lettre de array_students[j] avec celle de array_students[index_min] (qui est égal à celui de i en cours)
					//if (array_students[j].charAt(0) < array_students[indice_min].charAt(0)) {
					if (array_students[j].compareToIgnoreCase(array_students[indice_min]) < 0) {
						//Si tri croissant - Si la première lettre de l'élève de l'indice j est plus petite que celle de l'élève de indice_min, on met j comme indice_min
						indice_min = j;
					}			
				//Tri décroissant
				}else { 
				    if (array_students[j].compareToIgnoreCase(array_students[indice_min]) > 0) {
				        indice_min = j;
				    }
				}
			}
			//On échange la valeur correspondant à l'indice i et celle correspondant à indice minimum
			//System.out.println(" i = " + i + " - indice min = " + indice_min + " on va échanger " + array_students[i] + " avec " + array_students[indice_min] );
			String temp = array_students[i];
			array_students[i] = array_students[indice_min];
			array_students[indice_min] = temp;
		}
		
		//On affiche le tableau dans l'ordre
		for (int i = 0 ; i < array_students.length ; i++) {
			System.out.println("- " + array_students[i]);
		}
	}
	
	
	
}