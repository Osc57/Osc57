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
		while (nCervezas<6) {
			if (nCervezas==5){
				System.out.println("No bebas más");
				System.out.println(" ");
				
			} else{
				System.out.println("Llevas " + nCervezas);
				System.out.println(" ");
					
			}
			
		nCervezas +=1;
		System.out.println("Echa otra");
		
		
		}
	}

}

