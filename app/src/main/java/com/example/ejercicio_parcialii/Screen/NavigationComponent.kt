package com.example.ejercicio_parcialii.Screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio_parcialii.Database.AutorDatabase
import com.example.ejercicio_parcialii.Database.MiembroDatabase // Importa la base de datos de miembros
import com.example.ejercicio_parcialii.Repository.AutorRepository
import com.example.ejercicio_parcialii.Repository.MiembroRepository // Importa el repositorio de miembros

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    val context = LocalContext.current

    // Crear instancia del AutorRepository
    val autorRepository = AutorRepository(AutorDatabase.getDatabase(context).autorDao())

    // Crear instancia del MiembroRepository
    val miembroRepository = MiembroRepository(MiembroDatabase.getDatabase(context).miembroDao())

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(navController)
        }
        composable("autores") {
            ScreenAutor(navController, autorRepository)
        }
        composable("libros") {
            ScreenLibro(navController)
        }
        composable("prestamos") {
            ScreenListaPrestamo(navController)
        }
        composable("miembros") {
            ScreenMiembro(navController, miembroRepository) // Pasar el miembroRepository
        }
        composable("nuevo_prestamo") {
            ScreenPrestamo(navController)
        }
    }
}