package com.example.orientationchange

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FragmentActivity : AppCompatActivity() {
    private var count = 1

//  Create fragment manager
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

//      button reference for navigating to the main activity
        val btnReturn = findViewById<Button>(R.id.btnReturn)

//      button reference for adding fragments
        val addFragmentBtn = findViewById<Button>(R.id.addFragmentBtn)

//      button reference for removing fragments
        val removeFragmentBtn = findViewById<Button>(R.id.removeFragmentBtn)

        addFragmentBtn.setOnClickListener {

//          add fragments to activity
            if (count == 1) {
                addFragmentOne()
                count++
            } else if (count == 2 || count % 2 == 0) {
                addFragmentTwo()
                count ++
            }else if (count == 3 || count % 3 == 0) {
                addFragmentThree()
                count ++
            } else if (count % 2 == 1 ){
                addFragmentFour()
                count ++
            } else if (count % 2  == 2){
                addFragmentFive()
                count ++
            }
        }


//      Set an event listener for the fragment removing button
        removeFragmentBtn.setOnClickListener {
            if (count == 1) count = 1 else count --
            manager.popBackStack()
        }


//      Set an event listener for the button returning to main activity
        btnReturn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }


//  This function adds fragment one to the stack
    fun addFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne.newInstance(" $count","")
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }


//  This function adds fragment two to the stack
    fun addFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo.newInstance("$count","")
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

//  Add fragment three to the stack
    fun addFragmentThree(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentThree.newInstance("$count","")
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


//  Add fragment four to the stack
    fun addFragmentFour(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentFour.newInstance("$count","")
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


//  Add fragment five to the stack
    fun addFragmentFive(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentFive.newInstance("$count","")
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}