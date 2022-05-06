package by.romanovich.fragmentcolor.ui.colorViewer

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import by.romanovich.fragmentcolor.R
import by.romanovich.fragmentcolor.databinding.FragmentColorViewerBinding
import by.romanovich.fragmentcolor.domain.ColorEntity

class ColorViewerFragment : Fragment(R.layout.fragment_color_viewer) {
    //kirich1409
    private val binding by viewBinding(FragmentColorViewerBinding::class.java)

    companion object {
        private const val COLOR_ARGS_KEY = "COLOR_ARGS_KEY"
        //передаем значения в фрагмент и возращает фрагмент, создается
        fun newInstance(colorEntity: ColorEntity) = ColorViewerFragment().apply {
            //сохраняем при повороте
            arguments = Bundle()
            //сохраняется
            arguments?.putParcelable(COLOR_ARGS_KEY, colorEntity)
        }
    }

    //Метод получения цвета из аргументов
    //если ColorEntity не ColorEntity то IllegalStateException
    private fun getColorFromArguments(): ColorEntity {
        return arguments?.getParcelable(COLOR_ARGS_KEY)
            ?: throw IllegalStateException("Забыли в аргументы положить цвет !!!")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val color = getColorFromArguments()
        binding.root.setBackgroundColor(color.color)
        binding.nameTextView.text = color.name
        binding.redValueEditText.setText(Color.red(color.color).toString())
        binding.greenValueEditText.setText(Color.green(color.color).toString())
        binding.blueValueEditText.setText(Color.blue(color.color).toString())
        binding.saveColorButton.setOnClickListener {
            binding.nameTextView.text =
                "${binding.redValueEditText.text} : ${binding.greenValueEditText.text} : ${binding.blueValueEditText.text} "
        }
    }
}