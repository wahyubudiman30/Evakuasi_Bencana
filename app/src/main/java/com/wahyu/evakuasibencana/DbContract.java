package com.wahyu.evakuasibencana;

public class DbContract {

    //public static final String ROOT_URL = "http://192.168.1.11/ApiEvakuasiBencana/";
    //public static String URL_REGISTER = ROOT_URL+"register.php";
    public static final String SERVER_LOGIN_URL = "http://192.168.1.12/ApiEvakuasiBencana/checkLogin.php";
    public static final String SERVER_REGISTER_URL = "http://192.168.1.12/ApiEvakuasiBencana/createData.php";
    public static final String URL_READ = "http://192.168.1.12/ApiEvakuasiBencana/read_detail.php";
    public static final String URL_EDIT = "http://192.168.1.12/ApiEvakuasiBencana/edit_detail.php";
    public static final String URL_UPLOAD = "http://192.168.1.12/ApiEvakuasiBencana/upload.php";

    public static final String URL_ADD="http://192.168.1.12/ApiEvakuasiBencana/tambahLokasi.php";
    public static final String URL_GET_ALL = "http://192.168.1.12/ApiEvakuasiBencana/tampilSemuaLokasi.php";
    public static final String URL_GET_EMP = "http://192.168.1.12/ApiEvakuasiBencana/tampilLokasi.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.12/ApiEvakuasiBencana/ubahLokasi.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.12/ApiEvakuasiBencana/hapusLokasi.php?id=";

    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "nama_lokasi";
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_KELURAHAN = "kelurahan";
    public static final String KEY_EMP_KECAMATAN = "kecamatan";
    public static final String KEY_EMP_LATITUDE = "latitude";
    public static final String KEY_EMP_LONGITUDE = "longitude";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama_lokasi";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_KELURAHAN = "kelurahan";
    public static final String TAG_KECAMATAN = "kecamatan";
    public static final String TAG_LATITUDE = "latitude";
    public static final String TAG_LONGITUDE = "longitude";

    public static final String EMP_ID = "emp_id";
}
