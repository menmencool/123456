package com.partscloud.www;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.partscloud.www.fragment.ChartFragment;
import com.partscloud.www.fragment.HomeFragment;
import com.partscloud.www.fragment.MoreFragment;
import com.partscloud.www.fragment.ProjectFragment;
import com.partscloud.www.fragment.UserFragment;
import com.partscloud.www.utils.DeviceInfoUtil;
import com.partscloud.www.utils.FileUtil;

public class MainActivity extends FragmentActivity {
    public static final String TAG = "MainActivity";
    private FragmentTabHost tab_host;
    private RadioGroup bottom_bar;
    /**
     * 定义数组来存放Fragment界面
     */
    private Class fragments[] = {HomeFragment.class, ProjectFragment.class,
            UserFragment.class, MoreFragment.class, ChartFragment.class};

    private int fragmentExtra = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExitApplication.getInstance().addActivity(this);
        setContentView(R.layout.home_activity);
        tab_host = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tab_host.setup(this, getSupportFragmentManager(), R.id.home_fragment);
        int count = fragments.length;
        for (int i = 0; i < count; i++) {
            TabSpec tabSpec = tab_host.newTabSpec(i + "").setIndicator(i + "");
            tab_host.addTab(tabSpec, fragments[i], null);
        }
        bottom_bar = (RadioGroup) findViewById(R.id.tab_rg_menu);
//		bottom_bar.getBackground().setAlpha(220);
        Intent intent = getIntent();
        int fragment = intent.getIntExtra("fragment", -1);
        Log.i(TAG, "fragment:" + fragment);
        switch (fragment) {
            case 0:
                tab_host.setCurrentTab(0);
                bottom_bar.check(R.id.tab_rb_0);
                break;
            case 1:
                tab_host.setCurrentTab(1);
                bottom_bar.check(R.id.tab_rb_1);
                break;
            case 2:
                tab_host.setCurrentTab(2);
                bottom_bar.check(R.id.tab_rb_2);
                break;
            case 3:
                tab_host.setCurrentTab(3);
                bottom_bar.check(R.id.tab_rb_3);
                break;
            default:
                tab_host.setCurrentTab(0);
                bottom_bar.check(R.id.tab_rb_0);
                break;
        }
        bottom_bar.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_rb_0:
                        tab_host.setCurrentTab(0);
                        break;
                    case R.id.tab_rb_1:
                        tab_host.setCurrentTab(1);
                        break;
                    case R.id.tab_rb_2:
                        if (FileUtil.getToken(getApplicationContext()) != null) {
                            tab_host.setCurrentTab(2);
                        } else {
                            Intent register = new Intent(MainActivity.this,
                                    RegisterActivity.class);
                            register.putExtra("main", 1);
                            startActivityForResult(register, 10);
                        }
                        break;
                    case R.id.tab_rb_3:
                        tab_host.setCurrentTab(3);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10 && resultCode == RESULT_OK) {
            fragmentExtra = data.getIntExtra("fragment", -1);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String deviceInfo = DeviceInfoUtil.getDeviceInfo(getApplicationContext());
        Log.i(TAG, "deviceInfo:" + deviceInfo);
    }

    @Override
    protected void onPostResume() {
        if (fragmentExtra == 2) {
            tab_host.setCurrentTab(fragmentExtra);
            fragmentExtra = -1;
        }
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                ExitApplication.getInstance().exit();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mScreenObserver.stopScreenStateUpdate();
    }
}
