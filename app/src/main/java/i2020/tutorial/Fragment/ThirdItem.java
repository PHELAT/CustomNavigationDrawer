package i2020.tutorial.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import i2020.tutorial.R;

/**
 * Created by phelat on 9/29/16.
 */
public class ThirdItem extends Fragment {

    public ThirdItem() {
        super();
    }

    @Override public View onCreateView(LayoutInflater inflater,
                                       ViewGroup container    ,
                                       Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.third_item_fragment, container, false);

        return rootView;
    }

}
