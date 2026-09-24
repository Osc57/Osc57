package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.Model.SuperHeroe
import org.iesch.superheroes.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //1 - una variable que va a manejar el resultado de haber hecho la foto
    private lateinit var heroImage: ImageView
    private var heroBitmap: Bitmap? = null
    private val getContent =
        registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
            //Esto nos va a devolver un objeto de tipo bitmap
                bitmap ->
            heroBitmap = bitmap
            heroImage.setImageBitmap(heroBitmap)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
            abrirCamara()
        }

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

    fun abrirCamara() {
        // 3 - Abrimos la camara llamando al getContent launch
        getContent.launch(null)

    }

    fun irADetailActivity(superHeroe: SuperHeroe) {
        //Creamos el objeto intent
        val intent = Intent(this, DetailActivity::class.java);

        //Añadimos todos los campos con el metodo putExtra

        intent.putExtra("superHero", superHeroe)
        intent.putExtra("foto_heroe", heroImage.drawable.toBitmap())
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