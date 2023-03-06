package com.example.qlchitieu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qlchitieu.model.ChiTieu
import kotlinx.android.synthetic.main.layout_item.view.*

class rvAdapter(val list: List<ChiTieu>, val rvInterface: rvInterface):RecyclerView.Adapter<rvAdapter.chiTieuHolder>() {
    inner class chiTieuHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chiTieuHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent,false)
        return chiTieuHolder(view)
    }

    override fun onBindViewHolder(holder: chiTieuHolder, position: Int) {
        holder.itemView.apply {
            tvChitieu.text = list[position].khoanChiTieu

            holder.itemView.setOnClickListener {
                rvInterface.onclick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}