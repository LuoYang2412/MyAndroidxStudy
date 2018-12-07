package com.luoyang.myandroidxstudy.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.luoyang.myandroidxstudy.R;
import com.luoyang.myandroidxstudy.util.ToastUtil;

/**
 * 首页
 *
 * @author LuoYang
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private NavHostFragment currentNavHostFragment;
    private NavHostFragment findFragmentHost;
    private NavHostFragment boughtFragmentHost;
    private NavHostFragment meFragmentHost;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        findFragmentHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHost_fragment_find);
        boughtFragmentHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHost_fragment_bought);
        meFragmentHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHost_fragment_me);
        getSupportFragmentManager().beginTransaction().show(findFragmentHost).hide(boughtFragmentHost).hide(meFragmentHost).commit();
        currentNavHostFragment = findFragmentHost;

        currentNavHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHost_fragment_find);
        if (currentNavHostFragment != null) {
            NavigationUI.setupWithNavController(toolbar, currentNavHostFragment.getNavController());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(currentNavHostFragment);
        switch (item.getItemId()) {
            case R.id.navigation_find:
                fragmentTransaction.show(findFragmentHost).commit();
                currentNavHostFragment = findFragmentHost;
                NavigationUI.setupWithNavController(toolbar, currentNavHostFragment.getNavController());
                invalidateOptionsMenu();
                return true;
            case R.id.navigation_bought:
                fragmentTransaction.show(boughtFragmentHost).commit();
                currentNavHostFragment = boughtFragmentHost;
                NavigationUI.setupWithNavController(toolbar, currentNavHostFragment.getNavController());
                invalidateOptionsMenu();
                return true;
            case R.id.navigation_me:
                fragmentTransaction.show(meFragmentHost).commit();
                currentNavHostFragment = meFragmentHost;
                NavigationUI.setupWithNavController(toolbar, currentNavHostFragment.getNavController());
                invalidateOptionsMenu();
                return true;
            default:
        }
        return false;
    }

    private long oneTime = 0L;

    @Override
    public void onBackPressed() {
        Fragment currentFragment = currentNavHostFragment.getChildFragmentManager().getPrimaryNavigationFragment();
        if (currentFragment instanceof FindFragment || currentFragment instanceof BoughtFragment || currentFragment instanceof MeFragment) {
            long towTime = System.currentTimeMillis();
            long exitTime = 1000;
            if (towTime - oneTime < exitTime) {
                super.onBackPressed();
            } else {
                ToastUtil.getInstance().show("再按一次退出");
                oneTime = towTime;
            }
        } else {
            currentNavHostFragment.getNavController().navigateUp();
        }
    }
}
