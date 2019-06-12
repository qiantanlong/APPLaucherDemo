package com.hongzhen.applaucherdemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//ceshi.jks密码是123456
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
// 避免从桌面启动程序后，会重新实例化入口类的activity
// 判断当前activity是不是所在任务栈的根
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }
        int taskId = getTaskId();
        String action = getIntent().getAction();
        int flags = getIntent().getFlags();
        int pid = Process.myPid();
        TextView tvTask=findViewById(R.id.tv_task);
        TextView tvPid=findViewById(R.id.tv_pid);
        tvTask.setText("taskId:"+taskId+"");
        tvPid.setText("pid:"+pid+"");
        new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==1){
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                }
            }
        }.sendEmptyMessageDelayed(1,2000);
    }
}
