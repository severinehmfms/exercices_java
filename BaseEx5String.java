import java.lang.String;
import java.util.Scanner;

/**
 * Séverine Hori Maitrehut
 * Classe correspondant à l'exercice 5 DEV Java
 */

public class BaseEx5String{
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args){
		
		
		//5.1 Plusieurs méthodes pour concaténer chaine + chaine2
		String chaine1 = "Ma chaine ";
		String chaine2 = "de caractères ";
		System.out.println(chaine1 + chaine2);
		System.out.println(chaine1.concat(chaine2));
		
		//5.2 Présence d'un mot
		String sentence = "Il fait beau aujourd'hui";
		String word_to_replace = "Beau";
		if (is_in_sentence(sentence, word_to_replace.toLowerCase())) {
			System.out.println("Ce mot fait bien partie de cette phrase");
		}else {
			System.out.println("Ce mot ne fait pas partie de cette phrase");
		}
		
		//5.3 Remplacer le mot trouvé par un autre saisi par l'utilisateur
		String new_word = input_string("Par quel mot voulez vous remplacer " + word_to_replace + " ? ");
		//String new_sentence = sentence.replaceAll("Beau", new_word);
		String new_sentence = sentence.replaceFirst(word_to_replace.toLowerCase(), new_word.toLowerCase());
	    System.out.println(new_sentence);
	    
	    //5.4 et 5.5 
	    String palindrome = "Elu par cette crapule";
	    if (is_palindrome(palindrome)) {
	    	System.out.println(palindrome + " est un palindrome");
	    }else {
	    	System.out.println(palindrome + " n'est un palindrome");
	    }
		
	  //On referme le scanner
	  scanner.close();
	}	
	
	/**
	 * Fonction qui vérifie la présence d'un mot dans une phrase, renvoie true si existe, false sinon
	 * @param sentence
	 * @param word
	 * @return
	 */
	public static boolean is_in_sentence(String sentence, String word){
		if (sentence.indexOf(word) != -1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Fonction qui teste si une chaîne est un palindrome
	 * @param sentence
	 * @return
	 */
	public static boolean is_palindrome(String my_sentence){
		//On enlève les espaces
		my_sentence = my_sentence.replaceAll("\\s+", "");
		//On met en minuscules
		my_sentence = my_sentence.toLowerCase();
		int gauche = 0;
		int droite = my_sentence.length() - 1;
		
		//On compare de l'extérieur vers l'intérieur les lettres et on s'arrête quand on arrive à la lettre du milieu
		while (gauche < droite) {
			if (my_sentence.charAt(gauche) != my_sentence.charAt(droite)) {
				return false;
			}
			gauche++;
			droite--;
		}
		
		return true;
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