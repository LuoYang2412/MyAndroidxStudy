package com.luoyang.myandroidxstudy.ui;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import com.google.gson.JsonObject;
import com.luoyang.myandroidxstudy.R;
import timber.log.Timber;

/**
 * 已购页
 *
 * @author LuoYang
 */
public class BoughtFragment extends Fragment {

    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("onCreate");
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView = inflater.inflate(R.layout.bought_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final TextView contentTextView = rootView.findViewById(R.id.textView3);
        contentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new DetailFragmentArgs.Builder("已购详情").build().toBundle();
                Navigation.findNavController(v).navigate(R.id.action_navigation_bought_to_detailFragment2, bundle);
            }
        });

        BoughtViewModel boughtViewModel = ViewModelProviders.of(this).get(BoughtViewModel.class);
        boughtViewModel.getData().observe(this, new Observer<JsonObject>() {
            @Override
            public void onChanged(JsonObject jsonObject) {
                contentTextView.setText(jsonObject.toString());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.bought, menu);
    }
}
