package example.com.android.bowstringstudio.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;

import example.com.android.bowstringstudio.fragments.PagerAdapterFragment;

/**
 * Created by cognitiveclouds on 02/05/15.
 */
public class CategoriesFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mStringArray;

    public CategoriesFragmentAdapter(FragmentManager fm, ArrayList<String> stringArray) {
        super(fm);
        this.mStringArray = stringArray;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        return PagerAdapterFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return mStringArray.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStringArray.get(position);
    }
}
