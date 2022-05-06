package by.romanovich.fragmentcolor

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment

class App : Application(){
    //val colorsRepo: ColorsRepo = InMemoryColorRepoImpl()
    val colorsRepo: ColorsRepo by lazy {InMemoryColorRepoImpl()}
}

//расширение
val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app