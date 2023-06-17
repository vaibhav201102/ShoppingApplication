package internship.app.commercial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class chat extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        getSupportActionBar().hide();

        tabLayout = findViewById(R.id.chat_tab);
        viewPager = findViewById(R.id.chat_pager);

        tabLayout.post(() -> tabLayout.setupWithViewPager(viewPager));
        //FragmentManager manager = getSupportFragmentManager();
        //manager.beginTransaction().replace(R.id.chat_pager,Chatfragment()).commit();
        viewPager.setAdapter(new Tabpageradapter(getSupportFragmentManager()));

    }

    private class Tabpageradapter extends FragmentPagerAdapter {
        public Tabpageradapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chat";
                case 1:
                    return "status";
                case 2:
                    return "Call";
                default:
                    return "Other";
            }
            //return super.getPageTitle(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new chatfrag();
                case 1:
                    return new statusfrag();
                case 2:
                    return new callfrag();
                default:
                    return new callfrag();
            }

            //return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}