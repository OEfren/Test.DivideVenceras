package mx.com.test.uag.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mochila {
	
    public void cargarMochila(int[] valores, int[] pesos, int capacidad) {
       
        int[][] elementos = new int[ valores.length + 1 ][ capacidad + 1 ];
        
        for (int indexColumna = 1; indexColumna <= valores.length; indexColumna++) {
            for (int indexRow = 0; indexRow <= capacidad; indexRow++) {
                if (pesos[ indexColumna - 1 ] > indexRow) {
                	elementos[ indexColumna ][ indexRow ] = elementos[ indexColumna - 1 ][ indexRow ];   
                }
                else {
                	int valorAnt = elementos[ indexColumna - 1 ][ indexRow ];
                	int valorCal = elementos[ indexColumna - 1 ][ indexRow - pesos[indexColumna-1] ] + valores[ indexColumna - 1];
                	
                	if (valorAnt > valorCal) {
                		elementos[indexColumna][indexRow] = valorAnt;
                	}
                	else {
                		elementos[indexColumna][indexRow] = valorCal;
                	}	
                }
            }
        }
        
        List<Integer> objetos = new ArrayList<Integer>();
    	int j = capacidad;
    	for (int i= pesos.length; i>0; i--) {
    	    if (elementos[i][j] != elementos[i-1][j] &&
    	    		elementos[i][j] == elementos[i-1][j-pesos[i - 1]] + valores[i - 1]){
    	        objetos.add(i);
    	        j -= pesos[i - 1];
    	    }
    	}
        
        int maximoValor = elementos[ valores.length ][ capacidad ];

        List<Integer> valorConsireados = new ArrayList<Integer>();
        for (int objeto : objetos) {
        	valorConsireados.add(valores[objeto - 1]);
        }
        
        System.out.println("Index de Valores : " + Arrays.toString(objetos.toArray()));
        System.out.println("Valores : " + Arrays.toString(valorConsireados.toArray()));
        System.out.println("Max. Valor: " + maximoValor);
    }
 
    public static void main(String[] args) {
        int[] valores 	= { 79, 32, 47, 18, 26, 85, 33, 40, 45, 59 };
        int[] pesos 	= { 85, 26, 48, 21, 22, 95, 43, 45, 55, 52 };
    	int capacidad = 140;
    	
    	Mochila mochila = new Mochila();
        mochila.cargarMochila(valores, pesos, capacidad);
    }
}
