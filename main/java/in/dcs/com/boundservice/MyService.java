package in.dcs.com.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder iBinder = new MyLocalBinder() ;


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder ;
    }

    public String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.US) ;
        return (sdf.format(new Date())) ;
    }

    public class MyLocalBinder extends Binder {

        public MyService getService () {
            return MyService.this ;
        }

    }

}
