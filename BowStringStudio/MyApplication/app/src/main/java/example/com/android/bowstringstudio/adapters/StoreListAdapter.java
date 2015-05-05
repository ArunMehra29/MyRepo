package example.com.android.bowstringstudio.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.com.android.bowstringstudio.R;
import example.com.android.bowstringstudio.domains.Store;

/**
 * Created by cognitiveclouds on 02/05/15.
 */
public class StoreListAdapter extends ArrayAdapter<Store> {

    private Context mContext;
    private LayoutInflater mInflater;

    public StoreListAdapter(Context context, ArrayList<Store> storeList) {
        super(context, R.layout.store_row_item_layout, storeList);
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Store store = getItem(position);
        ViewHolder viewHolder;
        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.store_row_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.list_item_icon);
            viewHolder.name = (TextView) convertView.findViewById(R.id.list_item_store_textview);
            viewHolder.address = (TextView) convertView.findViewById(R.id.list_item_address_textview);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.name.setText(store.getName());
        viewHolder.address.setText(store.getAddress());
        viewHolder.image.setImageDrawable(mContext.getResources().getDrawable(R.drawable.stores));
        return convertView;
    }

    public static class ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView address;
    }
}
