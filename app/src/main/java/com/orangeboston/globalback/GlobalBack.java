package com.orangeboston.globalback;

import android.os.Message;

import com.blankj.utilcode.util.ToastUtils;
import com.levine.abllib.AblStepBase;
import com.levine.abllib.AblSteps;
import com.levine.abllib.utils.AblViewUtil;

public class GlobalBack extends AblStepBase {

    @Override
    public void onStep(int step, Message msg) {
        switch (step) {
            case AblSteps.STEP_1:
                AblViewUtil.back();
//                ToastUtils.showShort("执行：返回");
                break;
        }
    }
}
