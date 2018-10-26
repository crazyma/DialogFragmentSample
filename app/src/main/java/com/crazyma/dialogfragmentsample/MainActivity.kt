package com.crazyma.dialogfragmentsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(v: View) {
        v.rootView
        val array = IntArray(2)
        v.getLocationOnScreen(array)
        Log.d("badu", "x : ${array[0]} , y : ${array[1]} , height : ${v.height}")

        val dialogFragment =
                SampleDialogFragment.newInstance(getRelativeLeft(v), getRelativeTop(v) + v.height)
        dialogFragment.show(supportFragmentManager, "SampleDialogFragment")
    }

    private fun getRelativeLeft(v: View): Int =
            when (v.parent == v.rootView) {
                true -> v.left
                false -> v.left + getRelativeLeft((v.parent as View))
            }

    private fun getRelativeTop(v: View): Int =
            when (v.parent == v.rootView) {
                true -> v.top
                false -> v.top + getRelativeTop((v.parent as View))
            }
}
