package com.wahyu.evakuasibencana;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class PengungsianActivity extends AppCompatActivity implements ListView.OnItemClickListener{

    private ListView listView;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengungsian);

        listView = (ListView) findViewById(R.id.listV);
        listView.setOnItemClickListener(this);
        getJSON();
    }
    private void showEmployee(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(Konfigurasi.TAG_JSON_ARRAY);

            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String id = jo.getString(Konfigurasi.TAG_ID);
                String name = jo.getString(Konfigurasi.TAG_NAMA);
                String alamat = jo.getString(Konfigurasi.TAG_ALAMAT);
                String kecamatan = jo.getString(Konfigurasi.TAG_KECAMATAN);
                String kelurahan = jo.getString(Konfigurasi.TAG_KELURAHAN);
                String latitude = jo.getString(Konfigurasi.TAG_LATITUDE);
                String longitude = jo.getString(Konfigurasi.TAG_LONGITUDE);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(Konfigurasi.TAG_ID,id);
                employees.put(Konfigurasi.TAG_NAMA,name);
                employees.put(Konfigurasi.TAG_ALAMAT,alamat);
                employees.put(Konfigurasi.TAG_KECAMATAN,kecamatan);
                employees.put(Konfigurasi.TAG_KELURAHAN,kelurahan);
                employees.put(Konfigurasi.TAG_LATITUDE,latitude);
                employees.put(Konfigurasi.TAG_LONGITUDE,longitude);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                PengungsianActivity.this, list, R.layout.list_item,
                new String[]{Konfigurasi.TAG_ID,Konfigurasi.TAG_NAMA},
                new int[]{R.id.id, R.id.name});

        listView.setAdapter(adapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(PengungsianActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(Konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TampilLokasiActivity.class);
        HashMap<String,String> map =(HashMap)parent.getItemAtPosition(position);
        String empId = map.get(Konfigurasi.TAG_ID).toString();
        intent.putExtra(Konfigurasi.EMP_ID,empId);
        startActivity(intent);
    }

    public void TambahPosko(View view) {
        Intent intent = new Intent(PengungsianActivity.this, TambahdataActivity.class);
        startActivity(intent);
    }
}