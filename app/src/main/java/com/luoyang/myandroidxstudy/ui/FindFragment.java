package com.luoyang.myandroidxstudy.ui;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luoyang.myandroidxstudy.R;
import com.luoyang.myandroidxstudy.bean.Find;
import timber.log.Timber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LuoYang 发现页
 */
public class FindFragment extends Fragment {

    private BaseQuickAdapter<Find, BaseViewHolder> adAdapter = new BaseQuickAdapter<Find, BaseViewHolder>(R.layout.item_find_ad, new ArrayList<Find>()) {
        @Override
        protected void convert(BaseViewHolder helper, Find item) {
            helper.setText(R.id.findAdItem_textView, item.getText());
        }
    };
    private BaseQuickAdapter<Find, BaseViewHolder> contentAdapter = new BaseQuickAdapter<Find, BaseViewHolder>(R.layout.item_find_content, new ArrayList<Find>()) {
        @Override
        protected void convert(BaseViewHolder helper, Find item) {
            helper.setText(R.id.findContentItem_textView2, item.getText());
        }
    };
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
        return rootView = inflater.inflate(R.layout.find_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((RecyclerView) rootView.findViewById(R.id.findAd_recyclerView)).setAdapter(adAdapter);
        ((RecyclerView) rootView.findViewById(R.id.findContent_recyclerView)).setAdapter(contentAdapter);
        adAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Find item = (Find) adapter.getItem(position);
                if (item != null) {
                    String detail = item.getText();
                    if (detail != null) {
                        Bundle bundle = new DetailFragmentArgs.Builder(detail).build().toBundle();
                        Navigation.findNavController(view).navigate(R.id.action_navigation_find_to_detailFragment, bundle);
                    }
                }
            }
        });
        contentAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Find item = (Find) adapter.getItem(position);
                if (item != null) {
                    String detail = item.getText();
                    if (detail != null) {
                        Bundle bundle = new DetailFragmentArgs.Builder(detail).build().toBundle();
                        Navigation.findNavController(view).navigate(R.id.action_navigation_find_to_detailFragment, bundle);
                    }
                }
            }
        });

        FindViewModel findViewModel = ViewModelProviders.of(this).get(FindViewModel.class);
        Observer<List<Find>> observer = new Observer<List<Find>>() {
            @Override
            public void onChanged(List<Find> finds) {
                ArrayList<Find> adList = new ArrayList<>();
                ArrayList<Find> contentList = new ArrayList<>();
                for (Find find : finds) {
                    if ("AD".equals(find.getType())) {
                        adList.add(find);
                    } else if ("content".equals(find.getType())) {
                        contentList.add(find);
                    }
                }
                adAdapter.getData().clear();
                adAdapter.getData().addAll(adList);
                adAdapter.notifyDataSetChanged();
                contentAdapter.getData().clear();
                contentAdapter.getData().addAll(contentList);
                contentAdapter.notifyDataSetChanged();
            }
        };
        findViewModel.getQuery().observe(this, observer);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.find, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("搜索");
        ViewCompat.setBackground(searchView, getResources().getDrawable(R.drawable.edit_search_bg));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ActionMenuView.LayoutParams layoutParams = new ActionMenuView.LayoutParams(activity.getWindow().getDecorView().getWidth(), ActionMenuView.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.CENTER;
            searchView.setLayoutParams(layoutParams);
        }

    }
}
