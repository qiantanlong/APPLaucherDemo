package com.hongzhen.applaucherdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        int taskId = getTaskId();
        String action = getIntent().getAction();
        int flags = getIntent().getFlags();
        int pid = Process.myPid();
        TextView tvTask=findViewById(R.id.tv_task);
        TextView tvPid=findViewById(R.id.tv_pid);
        tvTask.setText("taskId:"+taskId+"");
        tvPid.setText("pid:"+pid+"");
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
