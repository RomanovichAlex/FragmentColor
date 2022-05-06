package by.romanovich.fragmentcolor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.romanovich.fragmentcolor.databinding.ItemColorBinding

class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //получили binding
    private val binding = ItemColorBinding.bind(itemView)

    companion object {
        @JvmStatic
        //создаем статический метод для ColorsAdapter
        //метод который все создает
        fun createView(parent: ViewGroup): ColorViewHolder {
            //создаем вью и вызываем готовый конструктор
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_color, parent, false)
            //возращаем
            return ColorViewHolder(view)
        }
    }

    //метод из ColorAdapter, в котором обновляет сам себя
    fun bind(item: ColorEntity) {
        binding.colorNameTextView.text = item.name
        //меняем цвет
        binding.root.setBackgroundColor(item.color)
    }
}