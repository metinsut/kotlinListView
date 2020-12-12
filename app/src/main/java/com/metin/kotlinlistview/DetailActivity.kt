package com.metin.kotlinlistview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val landmarkName = intent.getStringExtra("name")
        //val landmarkPosition = intent.getIntExtra("position", 0)
        val textViewItem = findViewById<TextView>(R.id.textView)
        textViewItem.text = landmarkName

        val singleton = Singleton.Selected
        val selectedBitmap = singleton.selectedImage
        val imageViewItem = findViewById<ImageView>(R.id.imageView)
        imageViewItem.setImageBitmap(selectedBitmap)

/*        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colesium = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colesium)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonbridge  = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colesium)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonbridge)

        println(landmarkPosition)

        imageViewItem.setImageBitmap((landmarkImages[landmarkPosition]))*/
    }
}
