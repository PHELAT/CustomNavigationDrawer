package i2020.tutorial;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import i2020.tutorial.Adapter.NavigationItemsAdapter;
import i2020.tutorial.Fragment.FirstItem;
import i2020.tutorial.Fragment.SecondItem;
import i2020.tutorial.Fragment.ThirdItem;
import i2020.tutorial.Model.Data;

/**
 * Created by phelat on 9/28/16.
 */
public class MainActivity extends AppCompatActivity {

    protected String[] mNavigationDrawerItemTitles;
    protected DrawerLayout mDrawerLayout;
    protected ListView mDrawerList;
    protected Toolbar toolbar;
    protected CharSequence mDrawerTitle;
    protected CharSequence mTitle;

    protected ImageView toolbarToggle;

    protected static int buildVersion;

    protected TextView toolbarTitle;

    protected static Typeface YEKAN;

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        Data[] drawerItem = new Data[3];

        drawerItem[0] = new Data(R.drawable.ic_android_yellow_800_24dp, "ایتم اول");
        drawerItem[1] = new Data(R.drawable.ic_android_yellow_800_24dp, "ایتم دوم");
        drawerItem[2] = new Data(R.drawable.ic_android_yellow_800_24dp, "ایتم سوم");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationItemsAdapter adapter = new NavigationItemsAdapter
                (this, R.layout.nav_list_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbarToggle = (ImageView)findViewById(R.id.toolbarToggle);
        toolbarToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(GravityCompat.END);

            }
        });

        YEKAN = (Typeface.createFromAsset(getAssets(),"Yekan.ttf"));

        buildVersion = Build.VERSION.SDK_INT;

        Log.i("PHELAT", String.valueOf(buildVersion));

        if(buildVersion > 20){

            toolbarToggle.setBackgroundResource(R.drawable.ripple);

        }

        toolbarTitle = (TextView)findViewById(R.id.toolbarTitle);
        toolbarTitle.setTypeface(YEKAN);

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override public void onItemClick
                (AdapterView<?> parent, View view, int position, long id) {
                    selectItem(position);
        }
    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new FirstItem();
                break;
            case 1:
                fragment = new SecondItem();
                break;
            case 2:
                fragment = new ThirdItem();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(GravityCompat.END);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override public void setTitle(CharSequence title) {
        mTitle = title;
        toolbarTitle.setText(mTitle);
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

}
