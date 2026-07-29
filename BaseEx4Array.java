
/**
 * Séverine Hori Maitrehut
 * Classe correspondant à l'exercice 4 DEV Java - Partie 1
 */

public class BaseEx4Array{
	
	/**
	 * Fonction qui renvoie la note la plus petite du tableau de notes passé en paramètre
	 * @param notes
	 * @return min_note 
	 */
	public static double get_min_note(double[] notes){
		double min_note = 20;
		for (int i = 0 ; i < notes.length ; i++) {
			if (notes[i] < min_note) {
				min_note = notes[i];
			}
		}
		return min_note;
	}
	
	/**
	 * Fonction qui renvoie la note la plus grande du tableau de notes passé en paramètre
	 * @param notes
	 * @return max_note 
	 */
	public static double get_max_note(double[] notes){
		double max_note = 0;
		for (int i = 0 ; i < notes.length ; i++) {
			if (notes[i] > max_note) {
				max_note = notes[i];
			}
		}
		return max_note;
	}
	
	/**
	 * Fonction qui renvoie la moyenne des notes du tableau de notes passé en paramètre
	 * @param notes
	 * @return  
	 */
	public static double get_average_notes(double[] notes){
		double sum_notes = 0;
		for (int i = 0 ; i < notes.length ; i++) {
			sum_notes += notes[i];
		}
		return sum_notes/notes.length;
	}
	
	
	public static void main(String[] args){
		double [] notes = {10.5, 14, 5, 8, 15.5, 7, 2, 19, 18, 16};
		
		System.out.println("La note minimale est : " + get_min_note(notes) );
		System.out.println("La note maximale est : " + get_max_note(notes) );
		System.out.println("La moyenne des notes est de : " + get_average_notes(notes) );
		
	}
	
	
}