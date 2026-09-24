package org.iesch.superheroes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.os.Environment
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

    // 1 - Hay que cambiar el metodo TakePicturesPreview por TakePictures
    private var picturePath = ""
    private val getContent =
        registerForActivityResult(ActivityResultContracts.TakePicture()) {
            //Ahora en lugar de un bitMap nos va a devolver un booleano, si la foto es exitosa o no

                success ->
            if (success && picturePath.isNotEmpty()) {
                //Cualquier imagen del directorio la podemos convertir a bit map
                heroBitmap = BitmapFactory.decodeFile(picturePath)
                //Mostramos la imagen en el cuadradito
                heroImage.setImageBitmap(heroBitmap)
            }

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
        // 2 - Aquí debemos crear un path temporal para guardar la imagen que acabamos de captar
        val imageFile = crearImagenFile()

        // Ahora ya tenemos el archivo de tipo file pero lo que necesitamos es el URI
        //Sera a través del FileProvider
        //FileProvider lo que hace es compartir el file con otras aplicaciones de manera segura


    }

    // 3 - Esta función crea un File y de ese File recuperaremos la URI
    private fun crearImagenFile(): File {
        var fileName = "superhero_image"

        // Esto sera el directorio donde vamos a almacenar la imagen. Por defecto es DIRECTORY_PICTURES
        val fileDirectory = getExternalFilesDirs(Environment.DIRECTORY_PICTURES)

        // Creamos nuestro File, aqui nos pide el nombre, el formato y el directorio
        val imageFile = File.createTempFile(fileName, ".jpg", fileDirectory as File?)

        //Ahora ya podemos guardar la ruta (path) en la variable global

        picturePath = imageFile.absolutePath

        return imageFile

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