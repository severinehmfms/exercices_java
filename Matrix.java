


public class Matrix {
	
	public static void main(String[] args){
		int[][] firstMatrix = { {5, 2, 4} ,
								{0, 1, 1} ,
								{6, 3, 1} };
		
		int[][] secondMatrix = { {1, 1, 3} ,
								 {2, 5, 6} ,
								 {3, 0, 5} };
	
		int[][] thirdMatrix = { {8, 7} ,
								{5, 4} ,
								{2, 1} };
		
		int[][] fourthMatrix = { {0, 2} ,
								 {1, 2} ,
								 {1, 1} };
		
		addMatrix(firstMatrix, secondMatrix);
		System.out.println("-------------");
		addMatrix(firstMatrix, thirdMatrix);
		System.out.println("-------------");
		subMatrix(thirdMatrix, fourthMatrix);
		System.out.println("-------------");
		mulMatrix(fourthMatrix, 2);
		System.out.println("-------------");	
	}	
	
	/**
	 * Fonction qui permet d'afficher une matrice
	 * @param my_matrix
	 */
	public static void printMatrix(int[][] my_matrix) {
		for (int i = 0; i < my_matrix.length; i++) {
			for (int j = 0; j < my_matrix[i].length; j++) {
				System.out.print(my_matrix[i][j]+"     ");
			}
			System.out.print("\n");
		}
	}
	
	public static void addMatrix(int[][] a, int[][] b){
		int nb_lignes = a.length;
		int nb_colonnes = (nb_lignes > 0) ? a[0].length : 0;
		int [][] result = new int [nb_lignes][nb_colonnes];
		
		boolean is_op_ok = true;
		is_op_ok = true;
		
		//On vérifie si les deux matrices ont le même nombre de lignes (=première dimension du tableau)
		if (a.length != b.length) {
			is_op_ok = false;
		}
		//On vérifie si les deux matrices ont le même nombre de lignes (=deuxième dimension du tableau)
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				is_op_ok = false;
			}
        }
		
		if (is_op_ok) {
			//On affiche la première matrice
			printMatrix(a);
			System.out.println("+");
			//On affiche la seconde matrice
			printMatrix(b);
			System.out.println("=");
			//On affiche le résultat
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					//On affiche le résultat de la case pour a + la case pour b
					System.out.print(a[i][j] + b[i][j]+"     ");
					//On enregistre dans un tableau result pour pouvoir le retourner s'il y a besoin.
					result[i][j] = a[i][j] + b[i][j];
				}
				System.out.print("\n");
			}
			//On affiche la matrice de résultat
			//printMatrix(result);
			
		}else {
			System.out.println("Pour les additionner, les matrices doivent avoir le même nombre de lignes et de colonnes !");
		}
	}
	
	public static void subMatrix(int[][] a, int[][] b){
		int nb_lignes = a.length;
		int nb_colonnes = (nb_lignes > 0) ? a[0].length : 0;
		int [][] result = new int [nb_lignes][nb_colonnes];
		
		boolean is_op_ok = true;
		is_op_ok = true;
		
		//On vérifie si les deux matrices ont le même nombre de lignes (=première dimension du tableau)
		if (a.length != b.length) {
			is_op_ok = false;
		}
		//On vérifie si les deux matrices ont le même nombre de lignes (=deuxième dimension du tableau)
		for (int i = 0; i < a.length; i++) {
			if (a[i].length != b[i].length) {
				is_op_ok = false;
			}
        }
		if (is_op_ok) {
			//On affiche la première matrice
			printMatrix(a);
			System.out.println("-");
			//On affiche la seconde matrice
			printMatrix(b);
			System.out.println("=");
			//On affiche le résultat
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					//On affiche le résultat de la case pour a + la case pour b
					System.out.print(a[i][j] - b[i][j]+"     ");
					//On enregistre dans un tableau result pour pouvoir le retourner s'il y a besoin.
					result[i][j] = a[i][j] - b[i][j];
				}
				System.out.print("\n");
			}
			//On affiche la matrice de résultat
			//printMatrix(result);
		}else {
			System.out.println("Pour les soustraire, les matrices doivent avoir le même nombre de lignes et de colonnes !");
		}
	}
	
	public static void mulMatrix(int[][] a, int b){
		int nb_lignes = a.length;
		int nb_colonnes = (nb_lignes > 0) ? a[0].length : 0;
		int [][] result = new int [nb_lignes][nb_colonnes];
		
		System.out.println(b + " * ");
		//On affiche la matrice
		printMatrix(a);
		System.out.println("=");
		//On affiche le résultat
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				//On affiche le résultat de la case pour a + la case pour b
				System.out.print(a[i][j] * b +"     ");
				//On enregistre dans un tableau result pour pouvoir le retourner s'il y a besoin.
				result[i][j] = a[i][j] * b;
			}
			System.out.print("\n");
		}
		//On affiche la matrice de résultat
		//printMatrix(result);
	}
	
}