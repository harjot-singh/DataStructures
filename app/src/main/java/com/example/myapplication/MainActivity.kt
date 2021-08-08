package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val bitmap3 = drawableToBitmap(resources.getDrawable(R.drawable.ic_launcher_background))
//        val bitmap4 = drawableToBitmap(resources.getDrawable(R.drawable.ic_icons8_tick_box))
//        findViewById<ImageView>(R.id.sample_image).setImageBitmap(overlay(bitmap3,bitmap4))
    }

    private fun overlay(bmp1: Bitmap, bmp2: Bitmap): Bitmap {
        val bmOverlay = Bitmap.createBitmap(bmp1.width*(1.2).toInt(),
            bmp1.height*(1.2).toInt(), bmp1.config)
        val canvas = Canvas(bmOverlay)
        canvas.drawBitmap(bmp1, Matrix(), null)

        val matrix2 = Matrix()
        //matrix2.postTranslate(bmp2.width.toFloat(), bmp2.height.to)
        canvas.drawBitmap(bmp2, matrix2, null)

        return bmOverlay
    }

    fun drawableToBitmap(drawable: Drawable): Bitmap {

        if (drawable is BitmapDrawable) {
            return drawable.bitmap
        }

        val bitmap =
            Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        return bitmap
    }
}
