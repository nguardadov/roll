package com.example.hoolamundo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateint nos sirve para iniciar una variable y no usar null, esta tomara el valor despues  que se infle
    //esto se usa para que no se este realizando la busqueda cada vez que se preione el boton Roll

    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //aca buscamos los botones
        val rollButton: Button = findViewById(R.id.roll_button)
        val clearButton: Button = findViewById(R.id.roll_clear)

        //aca por medio de su id buscamos los elementos de las imagenes
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
       // resultText.text = "Dice Rolled!"

        //le agregamos accion al boton
        rollButton.setOnClickListener{rollDice()}
        clearButton.setOnClickListener{roll_clear()}
    }

    private fun rollDice(){

       // val resultText: TextView = findViewById(R.id.result_text)
        //val diceImage : ImageView =  findViewById(R.id.dice_image)

        //val drawableResource = getRandomDiceImage()

        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())



       // resultText.text =randomInt.toString()
       // Toast.makeText(this,"button clicked", Toast.LENGTH_SHORT).show()
    }


    private fun getRandomDiceImage() : Int
    {

        //generando random entre 1 a 6
        val randomInt = (1..6).random()


        //dependiendo el rando se selecciona la imagen a mostrar
        return  when (randomInt)
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else -> R.drawable.dice_6
        }


    }

    //count up

   private fun roll_clear()
    {
        diceImage.setImageResource(R.drawable.empty_dice)
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
