package com.first_tv.IMainActivity.View.View;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.first_tv.IMainActivity.View.View.Fragment.SNSFragment;
import com.first_tv.IMainActivity.View.View.Fragment.codFragment;
import com.first_tv.IMainActivity.View.View.Fragment.homeFragment;
import com.first_tv.IMainActivity.View.View.Fragment.myFragment;
import com.first_tv.IMainActivity.View.View.Fragment.vodFragment;
import com.first_tv.R;

public class HomeActivity extends FragmentActivity implements View.OnClickListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    Button myButton;
    Button SNSButton;
    Button vodButton;
    Button codButton;
    Button homebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentManager=getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_frame,new homeFragment());
        findbyID();
        fragmentTransaction.commit();

    }

    private void findbyID() {
        homebutton = findViewById(R.id.homeButton);
        codButton = findViewById(R.id.codButton);
        vodButton = findViewById(R.id.vodButton);
        SNSButton = findViewById(R.id.SNSButton);
        myButton = findViewById(R.id.myButton);
        homebutton.setOnClickListener(this);
        codButton.setOnClickListener(this);
        vodButton.setOnClickListener(this);
        SNSButton.setOnClickListener(this);
        myButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.homeButton:
                FragmentTransaction fr1 = fragmentManager.beginTransaction();
                fr1.replace(R.id.main_frame,new homeFragment()).commit();
                break;
            case R.id.codButton:
                FragmentTransaction fr2 = fragmentManager.beginTransaction();
                fr2.replace(R.id.main_frame,new codFragment()).commit();
                break;
            case R.id.vodButton:
                FragmentTransaction fr3 = fragmentManager.beginTransaction();
                fr3.replace(R.id.main_frame,new vodFragment()).commit();
                break;
            case R.id.SNSButton:
                FragmentTransaction fr4 = fragmentManager.beginTransaction();
                fr4.replace(R.id.main_frame,new SNSFragment()).commit();
                break;
            case R.id.myButton:
                FragmentTransaction fr5 = fragmentManager.beginTransaction();
                fr5.replace(R.id.main_frame,new myFragment()).commit();
                break;

        }

    }
}
