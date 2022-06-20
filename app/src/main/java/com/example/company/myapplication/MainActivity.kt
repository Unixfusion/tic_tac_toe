package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var spinners: Array<Array<Spinner>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toChooseList = listOf<String>("", "X", "0")
        spinners = arrayOf(
        arrayOf(findViewById(R.id.spinner11), findViewById(R.id.spinner12), findViewById(R.id.spinner13)),
        arrayOf(findViewById(R.id.spinner21), findViewById(R.id.spinner22), findViewById(R.id.spinner23)),
        arrayOf(findViewById(R.id.spinner31), findViewById(R.id.spinner32), findViewById(R.id.spinner33))
        )
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, toChooseList)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    for (item in spinners) {
        for (spin in item) {
            spin.adapter = adapter
            spin.onItemSelectedListener = this
        }
    }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Log.d("TAG", "onItemSelected: ${parent!!.getItemAtPosition(position)}")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}
