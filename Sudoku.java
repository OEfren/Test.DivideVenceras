public class Sudoku {
    
    private int tablero[][];
    
    public Sudoku(int sudoku[][]){
        this.tablero=sudoku;
    }
    
    public boolean resolverSudoku(){
        
        for (int fila = 0; fila < 9; fila++) {
        	
            for (int columna=0; columna<9; columna++){
            	
                if(tablero[fila][columna] == 0) {
                	
                    for (int numero = 1; numero <= 9; numero++) {
                    	
                        if ( esValido(fila, columna, numero) ) {
                        	
                            tablero[fila][columna] = numero;
                            
                            if ( resolverSudoku() ) {
                                return true;
                            }
                            else {
                                tablero[fila][columna] = 0;
                            }
                            
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean esValido (int fila, int columna, int numero){
        return !( contieneFila(fila,numero) || contieneColumna(columna,numero) || contieneCaja(fila,columna,numero) );
    }
    
    private boolean contieneFila(int fila, int numero){
        for(int columna = 0;columna < 9; columna++){
            if(tablero[fila][columna]==numero){
                return true;
            }
        }
        return false;
    }
    
    private boolean contieneColumna(int columna,int numero){
        for(int fila=0;fila<9;fila++){
            if(tablero[fila][columna]==numero){
                return true;
            }
        }
        return false;
    }
    
    private boolean contieneCaja(int fila, int columna, int numero){
        int indiceFila = fila - fila % 3;
        int indiceColumna = columna - columna % 3;
        
        for (int i =indiceFila;i<indiceFila+3;i++) {
        	
            for(int j = indiceColumna; j<indiceColumna+3;j++){
                if(tablero[i][j] == numero){
                    return true;
                }
            }
            
        }
        return false;
    }
    
	public void imprimirSudoku(){
	    for(int fila = 0;fila < 9; fila++){
	        for (int columna = 0; columna < 9; columna++) {
	            System.out.print(tablero[fila][columna]);
	        }
	        System.out.println();
	    }
	}    
	
	public static void main(String[] args) {
        int tablero[][];
        
        tablero = new int[][]
        		{{5,0,0,9,1,3,7,2,0},
    			       {3,0,0,0,8,0,5,0,9},
                 {0,9,0,2,5,0,0,8,0},
                 
                 {6,8,0,4,0,0,2,3,0},
                 {0,0,9,5,0,0,4,6,0},
                 {7,0,4,0,0,0,0,0,5},
                 
                 {0,2,0,0,0,0,0,0,0},
                 {4,0,0,8,9,1,6,0,0},
                 {8,5,0,7,2,0,0,0,3}};
        
        Sudoku sudoku;
        
        sudoku = new Sudoku(tablero);
        sudoku.resolverSudoku();
        System.out.println();
        sudoku.imprimirSudoku();
       
        tablero = new int[][]
        		{{6,9,0,0,0,0,7,0,0},
    			       {0,0,0,0,9,6,0,0,0},
                 {0,8,0,7,5,3,0,9,0},
                 
                 {0,2,0,3,7,4,5,6,1},
                 {3,6,0,0,0,5,0,2,0},
                 {0,0,0,9,6,0,3,7,8},

                 {0,0,6,0,3,1,0,8,4},
                 {0,4,5,8,0,7,6,0,0},
                 {0,0,0,0,0,0,0,5,7}};
                 
       sudoku = new Sudoku(tablero);
       sudoku.resolverSudoku();
       System.out.println();
       sudoku.imprimirSudoku();
    }
        
}
    
