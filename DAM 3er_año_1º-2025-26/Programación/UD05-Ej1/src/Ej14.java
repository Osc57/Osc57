/*14. Pueblos de Aragón. El programa mostrará al usuario las siguientes opciones:*/

import java.util.Arrays;
import java.util.Scanner;

public class Ej14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] huescaArray = {"Berbegal", "Chimillas", "Ibieca", "Altorricón", "Estada", "Sopeira", "Viacamp y Litera", "Salillas",
                "Hoz y Costean", "Perarrúa", "Antillón", "Pozán de Vero", "Biscarrués", "Lascuarre", "Santa Cilia de Jaca", "Fonz",
                "Angüés", "Grañén", "El Pueyo de Araguás", "Arguis"};
        String[] huescaCopia;
        String[] zaragozaArray = {"Belchite", "Ateca", "Cariñena", "Sos del Rey Católico", "Tarazona", "Alagón", "Ejea de los Caballeros",
                "Caspe", "Utebo", "La Almunia de Doña Godina", "Zuera", "Tauste", "Villanueva de Gállego", "Borja", "Calatayud", "Cuarte de Huerva",
                "Grisén", "Maella", "Gallur", "Daroca"};
        String[] zaragozaCopia;
        String[] teruelArray = {"Albarracín", "Alcañiz", "Andorra", "Calamocha", "Calanda", "Valderrobres", "Utrillas", "Cella", "Monreal del Campo",
                "Albalate del Arzobispo", "Híjar", "Mora de Rubielos", "Rubielos de Mora", "Cantavieja", "Sarrión", "Alfambra", "Aliaga", "Puertomingalvo",
                "Griegos", "Bronchales"};
        String[] teruelCopia;
        boolean provinciaCorrecta;

        /*
        a) Mostrar pueblos por provincia. Pedirá al usuario que elija la provincia:
        Huesca, Teruel, Zaragoza. Después mostrará todos los pueblos de la
        provincia ordenados por orden alfabético.
        */
        System.out.println("<--------------------- APARTADO A --------------------->");
        do {
            System.out.print("Dime la provincia (Huesca, Zaragoza o Teruel): ");
            String provincia = scanner.nextLine().trim();

            switch (provincia) {
                case "huesca" -> {
                    Arrays.sort(huescaArray);
                    for (String p : huescaArray) {
                        System.out.print(p + ", ");
                    }
                    provinciaCorrecta = true;
                }
                case "zaragoza" -> {
                    Arrays.sort(zaragozaArray);
                    for (String p : zaragozaArray) {
                        System.out.print(p + ", ");
                    }
                    provinciaCorrecta = true;
                }
                case "teruel" -> {
                    Arrays.sort(teruelArray);
                    for (String p : teruelArray) {
                        System.out.print(p + ", ");
                    }
                    provinciaCorrecta = true;
                }
                default -> {
                    System.out.println("Provincia Erronea");
                    provinciaCorrecta = false;
                }
            }
        } while (!provinciaCorrecta);

        /*
        b) Introducir pueblos por provincia. Pedirá al usuario que elija la
        provincia: Huesca, Teruel, Zaragoza. Después pedirá al usuario el
        número de pueblos de la provincia elegida que va a introducir y, a
        continuación, pedirá que los introduzca. Una vez introducidos añadirá
        los nuevos pueblos a la lista de pueblos de la provincia de seleccionada
        validando que no hay duplicados.
        */
        System.out.println();
        System.out.println("<--------------------- APARTADO B --------------------->");
        do {
            System.out.print("Dime la provincia (Huesca, Zaragoza o Teruel): ");
            String provincia = scanner.nextLine().toLowerCase().trim();

            switch (provincia) {
                case "huesca" -> {
                    System.out.print("Dime cuantos pueblos de Huesca quieres añadir: ");
                    if (scanner.hasNextInt()) {
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        huescaCopia = new String[n];

                        for (int i = 0; i < huescaCopia.length; i++) {
                            System.out.print("Dime el " + (i + 1) + " pueblo: ");
                            String pueblo = scanner.nextLine().trim();

                            boolean repetido = false;
                            for (int j = 0; j < huescaArray.length; j++) {
                                if (pueblo.equalsIgnoreCase(huescaArray[i].toLowerCase().trim())) {
                                    repetido = true;
                                    break;
                                }
                            }
                            if (repetido) {
                                System.out.println("ERROR: Pueblo existente");
                                i--;
                            } else {
                                huescaCopia[i] = pueblo;
                                System.out.println("Pueblo introducido con exito");
                            }

                        }

                        String[] resultado = Arrays.copyOf(huescaArray, huescaArray.length + huescaCopia.length);
                        System.arraycopy(huescaCopia, 0, resultado, huescaArray.length, huescaCopia.length);

                        huescaArray = resultado;

                        provinciaCorrecta = true;
                    } else {
                        System.out.println("ERROR: Introduce un número entero");
                        scanner.nextLine();
                        provinciaCorrecta = false;

                    }

                }
                case "zaragoza" -> {
                    System.out.print("Dime cuantos pueblos de Zaragoza quieres añadir: ");
                    if (scanner.hasNextInt()) {
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        zaragozaCopia = new String[n];

                        for (int i = 0; i < zaragozaCopia.length; i++) {
                            System.out.print("Dime el " + (i + 1) + " pueblo: ");
                            String pueblo = scanner.nextLine().toLowerCase().trim();

                            boolean repetido = false;
                            for (int j = 0; j < zaragozaArray.length; j++) {
                                if (pueblo.equalsIgnoreCase(zaragozaArray[i].toLowerCase().trim())) {
                                    repetido = true;
                                    break;
                                }
                            }
                            if (repetido) {
                                System.out.println("ERROR: Pueblo existente");
                                i--;
                            } else {
                                zaragozaCopia[i] = pueblo;
                                System.out.println("Pueblo introducido con exito");
                            }

                        }

                        String[] resultado = Arrays.copyOf(zaragozaArray, zaragozaArray.length + zaragozaCopia.length);
                        System.arraycopy(zaragozaCopia, 0, resultado, zaragozaArray.length, zaragozaCopia.length);

                        zaragozaArray = resultado;

                        provinciaCorrecta = true;
                    } else {
                        System.out.println("ERROR: Introduce un número entero");
                        scanner.nextLine();
                        provinciaCorrecta = false;

                    }
                }
                case "teruel" -> {
                    System.out.print("Dime cuantos pueblos de Teruel quieres añadir: ");
                    if (scanner.hasNextInt()) {
                        int n = scanner.nextInt();
                        scanner.nextLine();

                        teruelCopia = new String[n];

                        for (int i = 0; i < teruelCopia.length; i++) {
                            System.out.print("Dime el " + (i + 1) + " pueblo: ");
                            String pueblo = scanner.nextLine().trim();

                            boolean repetido = false;

                            for (int j = 0; j < teruelArray.length; j++) {
                                if (pueblo.equalsIgnoreCase(teruelArray[i].toLowerCase().trim())) {
                                    repetido = true;
                                    break;
                                }
                            }
                            if (repetido) {
                                System.out.println("ERROR: Pueblo existente");
                                i--;
                            } else {
                                teruelCopia[i] = pueblo;
                                System.out.println("Pueblo introducido con exito");
                            }

                        }

                        String[] resultado = Arrays.copyOf(teruelArray, teruelArray.length + teruelCopia.length);
                        System.arraycopy(teruelCopia, 0, resultado, teruelArray.length, teruelCopia.length);

                        teruelArray = resultado;

                        provinciaCorrecta = true;
                    } else {
                        System.out.println("ERROR: Introduce un número entero");
                        scanner.nextLine();
                        provinciaCorrecta = false;

                    }
                }
                default -> {
                    System.out.println("Provincia Erronea");
                    provinciaCorrecta = false;
                }
            }
        } while (!provinciaCorrecta);

        /*
        c) Mostrar todos los pueblos de las tres provincias en orden alfabético.
        */
        System.out.println();
        System.out.println("<--------------------- APARTADO C --------------------->");

        Arrays.sort(huescaArray);

        System.out.print("Huesca -> ");
        for (String p : huescaArray) {
            System.out.print(p + ", ");

        }

        System.out.println();
        Arrays.sort(zaragozaArray);

        System.out.print("Zaragoza -> ");
        for (String p : zaragozaArray) {
            System.out.print(p + ", ");

        }

        System.out.println();
        Arrays.sort(teruelArray);

        System.out.print("Teruel -> ");
        for (String p : teruelArray) {
            System.out.print(p + ", ");

        }

        /*
        d) Buscar pueblo. Buscará en los arrays de las provincias si existe el
        pueblo buscado. Si existe mostrará el resultado y a qué provincia
        pertenece. Si no lo encuentra ofrecerá al usuario introducirlo
        pidiéndole para ello la provincia a la que pertenece.
        */
        System.out.println();
        System.out.println("<--------------------- APARTADO D --------------------->");
        

    }
}
