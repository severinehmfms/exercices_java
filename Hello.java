
import java.util.Scanner;


public class Hello{
	
	public static void main(String[] args){
		
		System.out.println("Bonjour et bienvenue dans mon programme java");
		
		// Si on a entré le nom en argument
		if (args.length > 0) {
			System.out.println("Bonjour " + args[0]);
			
		// Si pas de nom en arguments on demande à l'utilisateur le nom et le prénom 
		}else{
			Scanner scanner = new Scanner(System.in);
			
			try {
				System.out.print("Quel est votre nom: ");

				String nom = scanner.nextLine();
				
				System.out.print("Quel est votre prénom: ");
				
				String prenom = scanner.nextLine();
				
				// Si la chaine n'est pas vide
				if (!nom.trim().isEmpty() && !prenom.trim().isEmpty()) {
					System.out.println("Bonjour " + prenom + " " + nom);
				}
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			} finally {
				scanner.close();
			}
		}
	}
}