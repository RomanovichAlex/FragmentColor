package by.romanovich.fragmentcolor.utils

import java.util.*

//WeakHashMap - имплемитация карты которая хранит слабые ссылки на ключи, не будет висеть в памяти
//для сохранения данных влюбом случае
class PresenterStore {
    private val storage: MutableMap<String, BasePresenter> = WeakHashMap()


    fun savePresenter(presenter: BasePresenter) {
        storage[presenter.id] = presenter
    }

    fun getPresenter(id: String): BasePresenter? {
        return storage[id]
    }
}

interface BasePresenter {
    val id: String
}