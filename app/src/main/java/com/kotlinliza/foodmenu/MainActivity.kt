package com.kotlinliza.foodmenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var adapter :FoodAdapter
    var listOfFoods=ArrayList<Foods>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load foods
        listOfFoods.add(Foods("Coffee","   Coffee made from fine grind coffee beans",R.drawable.coffee_pot))
        listOfFoods.add(Foods("Espersso","    Espresso’s heavenly made drink" ,R.drawable.espresso))
        listOfFoods.add(Foods("French Fires","  made from locally grown fresh potatoes ",R.drawable.french_fries))
        listOfFoods.add(Foods("Honey"," taste world class sweetness:",R.drawable.honey))
        listOfFoods.add(Foods("Strawberry","   enjoy our strawberry icecream.",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Foods("Sugar cubes","Sugar cubes ",R.drawable.sugar_cubes))
        adapter= FoodAdapter(this,listOfFoods)
        //Assign our list to the gridview id

        findViewById<GridView>(R.id.gvListFood).adapter =adapter



    }

    class  FoodAdapter: BaseAdapter {
        var listOfFood= ArrayList<Foods>()
        var context:Context?=null
        constructor(context: Context, listOfFood:ArrayList<Foods>):super(){
            this.context=context
            this.listOfFood=listOfFood
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView= inflator.inflate(R.layout.food_ticket,null)
            foodView.findViewById<ImageView>(R.id.food_image).setImageResource(food.image!!)
            foodView.findViewById<ImageView>(R.id.food_image).setOnClickListener {

                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.foodName!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.findViewById<TextView>(R.id.Tvname).text =  food.foodName!!
            return  foodView

        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return listOfFood.size
        }
}}