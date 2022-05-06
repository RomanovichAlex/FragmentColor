package by.romanovich.fragmentcolor.data

import android.graphics.Color
import by.romanovich.fragmentcolor.domain.ColorEntity
import by.romanovich.fragmentcolor.domain.ColorsRepo
import java.util.*

//реализация
class InMemoryColorRepoImpl : ColorsRepo {
    override fun getColors(): List<ColorEntity> {
        return listOf(
            ColorEntity(generateId(), "Blue", Color.BLUE),
            ColorEntity(generateId(), "Red", Color.RED),
            ColorEntity(generateId(), "Green", Color.GREEN),
            ColorEntity(generateId(), "Yellow", Color.YELLOW),
            ColorEntity(generateId(), "Black", Color.BLACK),
            ColorEntity(generateId(), "Cyan", Color.CYAN),
            ColorEntity(generateId(), "Magenta", Color.MAGENTA),
            ColorEntity(generateId(), "LGray", Color.LTGRAY),
            ColorEntity(generateId(), "Tr", Color.TRANSPARENT),
        )
    }

    //метод для создания айди уникального
    private fun generateId() = UUID.randomUUID().toString()

}