package example.kissanproject.datamodels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by abhishek on 12/7/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Table Names
    private static final String TABLE_TODO = "todos";
    private static final String TABLE_TAG = "tags";
    private static final String TABLE_TODO_TAG = "todo_tags";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // NOTES Table - column nmaes
    private static final String KEY_NAME = "todo";
    private static final String KEY_NUMBER = "status";
    private static final String KEY_OTP = "otp";



    private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_TODO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_NUMBER + " TEXT," +KEY_OTP + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    public long createToDo(SmsRecord todo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, todo.getmName());
        values.put(KEY_NUMBER, todo.getmNumber());
        values.put(KEY_OTP,todo.getmOtp());
        values.put(KEY_CREATED_AT, getDateTime());

        // insert row
        long todo_id = db.insert(TABLE_TODO, null, values);

        return todo_id;
    }
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    public SmsRecord getTodo(long todo_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "
                + KEY_ID + " = " + todo_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        SmsRecord td = new SmsRecord();
        td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        td.setmName(c.getString(c.getColumnIndex(KEY_NAME)));
        td.setmNumber(c.getString(c.getColumnIndex(KEY_NUMBER)));
        td.setmOtp(c.getString(c.getColumnIndex(KEY_OTP)));
        td.setDate(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

        return td;
    }
    public List<SmsRecord> getAllToDos() {
        List<SmsRecord> todos = new ArrayList<SmsRecord>();
        String selectQuery = "SELECT  * FROM " + TABLE_TODO+" ORDER BY "+KEY_CREATED_AT+" DESC";

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                SmsRecord td = new SmsRecord();
                td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                td.setmName(c.getString(c.getColumnIndex(KEY_NAME)));
                td.setmNumber(c.getString(c.getColumnIndex(KEY_NUMBER)));
                td.setmOtp(c.getString(c.getColumnIndex(KEY_OTP)));
                td.setDate(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                todos.add(td);
            } while (c.moveToNext());
        }

        return todos;
    }

    /*
 * Deleting a todo
 */
    public void deleteToDo(long tado_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO, KEY_ID + " = ?",
                new String[] { String.valueOf(tado_id) });
    }
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}
