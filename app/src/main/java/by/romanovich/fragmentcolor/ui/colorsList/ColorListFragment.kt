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
import java.lang.IllegalStateException

/**
 * Не забудь отнаследовать активити от контроллера
 */
class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    //при создании адаптера должны создать коллбэк,itemClickCallback
    private val colorsAdapter = ColorsAdapter{
//открываем фрагмент
        controller.openColorScreen(it)
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
        initRecycler()
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