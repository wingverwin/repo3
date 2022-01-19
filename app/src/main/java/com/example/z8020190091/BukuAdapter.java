package com.example.z8020190091;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.ViewHolderSaya> {

    private Context context;
    private ArrayList nik, nama, jabatan, gaji;
    BukuAdapter(
            Context context,
            ArrayList nik,
            ArrayList nama,
            ArrayList jabatan,
            ArrayList gaji
    ){
        this.context = context;
        this.nik = nik;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }
    @NonNull
    @Override
    public BukuAdapter.ViewHolderSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflaterkita = LayoutInflater.from(context);
        View viewsaya = inflaterkita.inflate(R.layout.row_saya, parent, false);
        return new ViewHolderSaya(viewsaya);
    }


    @Override
    public void onBindViewHolder(@NonNull BukuAdapter.ViewHolderSaya holder, @SuppressLint("RecyclerView") int position) {

       holder.txt_nik.setText(String.valueOf(nik.get(position)));
        holder.txt_nama.setText(String.valueOf(nama.get(position)));
        holder.txt_jabatan.setText(String.valueOf(jabatan.get(position)));
        holder.txt_gaji.setText(String.valueOf(gaji.get(position)));
        holder.layoututama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentkita = new Intent(context, Edit.class);
                intentkita.putExtra("nik",String.valueOf(nik.get(position)));
                intentkita.putExtra("nama",String.valueOf(nama.get(position)));
                intentkita.putExtra("jabatan",String.valueOf(jabatan.get(position)));
                intentkita.putExtra("gaji",String.valueOf(gaji.get(position)));
                context.startActivity(intentkita);
            }
        });


    }

    @Override
    public int getItemCount() {
        return nik.size();
    }

    public class ViewHolderSaya extends RecyclerView.ViewHolder {

        TextView txt_nik, txt_nama, txt_jabatan , txt_gaji;
        LinearLayout layoututama;


        public ViewHolderSaya(@NonNull View itemView) {
            super(itemView);
            txt_nik = itemView.findViewById(R.id.txt_nik);
            txt_nama = itemView.findViewById(R.id.txt_nama);
            txt_gaji = itemView.findViewById(R.id.txt_gajii);
            txt_jabatan = itemView.findViewById(R.id.txt_jabatan);
            layoututama = itemView.findViewById(R.id.layout);
        }
    }
}
