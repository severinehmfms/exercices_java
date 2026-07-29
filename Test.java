import java.util.Scanner;


public class Test extends Exception{
	
	public static String get_type_nb(int nb){
		String result = "";
		if (nb > 0){
			result += "L'entier " + nb + " est positif ";
		}else if (nb < 0){
			result += "L'entier " + nb + "  est négatif ";
		}else{
			result += "L'entier  " + nb + " est neutre ";
		}
		
		if (nb % 2 == 0){
			result += "et pair";
		}else{
			result += "et impair";
		}
		return result;
	}
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nb;
		// Si on a entré le nom en argument
		if (args.length > 0 ) {
			for (int i = 0 ; i < args.length ; i++) {
			//for (String str : args) {
				try {
					nb = Integer.parseInt(args[i]);
					//nb = Integer.parseInt(str);
					String result = get_type_nb(nb);
					System.out.println(result);
				} catch (NumberFormatException e) {
					System.out.println("Erreur : \"" + args[0] + "\" n'est pas un entier valide.");
				}
			}
			
		}else{
			System.out.println("Entrez un entier");
			try {
				nb = scanner.nextInt();
				String result = get_type_nb(nb);
				System.out.println(result);
			} catch (Exception e) {
				System.out.println("Erreur vous n'avez pas saisi un entier " + e);
			} finally {
				scanner.close();
			}
		}
	}
}