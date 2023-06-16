package com.capstone.pathfinderapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstone.pathfinderapp.R
import com.capstone.pathfinderapp.model.Matkul

class FrsAdapter(private val listMatkul: List<Matkul>) : RecyclerView.Adapter<FrsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrsAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_matkul, parent, false))

    override fun onBindViewHolder(holder: FrsAdapter.ViewHolder, position: Int) {
        val matkul = listMatkul[position]
        holder.tvKode.text = matkul.code
        holder.tvNama.text = matkul.name
        holder.tvProf.text = matkul.prof
        holder.tvJadwal.text = matkul.jam
    }

    override fun getItemCount(): Int = listMatkul.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvKode: TextView = view.findViewById(R.id.tv_kodeMatkul)
        val tvNama: TextView = view.findViewById(R.id.tv_namaMatkul)
        val tvProf: TextView = view.findViewById(R.id.tv_dosenMatkul)
        val tvJadwal: TextView = view.findViewById(R.id.tv_jadwalMatkul)
    }
}