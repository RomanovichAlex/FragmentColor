package by.romanovich.fragmentcolor.domain

import by.romanovich.fragmentcolor.domain.ColorEntity

//данные
interface ColorsRepo {
    // C_R_UD
    fun getColors(): List<ColorEntity>

}
