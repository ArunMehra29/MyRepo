package utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private static SQLiteDatabaseHelper helper;

    //table name and column names
    public static final String TABLE_MESSAGE = "messages";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TYPE = "message_type";
    public static final String COLUMN_DATA = "message_data";
    public static final String COLUMN_TIMESTAMP = "message_timestamp";

    //database version and name
    private static final String DATABASE_NAME = "floorchat.db";
    private static final int DATABASE_VERSION = 1;

    //create table statement
    private static final String TALBE_ONE = "create table " + TABLE_MESSAGE + "( " + COLUMN_ID + " text primary key, " + COLUMN_TYPE + " text not null," + COLUMN_DATA + " text not null," + COLUMN_TIMESTAMP + " text not null );";

    private SQLiteDatabaseHelper(Context context) {
        // TODO Auto-generated constructor stub
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteDatabaseHelper getDatabaseHelper(Context context) {
        if (null == helper) {
            helper = new SQLiteDatabaseHelper(context);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // TODO Auto-generated method stub
        database.execSQL(TALBE_ONE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

    public boolean isDataAvailable() {
        Cursor cursor = getReadableDatabase().query(TABLE_MESSAGE, null, null, null, null, null, null);
        return cursor.moveToFirst();
    }

    public Cursor getDatabaseCursor() {
        Cursor cursor = getReadableDatabase().query(TABLE_MESSAGE, null, null, null, null, null, null);
        if (null != cursor) {
            cursor.moveToFirst();
        }
        return cursor;
    }

}
