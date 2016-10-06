package i2020.tutorial.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import i2020.tutorial.Model.Data;
import i2020.tutorial.R;

/**
 * Created by phelat on 9/28/16.
 */
public class NavigationItemsAdapter extends ArrayAdapter<Data> {

    Context mContext;
    int layoutResourceId;
    Data data[] = null;

    protected static Typeface YEKAN;

    public NavigationItemsAdapter(Context mContext, int layoutResourceId, Data[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;

    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.listRowImage);
        TextView textViewName = (TextView) listItem.findViewById(R.id.listRowText);

        YEKAN = (Typeface.createFromAsset(mContext.getAssets(),"Yekan.ttf"));

        textViewName.setTypeface(YEKAN);

        Data folder = data[position];

        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}