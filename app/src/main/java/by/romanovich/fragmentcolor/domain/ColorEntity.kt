package by.romanovich.fragmentcolor.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColorEntity(
    val id: String,
    val name: String,
    val color: Int
) : Parcelable