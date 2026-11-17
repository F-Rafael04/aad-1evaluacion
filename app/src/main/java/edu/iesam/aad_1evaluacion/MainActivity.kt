package edu.iesam.aad_1evaluacion

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.aad_1evaluacion.core.serialization.KotlinJsonSerializer
import edu.iesam.aad_1evaluacion.feature.data.local.TeslaLocalDataSource
import edu.iesam.aad_1evaluacion.feature.domain.Car
import edu.iesam.aad_1evaluacion.feature.domain.Owner
import edu.iesam.marvelappt.R
import kotlin.math.log

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

        val teslaLocalDataSource = TeslaLocalDataSource(
            this,
            KotlinJsonSerializer.create()
        )

        val owner1 = Owner("12345678D", "Manolo", "Perez")
        val owner2 = Owner("87654321A", "Teresa", "Angustias")

        val car1 = Car("1","Ford", "Mondeo", "1234 ACD", owner1)
        val car2 = Car("2","Seat", "Leon", "AC 1234 DC", owner1)
        val car3 = Car("3","volkswagen", "Golf", "9865 GTA", owner2)
        val carU = Car("1","Opel", "Astra", "1234 ACD", owner1)


        val lista = listOf(
            car1, car2, car3
        )

        teslaLocalDataSource.save(lista)

        teslaLocalDataSource.findAll()

        teslaLocalDataSource.findById("2")

        teslaLocalDataSource.update(carU)

        teslaLocalDataSource.delete("2")

        teslaLocalDataSource.deleteAll()





        }
    }