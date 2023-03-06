package com.example.qlchitieu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var i = intent
        var bundle = Bundle()
        var title = i.getStringExtra("khoanchitieu")
        var pos = i.getIntExtra("stt",0)
        bundle.putString("gtCt",title)
        bundle.putInt("pos",pos)
        val sub2 = ExpenseDetailFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayoutdetail,sub2)
            commit()
        }
        sub2.arguments = bundle


    }

}