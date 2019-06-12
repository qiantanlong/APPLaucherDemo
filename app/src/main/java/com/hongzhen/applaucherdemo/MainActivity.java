package com.hongzhen.applaucherdemo;

import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int taskId = getTaskId();
        String action = getIntent().getAction();
        int flags = getIntent().getFlags();
        int pid = Process.myPid();
        TextView tvTask=findViewById(R.id.tv_task);
        TextView tvPid=findViewById(R.id.tv_pid);
        tvTask.setText("taskId:"+taskId+"");
        tvPid.setText("pid:"+pid+"");
    }
}
