package techiesandeep.com.navigationdrawer;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * MainActivity is use for creatin navigation drawer
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private MenuItem mPrevItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }


    private void initUI() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setItemIconTintList(null);
        mPrevItem = mNavigationView.getMenu().getItem(0);
        mPrevItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                R.mipmap.home_sel));
        SpannableString s = new SpannableString(mPrevItem.getTitle());
        s.setSpan(new ForegroundColorSpan(Color.parseColor("#2196F3")), 0, s.length(), 0);
        mPrevItem.setTitle(s);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //if the selected item is in checked state, if it's not in checked state, make it in checked state
                /*if (menuItem.isChecked()) menuItem.setChecked(false);
                else*/ menuItem.setChecked(true);


                //Closing drawer on item click
                mDrawerLayout.closeDrawers();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                if(mPrevItem != null){



                    switch (mPrevItem.getItemId()) {
                        case R.id.drawer_home:
                            mPrevItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                                    R.mipmap.home));
                            SpannableString s1 = new SpannableString(mPrevItem.getTitle());
                            s1.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, s1.length(), 0);
                           // mPrevItem.getActionView().setBackgroundColor(Color.parseColor("#FFFFFF"));
                            mPrevItem.setTitle(s1);
                            break;
                        case R.id.drawer_about:
                            mPrevItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                                R.mipmap.aboutus));
                            SpannableString s2 = new SpannableString(mPrevItem.getTitle());
                            s2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, s2.length(), 0);
                           // mPrevItem.getActionView().setBackgroundColor(Color.parseColor("#FFFFFF"));
                            mPrevItem.setTitle(s2);
                            break;
                        case R.id.drawer_settings:
                            mPrevItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                                    R.mipmap.setting));
                            SpannableString s3 = new SpannableString(mPrevItem.getTitle());
                            s3.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, s3.length(), 0);
                           // mPrevItem.getActionView().setBackgroundColor(Color.parseColor("#FFFFFF"));
                            mPrevItem.setTitle(s3);
                            break;
                    }
                }
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.drawer_home:
                        Toast.makeText(getApplicationContext(), "Home Selected", Toast.LENGTH_SHORT).show();
                        HomeFragment fragment = new HomeFragment();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.commit();
                        menuItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                                R.mipmap.home_sel));
                        SpannableString s1 = new SpannableString(menuItem.getTitle());
                        s1.setSpan(new ForegroundColorSpan(Color.parseColor("#2196F3")), 0, s1.length(), 0);
                        menuItem.setTitle(s1);
                        //menuItem.getActionView().setBackgroundColor(Color.parseColor("#EEEEEE"));
                        mPrevItem = menuItem;
                        return true;
                    case R.id.drawer_about:
                        Toast.makeText(getApplicationContext(), "About Selected", Toast.LENGTH_SHORT).show();
                        AboutFragment aboutFragment = new AboutFragment();
                        fragmentTransaction.replace(R.id.container, aboutFragment);
                        fragmentTransaction.commit();
                        menuItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                                R.mipmap.aboutus_sel));
                        SpannableString s2 = new SpannableString(menuItem.getTitle());
                        s2.setSpan(new ForegroundColorSpan(Color.parseColor("#2196F3")), 0, s2.length(), 0);
                        menuItem.setTitle(s2);
                        //menuItem.getActionView().setBackgroundColor(Color.parseColor("#EEEEEE"));
                        mPrevItem = menuItem;
                        return true;
                    case R.id.drawer_settings:
                        Toast.makeText(getApplicationContext(), "Setting Selected", Toast.LENGTH_SHORT).show();
                        SettingFragment settingFragment = new SettingFragment();
                        fragmentTransaction.replace(R.id.container, settingFragment);
                        fragmentTransaction.commit();
                        menuItem.setIcon(ContextCompat.getDrawable(MainActivity.this,
                                R.mipmap.setting_sel));
                        SpannableString s3 = new SpannableString(menuItem.getTitle());
                        s3.setSpan(new ForegroundColorSpan(Color.parseColor("#2196F3")), 0, s3.length(), 0);
                        menuItem.setTitle(s3);
                        //menuItem.getActionView().setBackgroundColor(Color.parseColor("#EEEEEE"));
                        mPrevItem = menuItem;
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
