package com.example.seniorproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT, phoneNumber TEXT)");
        db.execSQL("CREATE TABLE contacts(ID INTEGER PRIMARY KEY AUTOINCREMENT, contactName TEXT, contactPhone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2){
            db.execSQL("DROP TABLE IF EXISTS user");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }


    public boolean Insert(String fullName, String email, String password, String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", fullName);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("phoneNumber", phone);
        long result = sqLiteDatabase.insert("   user", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean InsertContact(String name, String phone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contactName", name);
        contentValues.put("contactPhone", phone);
        long result = sqLiteDatabase.insert("contacts", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public void updatePassword(String email, String NewPassword){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", NewPassword);
        db.update("user", contentValues, "email=?", new String[]{email});

    }

    public Boolean updateContact(String originalContactPhone, String newContactName, String newContactPhone) {
        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put("contactName", newContactName);
        values.put("contactPhone", newContactPhone);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        long result = db.update("contacts", values, "contactPhone=?", new String[]{originalContactPhone});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean deleteOneContact(String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("contacts", "contactPhone=?", new String[]{phone});
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean CheckEmail(String email){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "SELECT * FROM user WHERE email =?";
        String[] whereArg = {email};
        Cursor cursor = sqLiteDatabase.rawQuery(query,whereArg);
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkAlreadyExist(String email) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = " SELECT  * FROM user WHERE email =?";
            Cursor cursor = db.rawQuery(query, new String[]{email});
            try {
                if (cursor.getCount() > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException es) {

            }
        } catch (SQLiteReadOnlyDatabaseException e) {

        }
        return true;
    }

    public Boolean checkAlreadyExitsContact(String phone) {
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = " SELECT  * FROM contacts WHERE contactPhone =?";
            Cursor cursor = db.rawQuery(query, new String[]{phone});
            try {
                if (cursor.getCount() > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException es) {

            }
        } catch (SQLiteReadOnlyDatabaseException e) {

        }
        return true;
    }

    Cursor readAllData(){
        String query = "SELECT * FROM contacts";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = null;
        if(sqLiteDatabase != null){
            cursor = sqLiteDatabase.rawQuery(query, null);
        }
        return cursor;
    }

    public Boolean CheckLogin(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE email=? AND password=?", new String[]{email, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

}
