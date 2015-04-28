package adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import application.FlatChatApplication;
import example.com.android.flatchatassignment.R;

/**
 * Created by cognitiveclouds on 09/04/15.
 */
public class MessageCursorAdapter extends CursorAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ImageLoader mImageLoader;

    public MessageCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mImageLoader = FlatChatApplication.getInstance().getImageLoader();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mLayoutInflater.inflate(R.layout.message_row_item_layout, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView messageType = (TextView) view.findViewById(R.id.message_type_text_view);
        TextView messageBody = (TextView) view.findViewById(R.id.message_body_text_view);
        TextView messageId = (TextView) view.findViewById(R.id.message_id_text_view);
        TextView messageTimestamp = (TextView) view.findViewById(R.id.message_timestamp_text_view);
        NetworkImageView messageImage = (NetworkImageView) view.findViewById(R.id.message_image_view);
        messageId.setText(cursor.getString(0));
        String typeString = cursor.getString(1);
        int typeInt = Integer.parseInt(typeString);
        messageType.setText(typeString);
        if (0 == typeInt) {
            messageBody.setVisibility(View.VISIBLE);
            messageImage.setVisibility(View.GONE);
            messageBody.setText(cursor.getString(2));
        } else {
            messageBody.setVisibility(View.GONE);
            messageImage.setVisibility(View.VISIBLE);
            messageImage.setImageUrl(cursor.getString(2), mImageLoader);
        }
        messageTimestamp.setText(cursor.getString(3));
    }
}
