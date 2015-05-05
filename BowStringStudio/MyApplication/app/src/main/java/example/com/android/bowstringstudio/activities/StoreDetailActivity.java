package example.com.android.bowstringstudio.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import example.com.android.bowstringstudio.BowStringStudioApplication;
import example.com.android.bowstringstudio.R;
import example.com.android.bowstringstudio.domains.Store;
import example.com.android.bowstringstudio.fragments.PagerAdapterFragment;

public class StoreDetailActivity extends Activity {

    private Store mStore;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_detail_layout);
        mStore = BowStringStudioApplication.getInstance().getStore();
        mActionBar = getActionBar();
        mActionBar.setCustomView(R.layout.action_bar_layout);
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_HOME_AS_UP);
        ((TextView) mActionBar.getCustomView().findViewById(R.id.action_bar_text)).setText("Store Details");
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        int position = getIntent().getIntExtra(PagerAdapterFragment.ARG_SECTION_NUMBER, -1);
        if (position == 1) {
            getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.green_a700));
        } else if (position == 2) {
            getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.blue_a700));
        } else if (position == 3) {
            getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.teal_a700));
        } else if (position == 4) {
            getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.red_a700));
        } else if (position == 5) {
            getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.purple_a700));
        }
        ((TextView) findViewById(R.id.name_text_view)).setText(mStore.getName());
        ((TextView) findViewById(R.id.address_text_view)).setText(mStore.getAddress());
        ((TextView) findViewById(R.id.description_text_view)).setText(mStore.getDescription());
        ((TextView) findViewById(R.id.distance_text_view)).setText(mStore.getDistance() + " Km");
        if (mStore.isDeliveryAvailable()) {
            ((TextView) findViewById(R.id.home_delivery_text_view)).setText("Yes");
        } else {
            ((TextView) findViewById(R.id.home_delivery_text_view)).setText("No");
        }
        ((TextView) findViewById(R.id.phone_text_view)).setText(mStore.getPhone());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
