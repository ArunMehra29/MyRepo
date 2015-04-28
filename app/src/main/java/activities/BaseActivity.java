package activities;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import adapter.MessageCursorAdapter;
import application.FlatChatApplication;
import example.com.android.flatchatassignment.R;
import utils.SQLiteDatabaseHelper;


public class BaseActivity extends Activity {

    private final int GET_CHAT_TASKCODE = 1;
    private final String LOG_TAG = BaseActivity.class.getSimpleName();
    private ListView mMessageListView;
    private MessageCursorAdapter mMessageCursorAdapter;
    private SQLiteDatabaseHelper databaseHelper;
    private Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mMessageListView = (ListView) findViewById(R.id.message_list_view);
        databaseHelper = SQLiteDatabaseHelper.getDatabaseHelper(BaseActivity.this);
        if (databaseHelper.isDataAvailable()) {
            Log.d(LOG_TAG, "if part of statement fired");
            mCursor = databaseHelper.getDatabaseCursor();
            mMessageCursorAdapter = new MessageCursorAdapter(BaseActivity.this, mCursor);
            mMessageListView.setAdapter(mMessageCursorAdapter);
        } else {
            Log.d(LOG_TAG, "else part of statement fired");
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "http://pastebin.com/raw.php?i=aqziuquq", null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject jsonObject) {
                    Log.d("response", jsonObject.toString());
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = jsonObject.getJSONArray("chats");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for(int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject object = jsonArray.getJSONObject(i);
                            ContentValues values = new ContentValues();
                            values.put(SQLiteDatabaseHelper.COLUMN_DATA, object.get("msg_data").toString());
                            values.put(SQLiteDatabaseHelper.COLUMN_ID, object.get("msg_id").toString());
                            values.put(SQLiteDatabaseHelper.COLUMN_TIMESTAMP, object.get("timestamp").toString());
                            values.put(SQLiteDatabaseHelper.COLUMN_TYPE, object.get("msg_type").toString());
                            databaseHelper.getWritableDatabase().insert(SQLiteDatabaseHelper.TABLE_MESSAGE, null, values);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    databaseHelper.close();
                    mCursor = databaseHelper.getDatabaseCursor();
                    mMessageCursorAdapter = new MessageCursorAdapter(BaseActivity.this, mCursor);
                    mMessageListView.setAdapter(mMessageCursorAdapter);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    Log.d(LOG_TAG, volleyError.toString());
                }
            });
            FlatChatApplication.getInstance().addToRequestQueue(jsonObjectRequest);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
