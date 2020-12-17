package modelo;

public class Main {

	private int filas = 50, columnas = 50;
	private boolean matriz[][] = new boolean[filas][columnas];

	public static void main(String[] args) {

	}

	public boolean[][] siguienteIteracion(boolean matriz[][]) {

		boolean auxiliar[][] = new boolean[3][3];
		boolean matrizFutura[][] = new boolean[50][50]; // refrescamos la matriz anterior con esta nueva

		for (int fMatriz = 0; fMatriz < matriz.length; fMatriz++) {

			for (int cMatriz = 0; cMatriz < matriz[fMatriz].length; cMatriz++) {

				for (int fAuxiliar = 0; fAuxiliar < auxiliar.length; fAuxiliar++) {

					for (int cAuxiliar = 0; cAuxiliar < auxiliar[fAuxiliar].length; cAuxiliar++) {

						auxiliar[fAuxiliar][cAuxiliar] = matriz[fMatriz + fAuxiliar - 1][cMatriz + cAuxiliar - 1]; // fMatriz
																													// =
																													// 3
																													// /
																													// cMatriz
																													// =
																													// 3

					}

				}

				matrizFutura[fMatriz][cMatriz] = comprobarCelulasVecinas(auxiliar);

			}

		}

		return matriz;
	}

	public boolean comprobarCelulasVecinas(boolean matrizVecina[][]) {

		/*
		 * Una célula muerta con exactamente 3 células vecinas vivas "nace" (es decir,
		 * al turno siguiente estará viva).
		 * 
		 * Una célula viva con 2 o 3 células vecinas vivas sigue viva, en otro caso
		 * muere (por "soledad" o "superpoblación").
		 */

		int cont = 0;

		for (int i = 0; i < matrizVecina.length; i++) {

			for (int j = 0; j < matrizVecina[i].length; j++) {

				if (matrizVecina[i][j] == true & i != 1 & j != 1) {

					cont++;

				}

			}

		}

		if ((cont == 2 | cont == 3) && matrizVecina[1][1] == true) // si está viva (matrizVecina == yoMismo)

			return true;

		if (cont == 3) // si está muerta

			return true;

		return false;

	}

	public int contarCelulasVecinas() {

		boolean auxiliar[][] = new boolean[3][3];

		for (int fAuxiliar = 0; fAuxiliar < auxiliar.length; fAuxiliar++) {

			for (int cAuxiliar = 0; cAuxiliar < auxiliar[fAuxiliar].length; cAuxiliar++) {

				auxiliar[fAuxiliar][cAuxiliar] = matriz[fMatriz + fAuxiliar - 1][cMatriz + cAuxiliar - 1]; // fMatriz =
																											// 3 /
																											// cMatriz =
																											// 3

			}

		}

		return 0;

	}

}
