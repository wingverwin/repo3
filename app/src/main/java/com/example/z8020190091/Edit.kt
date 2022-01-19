package com.example.z8020190091

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.z8020190091.R.id.txt_namee

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val actionBar = supportActionBar
        if (intent.hasExtra("nama")) {
            actionBar?.title = intent.getStringExtra("nama")
        }

        getintentdata()

        val btnubah = findViewById<Button>(R.id.updatee)

        btnubah.setOnClickListener {
            val dbkita = MyDBHelper(this)

            val nik = intent.getStringExtra("nik")
            val nama = findViewById<EditText>(txt_namee).text.toString()
            val jabatan = findViewById<EditText>(R.id.text_jabatann).text.toString()
            val gaji = findViewById<EditText>(R.id.txt_gajii).text.toString()
            dbkita.ubah(nik, nama, jabatan, gaji)


        }




    }
        fun getintentdata() {
            if (
                intent.hasExtra("nik") && intent.hasExtra("nama") && intent.hasExtra("jabatan")
                && intent.hasExtra("gaji")
            ) {
                val nik = intent.getStringExtra("nik")
                val nama = intent.getStringExtra("nama")
                val jabatan = intent.getStringExtra("jabatan")
                val gaji = intent.getStringExtra("gaji")

                val e_nama = findViewById<EditText>(txt_namee)
                val e_jabatan = findViewById<EditText>(R.id.text_jabatann)
                val e_gaji = findViewById<EditText>(R.id.txt_gajii)
            } else {
                Toast.makeText(this, "data tidak ada", Toast.LENGTH_SHORT).show()
            }


            val btndelete = findViewById<Button>(R.id.button2)
            btndelete.setOnClickListener {
                delete()
            }
        }
            fun delete(){
                val nik = intent.getStringExtra("nik")
                val nama = intent.getStringExtra("nama")

                val alertsDialog = AlertDialog.Builder(this)
                alertsDialog.setTitle("Delete " + nama +" ?")
                alertsDialog.setMessage("Apakah data ingin dihapus" +nama+" ?")

                alertsDialog.setPositiveButton("iya", DialogInterface.OnClickListener{ dialog, which ->
                    val dbkita = MyDBHelper(this)
                    dbkita.hapusbuku(nik)
                    startActivity(Intent(this,MainActivity::class.java))
                })
                alertsDialog.setNegativeButton("tidak", DialogInterface.OnClickListener { dialog, which ->
                    alertsDialog.create().show()
                })
            }
        }

