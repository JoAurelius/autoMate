package com.capstone.pathfinderapp.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.capstone.pathfinderapp.R
import com.capstone.pathfinderapp.model.Matkul

class MatkulSmall @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        initView(context)
    }

    private fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.item_matkul_small, this, true)
    }
    fun setData(data: Matkul) {
        val kodeMK: TextView = findViewById(R.id.KodeMatkul)
        val namaMK: TextView = findViewById(R.id.namaMatkul)
        val jadwalMK: TextView = findViewById(R.id.jadwalMatkul)

        kodeMK.text = data.code
        namaMK.text = data.name
        jadwalMK.text = data.jam
    }
    fun setColor(color: String) {
        val card: CardView = findViewById(R.id.small_matkul)
        card.setBackgroundColor(color.toInt())
    }
}
