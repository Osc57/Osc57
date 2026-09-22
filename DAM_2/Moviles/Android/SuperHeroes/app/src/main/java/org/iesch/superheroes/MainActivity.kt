package org.iesch.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.Model.SuperHeroe
import org.iesch.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //1 - Creamos la variable de tipo lateInit porque la vamos a inicializar luego
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //2 - Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //3 - Usamos el binding para inflar la vista
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //A partir de aquí introduzco el código necesario
        val botonGuardar = findViewById<Button>(R.id.btnGuardar);

        binding.btnGuardar.setOnClickListener {
            //Obtenemos los valores al momento de hacer click

            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.alterEgoEdit.text.toString()
            val bio = binding.bioEdit.text.toString()
            val power = binding.power.rating

            //2 - Me creo el objeto SuperHeroe
            val superHeroe = SuperHeroe(superHeroName, alterEgo, bio, power);

            //Que quiero hacer cuando pulso el botón guardar

            irADetailActivity(superHeroe)
        }


    }

    fun irADetailActivity(superHeroe: SuperHeroe) {
        //Creamos el objeto intent
        val intent = Intent(this, DetailActivity::class.java);

        //Añadimos todos los campos con el metodo putExtra

        intent.putExtra("superHeroe", superHeroe)

        /*
        intent.putExtra("superHeroName", superHeroName)
            .putExtra("alterEgo", alterEgo)
            .putExtra("bio", bio)
            .putExtra("power", rating)
         */

        //De esta manera todos estos datos se eviaran al DetailActivity

        //Iniciamos la nueva actividad
        startActivity(intent)
    }

}