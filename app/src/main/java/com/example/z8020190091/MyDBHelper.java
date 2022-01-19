package com.example.z8020190091;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

        private Context context;
        private static final String DATABASE_NAME = "karyawan.db";
        private static final int DATABASE_VERSION = 1;

        private static final String TABLE_NAME = "karyawan";
        private static final String COLUMN_NIK = "_nik";
        private static final String COLUMN_NAMA = "nama";
        private static final String COLUMN_JABATAN = "jabatan";
        private static final String COLUMN_GAJI = "gaji";

    public MyDBHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" +
                COLUMN_NIK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMA + " TEXT, " +
                COLUMN_JABATAN + " TEXT, " +
                COLUMN_GAJI + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void tambah(String nama, String jabatan, int gaji ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAMA, nama);
        cv.put(COLUMN_JABATAN, jabatan);
        cv.put(COLUMN_GAJI, gaji);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) {
            Toast.makeText(context, "data gagal ditambahkan!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor bacasemuadata() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor datasaya = null;
        if (db != null) {
            datasaya = db.rawQuery(query, null);
        }
        return datasaya;
    }


    void ubah(String nik, String nama, String jabatan, String gaji) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues datakita = new ContentValues();
        datakita.put(COLUMN_NAMA, nama);
        datakita.put(COLUMN_JABATAN, jabatan);
        datakita.put(COLUMN_GAJI, gaji);

        long hasil = db.update(TABLE_NAME, datakita, "_nik=?", new String[]{nik});

        if (hasil == -1) {
            Toast.makeText(context, "ada gangguan", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "berhasil diupdate", Toast.LENGTH_SHORT).show();
        }


    }

        void hapusbuku(String row_saya){
        SQLiteDatabase dbkita = this.getReadableDatabase();
        long result = dbkita.delete(TABLE_NAME,"_nik=?",new String[]{row_saya});

        if(result == -1){
            Toast.makeText(context,"Gagal menghapus",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context,"berhasil dihapus",Toast.LENGTH_SHORT).show();
        }

    }
}
