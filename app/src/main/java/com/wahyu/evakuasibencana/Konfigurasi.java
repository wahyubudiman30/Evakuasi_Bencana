package com.wahyu.evakuasibencana;

public class Konfigurasi {
    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan

    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.1.24/ApiEvakuasiBencana/tambahLokasi.php";
    public static final String URL_GET_ALL = "http://192.168.1.24/ApiEvakuasiBencana/tampilSemuaLokasi.php";
    public static final String URL_GET_EMP = "http://192.168.1.24/ApiEvakuasiBencana/tampilLokasi.php";
    public static final String URL_UPDATE_EMP = "http://192.168.1.24/ApiEvakuasiBencana/ubahLokasi.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.24/ApiEvakuasiBencana/hapusLokasi.php";

    //apaini
    public static final String ROOT_URL = "http://192.168.1.20/ApiEvakuasiBencana/";
    public static String URL_REGISTER = ROOT_URL+"register.php";
    public static String URL_LOGIN = ROOT_URL+"checkLogin.php";
    public static String URL_READ = ROOT_URL+"read_detail.php";
    public static String URL_EDIT = ROOT_URL+"edit_detail.php";
    public static String URL_UPLOAD = ROOT_URL+"upload.php";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "nama_lokasi";
    public static final String KEY_EMP_ALAMAT = "alamat"; //alamat itu variabel untuk Alamat
    public static final String KEY_EMP_KELURAHAN = "kelurahan";
    public static final String KEY_EMP_KECAMATAN = "kecamatan";
    public static final String KEY_EMP_LATITUDE = "latitude"; //latitude itu variabel untuk Latitude
    public static final String KEY_EMP_LONGITUDE = "longitude"; //latitude itu variabel untuk Longitude

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama_lokasi";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_KELURAHAN = "kelurahan";
    public static final String TAG_KECAMATAN = "kecamatan";
    public static final String TAG_LATITUDE = "latitude";
    public static final String TAG_LONGITUDE = "longitude";

    //ID Lokasi
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
