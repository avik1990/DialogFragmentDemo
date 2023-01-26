package com.app.dialogfragmentdemo

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    lateinit var  btnDialog : Button
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnDialog = findViewById(R.id.btnDialog)

        btnDialog.setOnClickListener {
            //  val dialog = DiologFragment.newInstance()
            //  dialog.show(supportFragmentManager?.beginTransaction()!!, DiologFragment::class.java.name)
            val popupwindow_obj = popupDisplay()
            popupwindow_obj!!.showAsDropDown(btnDialog, -40, 18)
        }






    }

    fun popupDisplay(): PopupWindow? {
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        val popupWindow = PopupWindow(this)
        // inflate your layout or dynamically add view
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.fragment_diolog, null)

        var btnClose = view.findViewById(R.id.btn_cross) as ImageView
        btnClose.setOnClickListener {
            popupWindow.dismiss()
        }
        val adapter = RecyclerViewAdapter(this, DataList() as ArrayList<Data>)
        var recyclerView = view.findViewById(R.id.recyclerlView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        popupWindow.isOutsideTouchable = true
        popupWindow.isFocusable = true

        popupWindow.contentView = view
        popupWindow.width = (width * 0.60).toInt()
        popupWindow.height = (height * 0.90).toInt()
        popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        return popupWindow
    }

    fun DataList() :List<Data> {
        val dataList = ArrayList<Data>()
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "1. Hi! I am in View 1"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "2. Hi! I am in View 2"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "3. Hi! I am in View 3"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "4. Hi! I am in View 4"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "5. Hi! I am in View 5"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "6. Hi! I am in View 6"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "7. Hi! I am in View 7"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "8. Hi! I am in View 8"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "9. Hi! I am in View 9"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "10. Hi! I am in View 10"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "11. Hi! I am in View 11"))
        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "12. Hi! I am in View 12"))

        return dataList
    }
}