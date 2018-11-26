package com.luoyang.myandroidxstudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luoyang.myandroidxstudy.R;
import com.luoyang.myandroidxstudy.bean.Find;

import java.util.ArrayList;

public class fas {
    private BaseQuickAdapter<Find, BaseViewHolder> ad = new BaseQuickAdapter<Find, BaseViewHolder>(R.layout.item_find_ad) {
        @Override
        protected void convert(BaseViewHolder helper, Find item) {

        }
    };

    public void bb() {
        ad.getData().clear();
        ad.getData().addAll(new ArrayList<Find>());
    }
}
