package tabview.nested.demo.com.demoapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import tabview.nested.demo.com.demoapp.modelfile.news_category;
import tabview.nested.demo.com.demoapp.viewpager.NonScrollableVP;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    List<news_category> mCategoryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpPager();

    }

    private void setUpPager() {
        mCategoryTitle = new ArrayList<>();
        mCategoryTitle.add(new news_category("tab1"));
        mCategoryTitle.add(new news_category("tab2"));
        mCategoryTitle.add(new news_category("tab3"));


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),mCategoryTitle);
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
//------------------------------------------------------------------------------
public class ViewPagerAdapter extends FragmentPagerAdapter {

   // List<Fragment> mFragments = new ArrayList<>();
    List<news_category> mFragmentsTitle;

    public ViewPagerAdapter(FragmentManager fm, List<news_category> mCategoryTitle) {
        super(fm);
        this.mFragmentsTitle = mCategoryTitle;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("mylog", mFragmentsTitle.get(position).getCategory_name());
        return mFragmentsTitle.get(position).getCategory_name();
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.getInstance(position,mFragmentsTitle.get(position).getCategory_name());
    }

    @Override
    public int getCount() {
        return mFragmentsTitle.size();
    }
 }

}
