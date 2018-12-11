package com.first_tv.IMainActivity.View.View;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.first_tv.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final static int COUNT=100;
    private Button button;
    private Timer timer;
    private Handler handler=new Handler(){
        int num=10;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
           switch (msg.what){
               case COUNT:
                   button.setText(""+num+"s");
                   if (num>=0){
                       num--;
                   }else {
                       timer.cancel();
                       break;
                   }
           }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        initView();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        //实例化Timer
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(COUNT);
            }
        },0,1000);//delay 延时  period 间隔多少毫秒

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
                timer.cancel();
            }
        },10000);

    };
}
