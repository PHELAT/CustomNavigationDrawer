package i2020.tutorial.Fragment;


import android.animation.Animator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import i2020.tutorial.R;

/**
 * Created by phelat on 9/29/16.
 */
public class FirstItem extends Fragment {

    public FirstItem() {
        super();
    }

    @Override public View onCreateView(LayoutInflater inflater,
                                       ViewGroup container    ,
                                       Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.first_item_fragment, container, false);

        return rootView;
    }

}
