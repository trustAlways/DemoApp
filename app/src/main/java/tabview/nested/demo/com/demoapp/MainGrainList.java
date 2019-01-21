package tabview.nested.demo.com.demoapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

@SuppressLint("ValidFragment")
public class MainGrainList extends Fragment {

    LinearLayout main;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        main = (LinearLayout) inflater.inflate(R.layout.main_extra, container, false);
        return main;
    }
}