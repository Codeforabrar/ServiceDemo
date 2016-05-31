package nsu.dhaka.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    MediaPlayer player;
    Thread thread;
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    private final InterfaceIPC.Stub binder=new InterfaceIPC.Stub() {
        @Override
        public void startSong() throws RemoteException {
            player=MediaPlayer.create(getApplicationContext(),R.raw.allrise);

            player.start();
        }
        @Override
        public void stopSong() throws RemoteException {
            player.release();
        }
    };
    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
    }
}
