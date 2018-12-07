package com.luoyang.myandroidxstudy.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具
 *
 * @author LuoYang
 */
public class ToastUtil {
    private Toast mToast;

    private ToastUtil() {
    }

    private static class ToastUtilHandle {
        private static final ToastUtil INSTANCE = new ToastUtil();
    }

    public static ToastUtil getInstance() {
        return ToastUtilHandle.INSTANCE;
    }

    @SuppressLint("ShowToast")
    public void init(Context context) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), "", Toast.LENGTH_SHORT);
        }
    }

    public void show(String msg) {
        if (mToast == null) {
            throw new IllegalStateException("请初调用init始化");
        }
        mToast.setText(msg);
        mToast.show();
    }
}
