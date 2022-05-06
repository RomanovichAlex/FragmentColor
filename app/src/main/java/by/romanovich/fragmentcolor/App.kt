package by.romanovich.fragmentcolor

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import by.romanovich.fragmentcolor.data.InMemoryColorRepoImpl
import by.romanovich.fragmentcolor.domain.ColorsRepo
import by.romanovich.fragmentcolor.utils.PresenterStore


class App : Application(){
    //val colorsRepo: ColorsRepo = InMemoryColorRepoImpl()
    val colorsRepo: ColorsRepo by lazy { InMemoryColorRepoImpl() }
    val presenterStore by lazy { PresenterStore() }
}

//расширение
val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app