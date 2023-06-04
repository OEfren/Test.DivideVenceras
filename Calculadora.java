package uag;

public class Calculadora {

	
	private static long calcularFibonaciByMatriz(int position) {
		long[][] matrizBase 		= {{0,1}, {1,1}};
		long[][] matrizCalcuada 	= {{0,1}, {1,1}};
		
		for (int index = 1; index < position; index ++) {
			long c1 = matrizCalcuada[0][0] * matrizBase[0][0] + matrizCalcuada[0][1] * matrizBase[1][0];
			long c2 = matrizCalcuada[0][0] * matrizBase[0][1] + matrizCalcuada[0][1] * matrizBase[1][1];
			long c3 = matrizCalcuada[1][0] * matrizBase[0][0] + matrizCalcuada[1][1] * matrizBase[1][0];
			long c4 = matrizCalcuada[1][0] * matrizBase[0][1] + matrizCalcuada[1][1] * matrizBase[1][1];
			matrizCalcuada[0][0] = c1;
			matrizCalcuada[0][1] = c2;
			matrizCalcuada[1][0] = c3;
			matrizCalcuada[1][1] = c4;
			System.out.println(matrizCalcuada[0][0] + " " + matrizCalcuada[0][1]);
			System.out.println(matrizCalcuada[1][0] + " " + matrizCalcuada[1][1]);
			System.out.println("-------");
		}
		return matrizCalcuada[1][1];	
	}
	
	public static void main(String[] args) {
		int position = 50;
		long startTime;
		startTime= System.nanoTime();
		System.out.println("Resultado lin: " +  calcularFibonaciByMatriz(position));
		System.out.println(System.nanoTime() - startTime);
		
		startTime = System.nanoTime();
		
		long[][] matriz = {{0,1}, {1,1}};
		System.out.println("Resultado log: " + exp(matriz, position)[1][1]);
		System.out.println(System.nanoTime() - startTime);
	}
	
	public static long[][] exp(long[][] x, int n) {
		if (n <= 1) {
			return x;
		}
		else {
			if (n % 2 == 0) {
				return exp(multiplicaMatriz(x, x), n / 2);
			}
			else {
				return multiplicaMatriz(x, exp(multiplicaMatriz(x,x), (n - 1) / 2 ));
			}
		}
	}
	
	static int contador =1;
	private static long[][] multiplicaMatriz(long[][] a, long[][] b) {
		long[][] matriz = new long[2][2];
		matriz[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		matriz[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		matriz[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		matriz[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
		
		System.out.println(matriz[0][0] + " " + matriz[0][1]);
		System.out.println(matriz[1][0] + " " + matriz[1][1]);
		System.out.println("------- " + contador++);
		
		return matriz;
	}
	
	public static int exp(int x, int n) {
		if (n == 1) {
			return x;
		}
		else {
			if (n % 2 == 0) {
				return exp(x * x, n / 2);
			}
			else {
				return x * exp(x * x, (n - 1) / 2 );
			}
		}
	}
	
}
