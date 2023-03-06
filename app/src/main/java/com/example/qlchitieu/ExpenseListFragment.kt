package com.example.qlchitieu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qlchitieu.data.DataResource.listChiTieu
import com.example.qlchitieu.model.ChiTieu

class ExpenseListFragment : Fragment(R.layout.fragment_expense_list) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_expense_list, container, false)
        var recyclerView: RecyclerView = view.findViewById(R.id.rvChitieu)
        var list = mutableListOf<ChiTieu>()
        listChiTieu.forEach {
            list.add(it)
        }
        var adapter = rvAdapter(list, object : rvInterface {
            override fun onclick(pos: Int) {
                var intent: Intent = Intent(activity, DetailActivity::class.java)

                intent.putExtra("khoanchitieu", list[pos].khoanChiTieu)
                intent.putExtra("stt", pos)
                startActivity(intent)

            }
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return view

    }
}