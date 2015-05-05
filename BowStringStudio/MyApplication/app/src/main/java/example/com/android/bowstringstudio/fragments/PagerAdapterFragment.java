package example.com.android.bowstringstudio.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import example.com.android.bowstringstudio.BowStringStudioApplication;
import example.com.android.bowstringstudio.R;
import example.com.android.bowstringstudio.activities.StoreDetailActivity;
import example.com.android.bowstringstudio.adapters.StoreListAdapter;
import example.com.android.bowstringstudio.domains.Store;

/**
 * Created by cognitiveclouds on 02/05/15.
 */
public class PagerAdapterFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";
    private StoreListAdapter mStoreAdapter;
    private ListView mListView;
    private int mPosition;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PagerAdapterFragment newInstance(int sectionNumber) {
        PagerAdapterFragment fragment = new PagerAdapterFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PagerAdapterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_base, container, false);
        mListView = (ListView) rootView.findViewById(R.id.store_list_view);
        mStoreAdapter = new StoreListAdapter(getActivity(), new ArrayList<Store>());
        mListView.setAdapter(mStoreAdapter);
        handleBundle(getArguments());
        mListView.setOnItemClickListener(onListItemClickListener);
        return rootView;
    }

    AdapterView.OnItemClickListener onListItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            BowStringStudioApplication.getInstance().setStore(mStoreAdapter.getItem(i));
            Intent intent = new Intent(getActivity(), StoreDetailActivity.class);
            intent.putExtra(ARG_SECTION_NUMBER, mPosition);
            startActivity(intent);
        }
    };

    private void handleBundle(Bundle b) {
        mPosition = b.getInt(ARG_SECTION_NUMBER);
        setListWithData();
    }

    private void setListWithData() {
        mStoreAdapter.clear();
        new GetStoreData().execute(mPosition);
        mStoreAdapter.notifyDataSetChanged();
    }

    class GetStoreData extends AsyncTask<Integer, Void, ArrayList<Store>> {

        public static final String TOYS = "toys";
        public static final String CLOTHES = "clothes";
        public static final String HARDWARE = "hardware";
        public static final String SPORTS = "sports";
        public static final String GROCERIES = "groceries";

        @Override
        protected ArrayList<Store> doInBackground(Integer... integers) {
            int position = integers[0];
            Store store;
            ArrayList<Store> toyStoreList = new ArrayList<Store>();
            for(int i = 1; i < 10; i++) {
                store = new Store();
                String prefix = "";
                if (position == 1) {
                    prefix = TOYS;
                } else if (position == 2) {
                    prefix = CLOTHES;
                } else if (position == 3) {
                    prefix = SPORTS;
                } else if (position == 4) {
                    prefix = HARDWARE;
                } else if (position == 5) {
                    prefix = GROCERIES;
                }
                store.setName(prefix + "Store" + i);
                store.setAddress(prefix + "StoreAddress" + i);
                store.setStoreId(prefix + "StoreId" + i);
                store.setDescription(prefix + "some description" + i);
                store.setDistance(10);
                store.setIsDeliveryAvailable(true);
                store.setPhone(i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i + "" + i);
                toyStoreList.add(store);
            }
            return toyStoreList;
        }

        @Override
        protected void onPostExecute(ArrayList<Store> stores) {
            mStoreAdapter.addAll(stores);
        }
    }
}
