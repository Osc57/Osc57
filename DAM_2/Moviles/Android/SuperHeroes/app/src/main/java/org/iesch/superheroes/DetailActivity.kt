package org.iesch.superheroes

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.Model.SuperHeroe
import org.iesch.superheroes.databinding.ActivityDetailBinding
import java.io.File

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1 - Recibimos el objeto SuperHeroe del Intent
        val superHeroe =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                //Para versiones SDK 33 o superiores
                intent.getParcelableExtra("superHero", SuperHeroe::class.java)
            } else {
                //Para versiones anteriores a la 33
                intent.getParcelableExtra<SuperHeroe>("superHero")
            }

        val bundle = intent.extras
        val bitmap = bundle?.getParcelable<Bitmap>("foto_heroe")

        //Ultimo paso: recibir los datos del main activity
        /*
         val bundle = intent.extras!!
         val superHeroName = bundle.getString("superHeroName") ?: "No hay nombre"
         val alterEgo = bundle.getString("alterEgo") ?: "No hay alter ego"
         val bio = bundle.getString("bio") ?: "No hay bio"
         val power = bundle.getFloat("power")
         */

        //Rellenamos los campos con los valores recibidos

        binding.heroNameTv.text = superHeroe?.nombre ?: "No hay nombre"
        binding.alterEgoResult.text = superHeroe?.alterEgo ?: "No hay alter ego"
        binding.bioResult.text = superHeroe?.bio ?: "No hay bio"
        binding.ratingResult.rating = superHeroe?.power ?: 0f

        //Asigno la imagen a la imageView
        binding.imageResult.setImageBitmap(bitmap)

    }
}