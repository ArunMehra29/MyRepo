package example.com.android.bowstringstudio.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import example.com.android.bowstringstudio.R;
import example.com.android.bowstringstudio.adapters.CategoriesFragmentAdapter;


public class BaseActivity extends Activity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private CategoriesFragmentAdapter mCategoriesFragmentAdapter;
    private ArrayList<String> mStringArray = new ArrayList<String>();

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private ActionBar mActionBar;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mInflater = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        // Set up the action bar.
        mActionBar = getActionBar();
        mActionBar.setCustomView(R.layout.action_bar_layout);
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mStringArray.add(getString(R.string.title_section1));
        mStringArray.add(getString(R.string.title_section2));
        mStringArray.add(getString(R.string.title_section3));
        mStringArray.add(getString(R.string.title_section4));
        mStringArray.add(getString(R.string.title_section5));
        mCategoriesFragmentAdapter = new CategoriesFragmentAdapter(getFragmentManager(), mStringArray);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCategoriesFragmentAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mActionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mCategoriesFragmentAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            View view = mInflater.inflate(R.layout.pager_text_view, null);
            ((TextView) view.findViewById(R.id.nieuws_tab_layout)).setText(mCategoriesFragmentAdapter.getPageTitle(i));
            mActionBar.addTab(
                    mActionBar.newTab().setCustomView(view)
                            .setTabListener(this));
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        int position = tab.getPosition();
        ((TextView) mActionBar.getCustomView().findViewById(R.id.action_bar_text)).setText(mCategoriesFragmentAdapter.getPageTitle(position));
        if (position == 0) {
            mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green_a500)));
            mActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.green_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.green_a700));
        } else if (position == 1) {
            mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue_a500)));
            mActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.blue_a700));
        } else if (position == 2) {
            mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_a500)));
            mActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.teal_a700));
        } else if (position == 3) {
            mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red_a500)));
            mActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.red_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.red_a700));
        } else if (position == 4) {
            mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_a500)));
            mActionBar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_a500)));
            window.setStatusBarColor(getResources().getColor(R.color.purple_a700));
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

}
