package com.example.z8020190091

import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val nik : ArrayList<String> = arrayListOf()
    val nama : ArrayList<String> = arrayListOf()
    val jabatan : ArrayList<String> = arrayListOf()
    val gaji : ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<FloatingActionButton>(R.id.fab_add)
        btn.setOnClickListener {
            val intentkita = Intent(this, TambahActivity::class.java)
            startActivity(intentkita)
        }
        simpandata();


        val rv_dataa = findViewById<RecyclerView>(R.id.rv_data)
        val adapter = BukuAdapter(this, nik, nama, jabatan, gaji)
        rv_dataa.adapter = adapter
        rv_dataa.layoutManager = LinearLayoutManager(this)
    }
    fun simpandata() {

        val dbSaya = MyDBHelper(this)
        val dataSaya: Cursor = dbSaya.bacasemuadata()

        if (dataSaya.count == 0) {
            Toast.makeText(this, " Data tidak ada ", Toast.LENGTH_SHORT).show()
        } else {
            while (dataSaya.moveToNext()) {
                nik.add(dataSaya.getString(0))
                nama.add(dataSaya.getString(1))
                jabatan.add(dataSaya.getString(2))
                gaji.add(dataSaya.getString(3))
            }
        }

    }
}

