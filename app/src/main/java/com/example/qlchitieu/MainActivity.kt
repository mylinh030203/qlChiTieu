package com.example.qlchitieu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_item.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sub1 = ExpenseListFragment()
//        var i:Intent = Intent(this,DetailActivity::class.java)
        var i = intent

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayoutlist,sub1)
            commit()
        }

    }
}