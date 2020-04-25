package com.koko.koko2048.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        intent = new Intent(context, MainService.class);
        context.startService(intent);

    }
}
