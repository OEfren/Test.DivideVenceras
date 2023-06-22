class Elemento {
	
    public int valor;
    public int peso;
 
    public Elemento(int valor, int peso) {
    	this.valor = valor;
    	this.peso = peso;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (this.peso != other.peso) {
            return false;
        }
        if (this.valor != other.valor) {
            return false;
        }
        return true;
    }
 
    @Override
    public String toString(){
        return "Peso: " + peso + "," + " valor: " + valor;
    }
     
}

class Mochila {
	 
	public int valorMaximo;
	public Elemento[] elementos;
 
    public int valor;
    public int peso;
    
 
    public Mochila(int valorMaximo, int numElementos) {
        this.valorMaximo = valorMaximo;
        this.elementos = new Elemento[numElementos];
        this.valor = 0;
        this.peso = 0;
    }
 

    public void agregarElemento(Elemento e) {
        for (int i = 0; i < elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e; 		// Se asigna el elemento
                this.valor += e.valor;		// Aumenta el valor
                this.peso += e.peso; 		// Aumenta el peso
                break;
            }
        }
    }
    
    public void eliminarElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i].equals(e)) {
                this.elementos[i] = null; 	// Se remueve el elmento
                this.peso -= e.peso; 		// Reduce el peso
                this.valor -= e.valor; 		// Reduce el valor
                break;
            }
        }
    }
    
    public void clear() {
        this.peso = 0;
        this.valor = 0;
        for (int i = 0; i < this.elementos.length; i++) {
            this.elementos[i] = null;
        }
    }
    
    public boolean existeElemento(Elemento e) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null && this.elementos[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
 
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] != null) {
                cadena += elementos[i] + "\n";
            }
        }
        cadena += "Peso: " + peso + "\n";
        cadena += "Valor: " + valor + "\n";
        return cadena;
    }
    
}

public class Pesaje {
	
	public void llenarMochila(Mochila mochilaBase, Elemento[] elementos, boolean llena, Mochila mochialOpcional) {
		
		if (llena) {
			
			if (mochilaBase.valor > mochialOpcional.valor ) {
				Elemento[] elementosMochBase = mochilaBase.elementos;
				mochialOpcional.clear();
				
				for (Elemento e : elementosMochBase) {
					if (e != null) {
						mochialOpcional.agregarElemento(e);
					}
				}
			}
			
		} 
		else {
			
			for (int i = 0; i < elementos.length; i++) {
				
				if ( !mochilaBase.existeElemento(elementos[i]) ) {
					
					if (mochilaBase.valorMaximo > mochilaBase.valor + elementos[i].valor) {
						
						mochilaBase.agregarElemento(elementos[i]); 
						llenarMochila(mochilaBase, elementos, false, mochialOpcional);
						mochilaBase.eliminarElemento(elementos[i]);
						
					} 
					else {
						llenarMochila(mochilaBase, elementos, true, mochialOpcional);
					}
					
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Elemento[] elementos = {
            new Elemento(79, 85),
            new Elemento(32, 26),
            new Elemento(47, 48),
            new Elemento(18, 21),
            new Elemento(26, 22),
            new Elemento(85, 95),
            new Elemento(33, 43),
            new Elemento(40, 45),
            new Elemento(45, 55),
            new Elemento(59, 52)
        };
 
        Mochila mochilaBase = new Mochila(101, elementos.length);
        Mochila mochilaOpcional = new Mochila(101, elementos.length);
        
        Pesaje pesaje = new Pesaje();
        pesaje.llenarMochila(mochilaBase, elementos, false, mochilaOpcional);
        System.out.println(mochilaOpcional.toString());
	}
	

}

