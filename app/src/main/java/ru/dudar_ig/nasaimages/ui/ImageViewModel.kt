package ru.dudar_ig.nasaimages.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.nasaimages.data.NasaApiImpl
import ru.dudar_ig.nasaimages.data.NasaImage
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class ImageViewModel: ViewModel() {
    val imageVM: LiveData<NasaImage>
    val image1: LiveData<NasaImage>
    val image2: LiveData<NasaImage>
    init {
        imageVM = NasaApiImpl().nasaImage(data(0))
        image1 = NasaApiImpl().nasaImage(data(1))
        image2 = NasaApiImpl().nasaImage(data(2))
    }

    private fun data(day: Int): String {
        val newFomat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val period1 = Period.of(0, 0, 1)
        val period2 = Period.of(0, 0, 2)
        val today = LocalDateTime.now()
        val yesterday = today.minus(period1)
        val yesterday2 = today.minus(period2)
        val data = when(day) {
            0 -> today.format(newFomat)
            1 -> yesterday.format(newFomat)
            2 -> yesterday2.format(newFomat)
            else -> {""}
        }
        return data
    }
}