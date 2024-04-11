/*ejercicio: renombrar variable n a nCervezas, clase PruebaDepurar
 a ContarCervezas y extraer método While*/


public class ContarCervezas {
	//programa que va sumando cervezas hasta que lleve 5, entonces da un mensaje de que pare de beber
	public static void main(String[] args) {
		
		
		
		int nCervezas=0;
		
		cuentabirras(nCervezas);
		
		System.out.println("Estás bebido, tira para casa");

	}

	private static void cuentabirras(int nCervezas) {
		float precioCerveza = (float) 1.50;
		while (nCervezas<6) {
			if (nCervezas==5){
				System.out.println("No bebas más");
				System.out.println(" ");
				float total = precioCerveza*nCervezas;
				System.out.println("Te has gastado " + total + " euros");
				break;
				
				
			} else{
				System.out.println("Llevas " + nCervezas);
				System.out.println(" ");
				System.out.println("Echa otra");
				
					
			}
			
			
		nCervezas +=1;
		
		
		
		}
	}

}

