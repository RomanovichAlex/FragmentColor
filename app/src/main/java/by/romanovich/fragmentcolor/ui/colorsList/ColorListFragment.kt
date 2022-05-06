package by.romanovich.fragmentcolor.ui.colorsList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.romanovich.fragmentcolor.domain.ColorsRepo
import by.romanovich.fragmentcolor.R
import by.romanovich.fragmentcolor.app
import by.romanovich.fragmentcolor.databinding.FragmentColorsListBinding
import by.romanovich.fragmentcolor.domain.ColorEntity
import by.romanovich.fragmentcolor.utils.BasePresenter
import java.lang.IllegalStateException
import java.util.*

/**
 * Не забудь отнаследовать активити от контроллера
 */
class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    //
    private lateinit var presenter: Presenter


    //при создании адаптера должны создать коллбэк,itemClickCallback
    private val colorsAdapter = ColorsAdapter{
//открываем фрагмент
        controller.openColorScreen(it)
        //сохраняем состояние
        presenter.currentColor = it
        binding.root.setBackgroundColor(it.color)
        //Toast.makeText(requireContext(),it.name,Toast.LENGTH_SHORT).show()
    }



    //получаем доступ к репозиторию с цветами из нашего фрагмента
    private val colorsRepo: ColorsRepo by lazy { app.colorsRepo }

    //метод где к нам присоединяют активити
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //если активити не контроллер
        if (activity !is Controller){
            throw IllegalStateException("Activiti должна наследоваться от ColorListFragment.Controller")
        }
    }

    private val controller by lazy { activity as Controller }

    //подписываемся
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentColorsListBinding.bind(view)

        //востанавливаем значения, когда не первый раз
        if (savedInstanceState!=null) {
            val presenterId = savedInstanceState.getString("presenter_id")!!
            presenter = app.presenterStore.getPresenter(presenterId) as Presenter
        //иначе создаем новый презентер(когда зайдем первы раз
        } else {
            //создаем презентер с уникальным индификатором и сохраняем его
            val id = UUID.randomUUID().toString()
            presenter = Presenter(id)
            app.presenterStore.savePresenter(presenter)
        }

        //если не равен нулю то
        presenter.currentColor?.let {
            binding.root.setBackgroundColor(it.color)
        }

        initRecycler()
    }

//save
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("presenter_id", presenter.id)
    }


    private fun initRecycler() {
        binding.colorsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = colorsAdapter
        }
        //сообщаем адаптеру данные
        colorsAdapter.data = colorsRepo.getColors()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface Controller{
        fun openColorScreen(color: ColorEntity)
    }

}

class Presenter(override val id: String) : BasePresenter {
    //для сохранения цвета при повороте
    var currentColor: ColorEntity? = null

}