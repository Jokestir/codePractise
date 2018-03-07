package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class WordPageAdapter extends FragmentPagerAdapter {

    public int NUMBER_OF_TABS = 4;

    static String[] tabs_name = {"Numbers","Family","Color","Phrases"};
    public WordPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new NumberFragment();
        else if (position == 1)
            return new FamilyFragment();
        else if (position == 2)
            return new ColorFragment();
        else
            return new PhrasesFragment();
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs_name[position];
    }
}
