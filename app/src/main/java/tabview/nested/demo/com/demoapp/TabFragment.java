package tabview.nested.demo.com.demoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {

    int position;
    String cat_name;
    private TextView textView;

    public static Fragment getInstance(int position, String category_name) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        bundle.putString("cat_name",category_name);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
        cat_name = getArguments().getString("cat_name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_extra, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textView);

        if (cat_name.equals("tab2"))
        {
            textView.setText(" 2 Fragment " + (position + 1));

        }
        else
        {
            textView.setText("Fragment " + (position + 1));
        }

    }
}
