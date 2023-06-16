package com.capstone.pathfinderapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import com.capstone.pathfinderapp.R
import com.capstone.pathfinderapp.custom_view.MatkulSmall
import com.capstone.pathfinderapp.databinding.ActivityFrsBinding
import com.capstone.pathfinderapp.model.Matkul

class CalendarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFrsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val listMK = getListMovie()

        binding = ActivityFrsBinding.inflate(layoutInflater)

        val monContainer: LinearLayoutCompat= findViewById(R.id.mon_calendars)
        val tueContainer: LinearLayoutCompat= findViewById(R.id.tue_calendars)
        val wedContainer: LinearLayoutCompat= findViewById(R.id.wed_calendars)
        val thuContainer: LinearLayoutCompat= findViewById(R.id.thu_calendars)
        val friContainer: LinearLayoutCompat= findViewById(R.id.fri_calendars)
        val satContainer: LinearLayoutCompat= findViewById(R.id.sat_calendars)


        //add each mk to calendar to each linear layout per day
        for (i in listMK.indices) {
            val mkSmall = MatkulSmall(this)
            mkSmall.id = View.generateViewId()
            mkSmall.setData(listMK[i])
            when (listMK[i].day) {
                "Senin" -> monContainer.addView(mkSmall)
                "Selasa" -> tueContainer.addView(mkSmall)
                "Rabu" -> wedContainer.addView(mkSmall)
                "Kamis" -> thuContainer.addView(mkSmall)
                "Jumat" -> friContainer.addView(mkSmall)
                "Sabtu" -> satContainer.addView(mkSmall)
            }
        }
    }

    private fun getListMovie(): ArrayList<Matkul> {
        val kodeMK = resources.getStringArray(R.array.kode)
        val jadwalMK = resources.getStringArray(R.array.jam)
        val profMK = resources.getStringArray(R.array.prof)
        val namaMK = resources.getStringArray(R.array.matkul)
        val hariMK = resources.getStringArray(R.array.hari)
        val listMK = ArrayList<Matkul>()
        for (i in kodeMK.indices) {
            val matkul = Matkul(
                i,
                namaMK[i],
                kodeMK[i],
                profMK[i],
                hariMK[i],
                jadwalMK[i]
            )
            listMK.add(matkul)
        }
        return listMK
    }
}