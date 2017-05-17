package com.example.dmitry.bicycle.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmitry.bicycle.R;
import com.example.dmitry.bicycle.fragment.PageFragment;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String mTabTitles[] = new String[]{"Map", "Rentals", "Profile"};
    private int[] mImageResId = {R.drawable.ic_add_location_black_24dp,
            R.drawable.ic_directions_bike_black_24dp, R.drawable.ic_help_outline_black_24dp};
    private Context context;
    private String mIcons[];

    private String mMapIcon;
    private String mBicycleIcon;
    private String mUserIcon;


    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        mMapIcon = context.getResources().getString(R.string.fa_icon_globe);
        mBicycleIcon = context.getResources().getString(R.string.fa_icon_bicycle);
        mUserIcon = context.getResources().getString(R.string.fa_icon_user);
        mIcons = context.getResources().getStringArray(R.array.fa_tabs_icons);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mTabTitles[position];
    }
    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.tab_view, null);
        TextView tv = (TextView) v.findViewById(R.id.tab_text_view);
        tv.setText(mTabTitles[position]);
        TextView iconTextView = (TextView) v.findViewById(R.id.tab_icon_text_view);
        iconTextView.setText(mIcons[position]);
//        ImageView img = (ImageView) v.findViewById(R.id.tab_image_view);
//        img.setImageResource(mImageResId[position]);
        return v;
    }
}
