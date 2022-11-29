package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ProfilActivity extends AppCompatActivity {

    ImageView profile_image;
    TextView username_txt, ttl_txt, jk_txt, telepon_txt, jabatan_txt, alamat_txt, email_txt;
    private String strJson, apiUrl = "http://192.168.1.12/ApiEvakuasiBencana/lihatprofil.php";

    private OkHttpClient client;
    private Response response;
    private RequestBody requestBody;
    private Request request;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait....");
        progressDialog.setCanceledOnTouchOutside(false);

        profile_image = findViewById(R.id.profile_image);
        username_txt = findViewById(R.id.TplNamaAdmin);
        ttl_txt = findViewById(R.id.TplTtlAdmin);
        jk_txt = findViewById(R.id.TplJkAdmin);
        telepon_txt = findViewById(R.id.TplTelepon);
        jabatan_txt = findViewById(R.id.TplJabatan);
        alamat_txt = findViewById(R.id.TplAlamat);
        email_txt = findViewById(R.id.TplEmail);

        progressDialog.show();
        client = new OkHttpClient();
        new GetUserDataRequest().execute();

    }
    public class GetUserDataRequest extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            //requestBody = new FormEncodingBuilder().build();
            request = new Request.Builder().url(apiUrl).build();
            try {
                response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            try {
                strJson = response.body().string();
                updateUserData(strJson);
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    private void updateUserData(String strJson) {
        try {
            JSONArray parent = new JSONArray(strJson);
            JSONObject child = parent.getJSONObject(0);
            String imgUrl = child.getString("imageLink");
            String username = child.getString("username");
            String ttl = child.getString("ttl");
            String jk = child.getString("jk");
            String telepon = child.getString("telepon");
            String jabatan = child.getString("jabatan");
            String alamat = child.getString("alamat");
            String email = child.getString("email");
            Glide.with(this).load(imgUrl).into(profile_image);

            username_txt.setText(username);
            ttl_txt.setText(ttl);
            jk_txt.setText(jk);
            telepon_txt.setText(telepon);
            jabatan_txt.setText(jabatan);
            alamat_txt.setText(alamat);
            email_txt.setText(email);
            progressDialog.hide();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Ubahakun(View view) {
        Intent intent= new Intent(ProfilActivity.this, UbahprofilActivity.class);
        startActivity(intent);
    }

    public void Tambahadmin(View view) {
        Intent intent= new Intent(ProfilActivity.this, TambahakunActivity.class);
        startActivity(intent);
    }
}