package nsu.dhaka.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConnectionActivity extends AppCompatActivity {
     Intent service;
    ServiceConnection connection;
    InterfaceIPC ipc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        service=new Intent(this,MyService.class);
         connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                     ipc=InterfaceIPC.Stub.asInterface(service);
                     ipc=InterfaceIPC.Stub.asInterface(service);
                try {
                    ipc.startSong();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                try {
                    ipc.stopSong();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };

    }

    @Override
    protected void onResume() {
        bindService(service,connection, Context.BIND_AUTO_CREATE);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
    }
}
