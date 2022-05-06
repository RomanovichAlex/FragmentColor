package by.romanovich.fragmentcolor

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.romanovich.fragmentcolor.databinding.FragmentColorsListBinding

class ColorListFragment : Fragment(R.layout.fragment_colors_list) {
    private var _binding: FragmentColorsListBinding? = null
    private val binding: FragmentColorsListBinding
        get() = _binding!!

    private val colorsAdapter = ColorsAdapter()
    //получаем доступ к репозиторию с цветами из нашего фрагмента
    private val colorsRepo: ColorsRepo by lazy { app.colorsRepo }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

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

}