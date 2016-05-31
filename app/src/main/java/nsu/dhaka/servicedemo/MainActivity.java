package nsu.dhaka.servicedemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent=new Intent(this,MyService.class);
        startService(intent);

    }

    @Override
    protected void onDestroy() {
      stopService(intent);
        super.onDestroy();
    }
}
