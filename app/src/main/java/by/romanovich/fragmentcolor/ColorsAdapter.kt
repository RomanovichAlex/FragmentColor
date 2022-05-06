package by.romanovich.fragmentcolor

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//адаптер завязываем на ColorViewHolder
class ColorsAdapter : RecyclerView.Adapter<ColorViewHolder>() {
    var data: List<ColorEntity> = emptyList()
        //сетер публичный для всех, если мы передаем сюда данные в дата то он возьмет и переприсвоит список,
        //или вызовет обновление
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    //создается ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ColorViewHolder.createView(parent)

    //привязывается ViewHolder
    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    //возращает позицию в листе итем
    private fun getItem(pos: Int) = data[pos]

    override fun getItemCount() = data.size

}
