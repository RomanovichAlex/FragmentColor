package by.romanovich.fragmentcolor

import android.graphics.Color
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
            ColorEntity(generateId(), "DGray", Color.DKGRAY),
            ColorEntity(generateId(), "Gray", Color.GRAY),
            ColorEntity(generateId(), "Tr", Color.TRANSPARENT),
        )
    }

    //метод для создания айди уникального
    private fun generateId() = UUID.randomUUID().toString()

}