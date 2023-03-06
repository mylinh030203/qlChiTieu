package com.example.qlchitieu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.qlchitieu.data.DataResource.listChiTieu
import com.example.qlchitieu.model.ChiTieu
import kotlinx.android.synthetic.main.fragment_expense_detail.*
import kotlinx.android.synthetic.main.fragment_expense_detail.view.*


class ExpenseDetailFragment : Fragment(R.layout.fragment_expense_detail) {


    fun list(pos:Int):ChiTieu{
      return listChiTieu[pos]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view: View = inflater.inflate(R.layout.fragment_expense_detail,container,false)
        var title :TextView = view.findViewById(R.id.title)
        var mota :TextView = view.findViewById(R.id.des)
        var date :TextView = view.findViewById(R.id.date)
        var price :TextView = view.findViewById(R.id.price)
        var btnupdate: Button = view.findViewById(R.id.btnupdate)
        var txtdes : EditText = view.findViewById(R.id.txtdes)
        var txtdate :EditText = view.findViewById(R.id.txtdate)
        var txtprice :EditText = view.findViewById(R.id.txtprice)
        var btndelete :Button = view.findViewById(R.id.delete)
        title.text = arguments?.getString("gtCt","khoan 1 ")
        var i = arguments?.getInt("pos",0) as Int
        when(title.text){
            list(i).khoanChiTieu-> {
            mota.text = list(i).des.toString()
            date.text = list(i).date.toString()
            price.text = list(i).price.toString()
                btnupdate.setOnClickListener {
                    if((txtdes.text).toString() !=""){
                        mota.text = (txtdes.text).toString()
//                        list(i).des = (txtdes.text).toString()
                        txtdes.setText("")
                    }
                    if((txtdate.text).toString()!=""){
                        date.text = (txtdate.text).toString()
//                        list(i).date = (txtdate.text).toString()
                        txtdate.setText("")
                    }
                    if((txtprice.text).toString()!=""){
                        for(j in 0..(txtprice.text).toString().length){
                            if((txtprice.text).toString()[j] >= 'a'&& (txtprice.text).toString()[j]<='z') {
                                Toast.makeText(context, "hãy nhập vào một số", Toast.LENGTH_SHORT)
                                    .show()
                                break
                            }else{
                                price.text = (txtprice.text).toString()
//                                list(i).price = (txtprice.text).toString().toDouble()
                                break
                            }
                        }

                        txtprice.setText("")

                    }
                }
                btndelete.setOnClickListener {
                    var intent : Intent = Intent(activity,MainActivity::class.java)
                    listChiTieu.removeAt(i)

                    startActivity(intent)
                }
        }

        }
        return view
    }

}