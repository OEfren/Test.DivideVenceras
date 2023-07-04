public class Cuerda {

	
   public int cortar(int[] precios, int longitud)  {
        int[] elementos = new int[longitud + 1];
 
        for (int i = 1; i <= longitud; i++) {

            for (int j = 1; j <= i; j++) {
                elementos[i] = Integer.max(elementos[i], precios[j - 1] + elementos[i - j]);
            }
        }
 
        return elementos[longitud];
    }
 
    public static void main(String[] args) {
        int[] precios = { 1, 4, 10, 12, 15, 20, 21, 32, 31, 41, 51 };
        int tamanio = 11; 
 
        
        Cuerda cuerda = new Cuerda();
        System.out.print("Ganancia mayor " + cuerda.cortar(precios, tamanio));
    }
	
}
