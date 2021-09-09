package com.example.demo.fragTest2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.demo.R;

public class FragStackTest extends AppCompatActivity implements ABlankFragment.PassData {

    private ABlankFragment fragmentA;
    private BBlankFragment fragmentB;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_stack_test);

        textView = findViewById(R.id.frag2_tv01);

        fragmentA = ABlankFragment.newInstance("default params", new ABlankFragment.MyClickListener() {
            @Override
            public void clickCB() {
                if (fragmentB == null) {
                    fragmentB = BBlankFragment.newInstance();
                }
                // 老版 fragment android.app.Fragment
//                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                // 新版 fragment androidx.fragment.app.Fragment
                Fragment fragment = getSupportFragmentManager().findFragmentByTag("a");
                // 保留fragment 状态： 通过tag 找到，先hide 然后再 add 新的 fragment
                // 不保留fragment 状态： 直接replace
                // 添加到 返回栈中： addToBackStack
                // replace 不要和 addToBackStack 一起使用，因为返回之后 原来fragment 对象没有了。
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().hide(fragment).add(R.id.frag2_container, fragmentB).addToBackStack(null).commitAllowingStateLoss();
//                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.frag2_container, fragmentB).commitAllowingStateLoss();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frag2_container, fragmentB).commitAllowingStateLoss();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag2_container, fragmentB).addToBackStack(null).commitAllowingStateLoss();
//                  getFragmentManager().beginTransaction().replace(R.id.frag2_container, fragmentB).commitAllowingStateLoss();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frag2_container, fragmentB).commitAllowingStateLoss();
                }
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.frag2_container, fragmentA, "a").commitAllowingStateLoss();
    }

    public void updateTv(String str) {
        textView.setText(str);
    }

    @Override
    public void passStr(String str) {
        updateTv(str);
    }
}