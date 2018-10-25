package com.crazyma.dialogfragmentsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClicked(v: View){
        val dialogFragment = SampleDialogFragment()
        dialogFragment.show(supportFragmentManager, "SampleDialogFragment")
    }
}
