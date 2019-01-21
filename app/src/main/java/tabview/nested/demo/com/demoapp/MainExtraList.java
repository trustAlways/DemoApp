package tabview.nested.demo.com.demoapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class MainExtraList extends Fragment {
    View main;
    TabLayout tabs;
    ViewPager vpNews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        main = inflater.inflate(R.layout.scrollable_tab, container, false);

        tabs = (TabLayout) main.findViewById(R.id.tabScrollable);
        vpNews = (ViewPager) main.findViewById(R.id.vpNews);
        setUpPager();
        return main;
    }


    private void setUpPager() {
        NewsPagerAdapter adp = new NewsPagerAdapter(getFragmentManager());
        NewsList n1 = new NewsList();
        ProductDetail n2 = new ProductDetail();
        NewsList n3 = new NewsList();
        NewsList n4 = new NewsList();
        NewsList n5 = new NewsList();

        adp.addFrag(n1, "Oil");
        adp.addFrag(n2, "Kirana");
        adp.addFrag(n3, "Tooth Paste");
        adp.addFrag(n4, "Salt");
        adp.addFrag(n5, "Shampoo");

        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        vpNews.setAdapter(adp);
        vpNews.setOffscreenPageLimit(12);
        tabs.setupWithViewPager(vpNews);
    }



    public class NewsPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        public NewsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFrag(Fragment f, String title) {
            fragList.add(f);
            titleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragList.get(position);
        }

        @Override
        public int getCount() {
            return fragList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
