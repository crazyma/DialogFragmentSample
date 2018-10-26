package com.crazyma.dialogfragmentsample

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SampleDialogFragment: DialogFragment() {

    companion object {

        const val ARGS_POSITION_X = "ARGS_POSITION_X"
        const val ARGS_POSITION_Y = "ARGS_POSITION_Y"

        fun newInstance(positionX: Int, positionY: Int)  = SampleDialogFragment().apply {
            arguments = Bundle().apply {
                putInt(ARGS_POSITION_X, positionX)
                putInt(ARGS_POSITION_Y, positionY)
            }
        }
    }

    var positionX = 0
    var positionY = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         arguments?.run {
             positionX = getInt(ARGS_POSITION_X)
             positionY = getInt(ARGS_POSITION_Y)
         }

        dialog.window?.apply {
            setGravity(Gravity.TOP or Gravity.START)
            attributes = attributes!!.apply {
                x = positionX
                y = positionY
            }
            setLayout(800,400)
        }

        return inflater.inflate(R.layout.fragment_dialog_sample, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onStart() {
        super.onStart()
        dialog.window?.setWindowAnimations(R.style.dialog_slide_animation)
    }

}