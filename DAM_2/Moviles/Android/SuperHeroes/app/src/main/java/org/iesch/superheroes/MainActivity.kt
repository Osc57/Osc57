package org.iesch.superheroes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
            //Que quiero hacer cuando pulso el botón guardar

            irADetailActivity()
        }

    }

    fun irADetailActivity() {
        //Creamos el objeto intent
        val intent = Intent(this, DetailActivity::class.java);

        startActivity(intent)
    }

}