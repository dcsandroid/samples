package in.dcs.com.boundservice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.TextureView;
import android.os.IBinder;
import android.content.Intent;
import android.content.ComponentName ;
import android.content.ServiceConnection ;
import android.widget.TextView;

import in.dcs.com.boundservice.MyService.MyLocalBinder ;

public class MainActivity extends AppCompatActivity {

    MyService buckysService;
    boolean isBound = false ;

    public void showTime(View view) {
        String currentTime = buckysService.getCurrentTime() ;
        TextView large = (TextView) findViewById(R.id.serv_text) ;
        large.setText(currentTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this, MyService.class) ;
        bindService(i, boundService, Context.BIND_AUTO_CREATE) ;
    }

    private ServiceConnection boundService = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyLocalBinder binder = (MyLocalBinder) iBinder ;
            buckysService = binder.getService() ;
            isBound = true ;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false ;
        }
    };
}
