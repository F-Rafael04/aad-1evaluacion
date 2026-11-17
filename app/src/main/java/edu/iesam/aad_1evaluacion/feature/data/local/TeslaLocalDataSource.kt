package edu.iesam.aad_1evaluacion.feature.data.local

import android.content.Context
import edu.iesam.aad_1evaluacion.core.serialization.JsonSerializer
import edu.iesam.aad_1evaluacion.feature.domain.Car
import edu.iesam.marvelappt.R

class TeslaLocalDataSource(
    val context: Context,
    val serializer: JsonSerializer<List<Car>>
) {

    val key : String = "Car"

    val sharedPreferences = context.getSharedPreferences(context.getString(R.string.car_local_source),
        Context.MODE_PRIVATE)

    fun save(car: List<Car>){
        sharedPreferences.edit()
            .putString(serializer.toJson(car), null)
            .apply()
    }

    fun findAll(): List<Car>{
        val json = sharedPreferences.getString(key, null)

        if (json != null){
            return serializer.fromJson(json)
        }

        return emptyList()
    }

    fun findById(id : String) : Car?{
        return findAll().find { it.id == id }
    }

    fun delete(id: String){
        val lista = findAll().filterNot { it.id == id }
        save(lista)
    }

    fun deleteAll(){
        save(emptyList())
    }

    fun update(car: Car){
        var lista = findAll().filterNot { it.id == car.id }.toMutableList()

        lista.add(car)

        save(lista)
    }
}