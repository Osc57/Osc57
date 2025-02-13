import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.User;

public class UserTest{
    
    @Test
    public void usuarioConDatosValidos(){
        User user = new User("Diego","diego@gmail.com",23);

        String name = user.getNombre();
        String email = user.getCorreo();
        int edad = user.getEdad();

        assertEquals("Diego", name, "Nombre correcto");
        assertEquals("diego@gmail.com", email, "Email correcto");
        assertEquals(23, edad, "Edad correcta");
    }

    @Test
    public void usuarioConNombreInvalido(){
        assertThrows(IllegalArgumentException.class, () -> {new User(null, "nombre@gmail.com", 45);});
        assertThrows(IllegalArgumentException.class, () -> {new User(" ", "nombre@gmail.com", 45);});

    }

    @Test
    public void usuarioConEmailInvalido(){
       User user2 = new User("Lucas", "lucas@@gmail.com", 34);

    }
    
}