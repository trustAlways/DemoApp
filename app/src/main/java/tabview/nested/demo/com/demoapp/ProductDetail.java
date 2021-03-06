package tabview.nested.demo.com.demoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.imanoweb.calendarview.CustomCalendarView;
import com.imanoweb.calendarview.DayDecorator;
import com.imanoweb.calendarview.DayView;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.listener.CalenderDayClickListener;
import com.skyhope.eventcalenderlibrary.model.DayContainerModel;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import tabview.nested.demo.com.demoapp.modelfile.Company;

public class ProductDetail extends Fragment {
    View v;
    int position;
    String cat_name;
    RecyclerView recyclerView;
    ArrayList<Company> company;
    Spinner spinner;

    ViewPager viewPager;
    LinearLayout indicator_linear;
    private int dotscount;
    private ImageView[] dots;


   //Arraylist
    ArrayList<String> offerTypesArrayList;
    public  static Fragment getInstance(int position, String category_name){
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        bundle.putString("cat_name",category_name);
        ProductDetail productDetail = new ProductDetail();
        productDetail.setArguments(bundle);
        return productDetail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
        cat_name = getArguments().getString("cat_name");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.product_recycler_view, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.my_recycler_view);

        viewPager = (ViewPager)v.findViewById(R.id._new_view_pager);
        indicator_linear = (LinearLayout)v.findViewById(R.id.dot_indicator);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        offerTypesArrayList = new ArrayList<>();
        offerTypesArrayList.add("Image");
        offerTypesArrayList.add("Video");
        offerTypesArrayList.add("Audio");
        offerTypesArrayList.add("Brief");

        spinner = (Spinner)v.findViewById(R.id.spinner1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, offerTypesArrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        Calendar calendar = Calendar.getInstance();

        final CalenderEvent calenderEvent = v.findViewById(R.id.calender_event);
        //Event event = new Event(calendar.getTimeInMillis(), "Test");
       // to set desire day time milli second in first parameter
       //or you set color for each event
        System.out.println("TIME -- "+calendar.getTimeInMillis());

        Event event = new Event(calendar.getTimeInMillis(), "helooo", Color.RED);
        calenderEvent.addEvent(event);

        String i = "1555686960000";
        String ii = "1555773360000";

        Event event1 = new Event(Long.parseLong(i), "56", Color.BLACK);
        calenderEvent.addEvent(event1);

        Event event11 = new Event(Long.parseLong(ii), "34346", Color.GREEN);
        calenderEvent.addEvent(event11);

        calenderEvent.initCalderItemClickCallback(new CalenderDayClickListener() {
            @Override
            public void onGetDay(DayContainerModel dayContainerModel) {
                System.out.println("select"+ dayContainerModel.getTimeInMillisecond());

            }
        });

        //Initialize CustomCalendarView from layout
       CustomCalendarView calendarView = (CustomCalendarView)v.findViewById(R.id.calendar_view);

        //Initialize calendar with date
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        //Show Monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

       //Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);

       //call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = df.parse("22-04-2019");
            calendarView.markDayAsSelectedDay(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

       /* //adding calendar day decorators
        List<DayDecorator> decorators = new ArrayList<>();
        decorators.add(new DisabledColorDecorator());
        calendarView.setDecorators(decorators);
        calendarView.refreshCalendar(currentCalendar);*/


        setUpViewPager();

        return v;
    }

    //view pager
    private void setUpViewPager()
    {

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        company = new ArrayList<Company>();

        company.add(new Company("1","apple",R.string.dumyText,R.drawable.dn));
        company.add(new Company("2","apple",R.string.dumyText,R.drawable.news_demo));
        company.add(new Company("1","apple",R.string.dumyText,R.drawable.dn));
        company.add(new Company("2","apple",R.string.dumyText,R.drawable.news_demo));
        company.add(new Company("1","apple",R.string.dumyText,R.drawable.dn));
        company.add(new Company("2","apple",R.string.dumyText,R.drawable.news_demo));
        company.add(new Company("1","apple",R.string.dumyText,R.drawable.dn));
        company.add(new Company("2","apple",R.string.dumyText,R.drawable.news_demo));

        MySimpleAdapter adapter = new MySimpleAdapter(getActivity(),company);
        recyclerView.setAdapter(adapter);

    }



    //---------------------------------------------------------------
   /* public class MySimpleAdapter extends BaseAdapter {
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

    }*/

//recycler view adapter class for show datd

public class MySimpleAdapter extends RecyclerView.Adapter
{
    View v;
    ImageView imgcompany,video_play_icon;
    TextView txtname,txtdetail;
    Activity context;
    ArrayList<Company> companyArrayList;
    int VIEW_ONE = 0;
    int VIEW_TWO = 1;
    ArrayList<Integer> subList1 = new ArrayList<>();

    public MySimpleAdapter(FragmentActivity activity, ArrayList<Company> company) {
        this.context = activity;
        this.companyArrayList = company;

        for (int i = 0; i < 50; i++) {
            subList1.add(i);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //v = LayoutInflater.from(getActivity()).inflate(R.layout.single_company, viewGroup, false);
        //return new ViewHolder(v);
        System.out.println("view type "+ i);
        switch (i) {
            case 0:
            {
                v = LayoutInflater.from(getActivity()).inflate(R.layout.nested_recyclerview, viewGroup, false);
                return new CellViewHolder(v);

            }
            case 1:
            {
                v = LayoutInflater.from(getActivity()).inflate(R.layout.single_company, viewGroup, false);
                return new ViewHolder(v);
            }
            default: {
                v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nested_recyclerview, viewGroup, false);
                return new CellViewHolder(v);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        switch (i) {
            case 1: {
                if (companyArrayList.get(i).getComapny_id()=="2")
                {
                    video_play_icon.setVisibility(View.VISIBLE);
                    txtname.setText(companyArrayList.get(i).getCompany_name());
                    txtdetail.setText(companyArrayList.get(i).getCompany_networth());
                    imgcompany.setImageResource(company.get(i).getCompany_photo());
                }
                else
                {
                    video_play_icon.setVisibility(View.GONE);
                    txtname.setText(companyArrayList.get(i).getCompany_name());
                    txtdetail.setText(companyArrayList.get(i).getCompany_networth());
                    imgcompany.setImageResource(company.get(i).getCompany_photo());
                }

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (companyArrayList.get(i).getComapny_id()=="2")
                        {
                            Context context = v.getContext();
                            Intent intent = new Intent(context, NewsVideoPlay.class);
                            context.startActivity(intent);
                        }
                        else
                        {
                            Context context = v.getContext();
                            Intent intent = new Intent(context, DetailActivity.class);
                            intent.putExtra(DetailActivity.EXTRA_POSITION, i);
                            context.startActivity(intent);
                        }

                    }
                });
            }
            case 0:
                {

                }

            }
    }

   /* @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        if (companyArrayList.get(i).getComapny_id()=="2")
        {
            video_play_icon.setVisibility(View.VISIBLE);
            txtname.setText(companyArrayList.get(i).getCompany_name());
            txtdetail.setText(companyArrayList.get(i).getCompany_networth());
            imgcompany.setImageResource(company.get(i).getCompany_photo());
        }
        else
        {
            video_play_icon.setVisibility(View.GONE);
            txtname.setText(companyArrayList.get(i).getCompany_name());
            txtdetail.setText(companyArrayList.get(i).getCompany_networth());
            imgcompany.setImageResource(company.get(i).getCompany_photo());
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companyArrayList.get(i).getComapny_id()=="2")
                {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, NewsVideoPlay.class);
                    context.startActivity(intent);
                }
                else
                {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, i);
                    context.startActivity(intent);
                }

            }
        });

    }
*/
    @Override
    public int getItemViewType(int position) {
        if (position %(6)== 1)
        {
            return VIEW_ONE;
        }
        else
        {
            return VIEW_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return companyArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtname = (TextView)itemView.findViewById(R.id.lbl_name);
            txtdetail = (TextView)itemView.findViewById(R.id.lbl_networth);
            imgcompany = (ImageView)itemView.findViewById(R.id.img_company);
            video_play_icon = (ImageView)itemView.findViewById(R.id.video_play_icon);

        }
    }

    private class CellViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView mRecyclerView;
        private HorizontalRecyclerAdapter adapter;
        private LinearLayoutManager layoutManager;

        public CellViewHolder(View itemView) {
            super(itemView);

            mRecyclerView = itemView.findViewById(R.id.recycler_view);


            mRecyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(layoutManager);

            adapter = new HorizontalRecyclerAdapter();
            mRecyclerView.setAdapter(adapter);
            // this is needed if you are working with CollapsingToolbarLayout, I am adding this here just in case I forget.
            mRecyclerView.setNestedScrollingEnabled(false);
            adapter.updateList(subList1);

        }



    }

    private class HorizontalRecyclerAdapter extends RecyclerView.Adapter {
        private ArrayList<Integer> mList;

        public void updateList(ArrayList<Integer> list) {
            this.mList = list;
            System.out.println("sub list data "+mList.size());
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            switch (i) {
                default: {
                    View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_list_item_type_title, viewGroup, false);
                    return new CellViewHolder(v1);
                }
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            switch (viewHolder.getItemViewType()) {
                default: {
                    CellViewHolder cellViewHolder = (CellViewHolder) viewHolder;
                    cellViewHolder.textView.setText("" + mList.get(position));
                    break;
                }
            }
        }

        private class CellViewHolder extends RecyclerView.ViewHolder{
            private TextView textView;
            public CellViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.text);

            }
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }


        }
    }


   /* private class DisabledColorDecorator implements DayDecorator {
        @Override
        public void decorate(DayView dayView) {

                Toast.makeText(getActivity(), ""+dayView, Toast.LENGTH_SHORT).show();
                int color = Color.parseColor("#a9afb9");
                dayView.setBackgroundColor(color);

        }
    }*/
}
