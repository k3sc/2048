package com.koko.koko2048.test;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author kkexc
 * 2020-4-20 13:35:50
 */
public class MainService extends Service {
    private static Context contextOfApplication;

    public MainService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        contextOfApplication = this;
        ConnectionManager.startAsync(this);
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public static Context getContextOfApplication() {
        return contextOfApplication;
    }


}
