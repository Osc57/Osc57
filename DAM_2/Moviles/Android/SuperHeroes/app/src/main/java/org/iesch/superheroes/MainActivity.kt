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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //A partir de aquí introduzco el código necesario
        val botonGuardar = findViewById<Button>(R.id.btnGuardar);

        botonGuardar.setOnClickListener {
            //Obtenemos los valores al momento de hacer click

            val superHeroName = findViewById<EditText>(R.id.hero_name_edit).text.toString()
            val alterEgo = findViewById<EditText>(R.id.alter_ego_edit).text.toString()
            val bio = findViewById<EditText>(R.id.bioEdit).text.toString()
            val power = findViewById<RatingBar>(R.id.power).rating


            //Que quiero hacer cuando pulso el botón guardar

            irADetailActivity(superHeroName, alterEgo, bio, power)
        }

    }

    fun irADetailActivity(superHeroName: String, alterEgo: String, bio: String, rating: Float) {
        //Creamos el objeto intent
        val intent = Intent(this, DetailActivity::class.java);

        //Añadimos todos los campos con el metodo putExtra
        intent.putExtra("superHeroName", superHeroName)
            .putExtra("alterEgo", alterEgo)
            .putExtra("bio", bio)
            .putExtra("power", rating)

        //De esta manera todos estos datos se eviaran al DetailActivity

        //Iniciamos la nueva actividad
        startActivity(intent)
    }

}