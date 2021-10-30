package com.orangeboston.globalback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.levine.abllib.AblConfig;
import com.levine.abllib.AblStepHandler;
import com.levine.abllib.AblSteps;
import com.levine.abllib.utils.AblUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("orange", "onCreate");
        AblConfig.Builder()
                .setLogTag("GlobalBack")
                .setStepMsgDelayMillis(15)
                .setFindViewCountDownInterval(200)
                .setFindViewMillisInFuture(10000)
                .build().init();
        AblStepHandler.getInstance().initStepClass(new GlobalBack());

        findViewById(R.id.tv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("orange", "onResume");
        if (AblUtil.isAccessibilityServiceOpen(MainActivity.this)) {
            AblStepHandler.getInstance().setStop(false);
            AblStepHandler.sendMsg(AblSteps.STEP_1);
            onBackPressed();
        } else {
            AblUtil.openAccessibilitySettings();
            ToastUtils.showLong("请先开启辅助服务");
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}