package com.metin.kotlinlistview

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Coliseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colesium = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colesium)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonbridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colesium)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonbridge)

        //val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)
        val adapter = ArrayAdapter(this,R.layout.list_row,R.id.textView3,landmarkNames)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext, DetailActivity::class.java);
            intent.putExtra("name",landmarkNames[position])
            intent.putExtra("position", position)
            intent.putExtra("id", id)
            val singleton = Singleton.Selected
            singleton.selectedImage = landmarkImages[position]
            startActivity(intent);
            finish()
        }

    }
}