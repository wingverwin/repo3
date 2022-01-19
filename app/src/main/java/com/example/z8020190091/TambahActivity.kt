package com.example.z8020190091

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class TambahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        val txtjudul = findViewById<EditText>(R.id.text_nama)
        val txtpengarang = findViewById<EditText>(R.id.text_jabatann)
        val txthalaman = findViewById<EditText>(R.id.text_gaji)
        val btnsimpan = findViewById<Button>(R.id.btn_spn)

        btnsimpan.setOnClickListener {
            val dbsaya = MyDBHelper(this)

            dbsaya.tambah(
                txtjudul.text.toString().trim(),
                txtpengarang.text.toString().trim(),
                Integer.valueOf(txthalaman.text.toString().trim()
                )

            )


        }

    }
}