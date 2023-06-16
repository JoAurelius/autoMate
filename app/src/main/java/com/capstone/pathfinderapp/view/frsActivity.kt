package com.capstone.pathfinderapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.pathfinderapp.R
import com.capstone.pathfinderapp.adapter.FrsAdapter
import com.capstone.pathfinderapp.databinding.ActivityFrsBinding
import com.capstone.pathfinderapp.model.Matkul

class frsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFrsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFrsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listMK = getListMovie()

        val layoutManager = LinearLayoutManager(this)
        binding.rvMatkul.layoutManager = layoutManager

        val adapter = FrsAdapter(listMK)
        binding.rvMatkul.adapter = adapter


    }
    private fun getListMovie(): ArrayList<Matkul> {
        val kodeMK = resources.getStringArray(R.array.kode)
        val jadwalMK = resources.getStringArray(R.array.jam)
        val profMK = resources.getStringArray(R.array.prof)
        val namaMK = resources.getStringArray(R.array.matkul)
        val listMK = ArrayList<Matkul>()
        for (i in kodeMK.indices) {
            val matkul = Matkul(
                i,
                namaMK[i],
                kodeMK[i],
                profMK[i],
                "rabu",
                jadwalMK[i],
            )
            listMK.add(matkul)
        }
        return listMK
    }
}