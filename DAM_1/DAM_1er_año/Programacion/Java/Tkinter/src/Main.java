import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String inputValue = JOptionPane.showInputDialog("Dime un valor");
        System.out.println(inputValue);

        if (inputValue.equals("Hola")){
            System.out.println("El chico es educado");
        }else {
            System.out.println("Error al saludar");
        }

        int opcion = JOptionPane.showConfirmDialog(null,
                "estas seguro", "Salir???", JOptionPane.ERROR_MESSAGE);
        if (opcion == 0){
            System.out.println("Salir");
        }



    }
}
