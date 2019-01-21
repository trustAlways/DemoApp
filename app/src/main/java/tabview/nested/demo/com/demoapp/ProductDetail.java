package tabview.nested.demo.com.demoapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tabview.nested.demo.com.demoapp.modelfile.Company;

public class ProductDetail extends Fragment {
    View v;
    GridView gridView;
    ArrayList<Company> company;

    public ProductDetail() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.product_recycler_view, container, false);
        gridView = (GridView) v.findViewById(R.id.grid);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
         company = new ArrayList<Company>();

        company.add(new Company("1","apple","Good for health",R.drawable.ic_launcher_background));
        company.add(new Company("1","apple","Good for health",R.drawable.ic_launcher_background));
        company.add(new Company("1","apple","Good for health",R.drawable.ic_launcher_background));
        company.add(new Company("1","apple","Good for health",R.drawable.ic_launcher_background));
        company.add(new Company("1","apple","Good for health",R.drawable.ic_launcher_background));
        company.add(new Company("1","apple","Good for health",R.drawable.ic_launcher_background));

        MySimpleAdapter adapter = new MySimpleAdapter(getActivity(),company);
        gridView.setAdapter(adapter);
    }

    //---------------------------------------------------------------
    public class MySimpleAdapter extends BaseAdapter {
        View v;
        ImageView imgcompany;
        TextView txtname,txtdetail;
        Activity context;
        ArrayList<Company> companyArrayList;

        public MySimpleAdapter(FragmentActivity activity, ArrayList<Company> company) {
          this.context = activity;
          this.companyArrayList = company;
        }

        @Override
        public int getCount() {
            return companyArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return companyArrayList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            v = LayoutInflater.from(getActivity()).inflate(R.layout.single_company, viewGroup, false);
            txtname = (TextView)v.findViewById(R.id.lbl_name);
            txtdetail = (TextView)v.findViewById(R.id.lbl_networth);
            imgcompany = (ImageView)v.findViewById(R.id.img_company);

            txtname.setText(companyArrayList.get(i).getCompany_name());
            txtdetail.setText(companyArrayList.get(i).getCompany_networth());
            imgcompany.setImageResource(company.get(i).getCompany_photo());

            return v;
        }

    }
}
