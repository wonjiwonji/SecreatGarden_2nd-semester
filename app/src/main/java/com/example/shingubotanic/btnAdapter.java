package com.example.shingubotanic;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class btnAdapter extends FragmentStateAdapter {

    public int mCount;

    public btnAdapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }

    @NonNull

    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        int index = getRealPosition(position);

        if(index==0) return new btnfrag_1();
        else return new btnfrag_1();
    }


    @Override
    public int getItemCount() {
        return 2000;
    }

    public int getRealPosition(int position) {
        return position % mCount;
    }
}
