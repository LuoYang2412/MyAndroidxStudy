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
import com.luoyang.myandroidxstudy.R;
import com.luoyang.myandroidxstudy.bean.User;
import timber.log.Timber;

/**
 * 我的页
 *
 * @author LuoYang
 */
public class MeFragment extends Fragment {

    private View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Timber.d("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return rootView = inflater.inflate(R.layout.me_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final TextView nameTextView = rootView.findViewById(R.id.textView4);
        final TextView ageTextView = rootView.findViewById(R.id.textView5);
        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new DetailFragmentArgs.Builder("我的信息").build().toBundle();
                Navigation.findNavController(v).navigate(R.id.action_navigation_me_to_detailFragment3, bundle);
            }
        });

        MeViewModel meViewModel = ViewModelProviders.of(this).get(MeViewModel.class);
        meViewModel.getData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                nameTextView.setText(user.getName());
                ageTextView.setText(String.valueOf(user.getAge()));
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.me, menu);
    }
}
