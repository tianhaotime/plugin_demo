package com.example.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.example.common.StartWebActivity;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.cache.CacheInterceptor;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.root);

        tv = findViewById(R.id.tv);
        tv.setOnClickListener(view -> {
            Log.d("aking", "click ---");
            startActivity(new Intent(this,SeconedActivity2.class));
        });
    }
    private void getRes() {
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
//            @NonNull
//            @Override
//            public Response intercept(@NonNull Chain chain) throws IOException {
//                chain.proceed();
//                return null;
//            }
//        }).addInterceptor(new CacheInterceptor(new Cache(new File(""),1024))).addNetworkInterceptor().build();
//        Request request = new Request.Builder().build();
//        client.newCall().execute();
 /*
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
//        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        Log.d("aking", "click ---"+cl.toString());
//        Log.d("aking", "click -systemClassLoader--"+systemClassLoader.toString());
//        Log.d("aking", "click -systemClassLoader--"+(systemClassLoader==cl));
        try {
            String fullName = "META-INF/services/"+(StartWebActivity.class.getName());
            Enumeration<URL> systemResources = ClassLoader.getSystemResources(fullName);
            Log.d("aking", "click 11---"+systemResources.toString());
            Log.d("aking", "click 11---"+systemResources.hasMoreElements());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            String fullName = "META-INF/services/"+(StartWebActivity.class.getName());
            Log.d("aking", "click fullName---"+fullName);
            Enumeration<URL> clResources = cl.getResources(fullName);
            Log.d("aking", "click 22---"+clResources.toString());
            Log.d("aking", "click 22---"+clResources.hasMoreElements());
            Log.d("aking", "click 22---"+clResources.nextElement().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }

    private void startWeb() {
        Iterator<StartWebActivity> iterator = MyServiceLoader.load(StartWebActivity.class).iterator();
        if (iterator.hasNext()) {
            iterator.next().startWebActivity(this, "https://www.jianshu.com/p/bce29536a602", "");
        }
    }

    void blue2() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        Log.d("aking", "adapter ---" + adapter);
//        if (adapter != null) {
//            adapter.isEnabled();
//        }

        List<?> l = new ArrayList<Button>();


    }

    void _m() {
        Log.d("aking", "start--  ");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, 3000);

        handler.notifyAll();
        Log.d("aking", "end ---");

        TextView tv = findViewById(R.id.tv);
        tv.setOnClickListener(view -> {
            Log.d("aking", "click ---");
        });
    }

    void _q() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                _o();
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    void _o() {
        for (int i = 0; i < 1000; i++) {
            Log.d("aking", "i = = =" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Intent i = new Intent();
        bindService(i, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                IMyAidlInterface asInterface = IMyAidlInterface.Stub.asInterface(service);
                try {
                    asInterface.getBook(new Book());
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }


}