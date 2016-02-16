package com.ls.mybrandtherapist.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "edubuzzstaff.db";


    private static final String TABLE_INSTITUTE = "Institute";

    private static final String DATABASE_PATH = "/data/data/com.edubuzzstaff.visionpinnacle/databases/";
    private Context context;
    private SQLiteDatabase myDataBase = null;


    public void saveInstituteDetails(String inst_userid,String inst_code,String inst_name,String firstname,
                                     String lastname,String photo,String designation,String dob) {

        myDataBase = this.getWritableDatabase();
        myDataBase.delete(TABLE_INSTITUTE, null, null);

        ContentValues values = new ContentValues();

            values.put("inst_userid", inst_userid);
            values.put("inst_code", inst_code);
            values.put("inst_name", inst_name);
            values.put("firstname", firstname);
            values.put("lastname", lastname);
            values.put("photo", photo);
            values.put("designation", designation);
            values.put("dob", dob);

            myDataBase.insert(TABLE_INSTITUTE, null, values);

    }

    public Cursor getInstituteDetails(String inst_code) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(TABLE_INSTITUTE, null, "inst_code =?" ,
                    new String[]{inst_code}, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }

        }catch (Exception e) {
            Log.e("EXP SQL", e.toString());
        }
        return cursor;
    }

    //----- database internal operation starts---------

    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();
        if (dbExist) {
//            Log.v("log_tag", "database does exist");
        } else {
//            Log.v("log_tag", "database does not exist");
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
                throw new Error("Error copying database");
            }
        }
    }

    private void copyDataBase() throws IOException {

        InputStream myInput = context.getAssets().open(DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;

        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    private boolean checkDataBase() {

        File folder = new File(DATABASE_PATH);
        if (!folder.exists()) {
            folder.mkdir();
        }
        File dbFile = new File(DATABASE_PATH + DATABASE_NAME);
        return dbFile.exists();
    }

    public boolean openDataBase() throws SQLException {
        String mPath = DATABASE_PATH + DATABASE_NAME;
        //Log.v("mPath", mPath);
        myDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return myDataBase != null;

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    // Constructor
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//----- database internal operation ends---------

    //end of main class
}
