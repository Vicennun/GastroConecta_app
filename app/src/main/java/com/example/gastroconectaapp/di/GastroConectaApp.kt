package com.example.gastroconectaapp.di

import android.app.Application
import com.example.gastroconectaapp.data.AppDatabase
import com.example.gastroconectaapp.data.repository.RecipeRepository
import com.example.gastroconectaapp.data.repository.UserRepository

/*
 * Esta clase es el punto de entrada de nuestra app.
 * La usaremos para crear instancias ÚNICAS (Singleton)
 * de nuestra base de datos y repositorios.
 */
class GastroConectaApp : Application() {

    // 'lazy' significa que la base de datos no se creará
    // hasta que alguien la pida por primera vez.
    private val database by lazy {
        AppDatabase.getDatabase(this)
    }

    // Creamos los repositorios usando los DAOs de la base de datos
    // También serán instancias únicas (singleton)
    val userRepository by lazy {
        UserRepository(database.userDao())
    }

    val recipeRepository by lazy {
        RecipeRepository(database.recipeDao())
    }
}