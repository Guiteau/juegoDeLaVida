package modelo;

public class Main {

	private static boolean matriz[][];

	public static void main(String[] args) {

		matriz = new boolean[5][5];

		matriz[2][3] = true;
		matriz[2][2] = true;
		matriz[2][1] = true;

		for (int i = 0; i < 5; i++) {
			imprimirMatriz(matriz, i);
			matriz = siguienteIteracion();

		}
	}

	public static void imprimirMatriz(boolean matriz[][], int iter) {
		String cell = "";
		for (int fMatriz = 0; fMatriz < matriz.length; fMatriz++) {

			for (int cMatriz = 0; cMatriz < matriz[fMatriz].length; cMatriz++) {
				cell = matriz[fMatriz][cMatriz] ? "1" : "0";
				System.out.print(cell);
			}
			System.out.println();
		}
		System.out.println(iter + ". ---------------------");
	}

	public static boolean[][] siguienteIteracion() {

		boolean auxiliar[][] = new boolean[3][3];
		boolean matrizFutura[][] = new boolean[matriz.length][matriz[0].length]; // refrescamos la matriz anterior con
																					// esta nueva

		for (int fMatriz = 1; fMatriz < matriz.length - 1; fMatriz++) {

			for (int cMatriz = 1; cMatriz < matriz[fMatriz].length - 1; cMatriz++) {

				for (int fAuxiliar = 0; fAuxiliar < auxiliar.length; fAuxiliar++) {

					for (int cAuxiliar = 0; cAuxiliar < auxiliar[fAuxiliar].length; cAuxiliar++) {

						auxiliar[fAuxiliar][cAuxiliar] = matriz[fMatriz + fAuxiliar - 1][cMatriz + cAuxiliar - 1];

					}

				}
				matrizFutura[fMatriz][cMatriz] = comprobarCelulasVecinas(auxiliar);

			}

		}

		return matrizFutura;
	}

	public static boolean comprobarCelulasVecinas(boolean matrizVecina[][]) {

		/*
		 * Una célula muerta con exactamente 3 células vecinas vivas "nace" (es decir,
		 * al turno siguiente estará viva).
		 * 
		 * Una célula viva con 2 o 3 células vecinas vivas sigue viva, en otro caso
		 * muere (por "soledad" o "superpoblación").
		 */

		int cont = 0;
		int i = 0;

		for (i = 0; i < matrizVecina.length; i++) {

			for (int j = 0; j < matrizVecina[i].length; j++) {

				if (matrizVecina[i][j] == true & !(i==1 & j==1)) {
					cont++;
				}

			}

		}

		boolean celula=matrizVecina[1][1];
		if (cont == 3 && !celula)
			return true;

		if ((cont == 2 || cont == 3) && celula)
			return true;

		return false;

	}
}
