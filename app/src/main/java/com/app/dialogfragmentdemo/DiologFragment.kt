package com.app.dialogfragmentdemo

import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment


class DiologFragment : DialogFragment() {

    companion object {
        fun newInstance(): DiologFragment {
            val dialog = DiologFragment()
            return dialog
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.setDimAmount(0F)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isCancelable = true
        return inflater.inflate(R.layout.fragment_diolog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    fun setListener() {
        /*button.setOnClickListener({
            dismiss()
        })*/
    }

    override fun onResume() {
        super.onResume()
        val window = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x

        val attributes: WindowManager.LayoutParams = window!!.attributes
        attributes.x = 10
        attributes.y = 10
        window?.attributes = attributes

        window?.setLayout((width * 0.60).toInt(), WindowManager.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.RIGHT)
    }
}


