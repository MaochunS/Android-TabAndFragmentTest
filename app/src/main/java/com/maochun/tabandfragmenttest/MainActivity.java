package com.maochun.tabandfragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private Tab1Fragment mTab1Fragment = new Tab1Fragment();
    private Tab2Fragment mTab2Fragment = new Tab2Fragment();
    private Tab3Fragment mTab3Fragment = new Tab3Fragment();


    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mTabLayout.getTabAt(position).select();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private TabLayout.OnTabSelectedListener mTabSelListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {

            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab_main);
        mTabLayout.addOnTabSelectedListener(mTabSelListener);
        mViewPager = findViewById(R.id.viewPage_main_tab);
        mViewPager.addOnPageChangeListener(mPageChangeListener);
        mViewPager.setAdapter(new TheFragmentAdapter(getSupportFragmentManager()));
    }


    public class TheFragmentAdapter extends FragmentPagerAdapter {

        public TheFragmentAdapter(FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return mTab1Fragment;
                case 1:
                    return mTab2Fragment;
                case 2:
                    return mTab3Fragment;

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }


    }
}
