package org.iesch.superheroes

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Ultimo paso: recibir los datos del main activity
        val bundle = intent.extras!!

        val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre"
        val alterEgo = bundle.getString("alterEgo") ?: "No hay alter ego"
        val bio = bundle.getString("bio") ?: "No hay bio"
        val power = bundle.getFloat("power", 0.0f)

        //Rellenamos los campos con los valores recibidos

        findViewById<TextView>(R.id.heroName_tv).text = superHeroName
        findViewById<TextView>(R.id.alter_ego_result).text = alterEgo
        findViewById<TextView>(R.id.bioResult).text = bio
        findViewById<RatingBar>(R.id.ratingResult).rating = power

    }
}