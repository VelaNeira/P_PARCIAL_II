package com.example.ejercicio_parcialii.Repository

import com.example.ejercicio_parcialii.DAO.LibrosDao
import com.example.ejercicio_parcialii.Model.Libro


class LibroRepository(private val libroDao:LibrosDao) {
    suspend fun insertar(libro: Libro){
        libroDao.insert(libro)
    }
    suspend fun getAllLibros(): List<Libro>{
        return libroDao.getAllLibros()
    }
    suspend fun deleteById(Idlibro:Int):Int {
        return libroDao.deleteById(Idlibro)
    }
    suspend fun updateLibro(libro: Libro) {
        libroDao.updateLibro(libro)
    }
}