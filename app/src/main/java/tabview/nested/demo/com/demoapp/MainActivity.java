package tabview.nested.demo.com.demoapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tabview.nested.demo.com.demoapp.viewpager.NonScrollableVP;

public class MainActivity extends AppCompatActivity {

    NonScrollableVP mainPager;
    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPager = (NonScrollableVP) findViewById(R.id.pagerMain);
        tabs = (TabLayout) findViewById(R.id.tabs);
        //setSupportActionBar(tb);
        setUpPager();

    }

    private void setUpPager() {

        MainNewsList news = new MainNewsList();
        MainExtraList extraList = new MainExtraList();
        MainGrainList mainGrainList = new MainGrainList();
        MainPager adapter = new MainPager(getSupportFragmentManager());
        adapter.addFragment(news, "All");
        adapter.addFragment(extraList, "Daily Needs");
        adapter.addFragment(mainGrainList, "Grains");

        mainPager.setAdapter(adapter);
        tabs.setupWithViewPager(mainPager);

    }
//------------------------------------------------------------------------------
public class MainPager extends FragmentPagerAdapter {

    List<Fragment> mFragments = new ArrayList<>();
    List<String> mFragmentsTitle = new ArrayList<>();

    public MainPager(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment f, String s) {
        mFragments.add(f);
        mFragmentsTitle.add(s);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("mylog", mFragmentsTitle.get(position));
        return mFragmentsTitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
 }

}
