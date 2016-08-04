package com.example.assistant;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appusageactivity extends Activity {

    TextView textview;
    StringBuffer sb;
    private int max=0;
    public static String mostused;
    public static Map<Integer,String> mapie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appusageactivity);
        textview=(TextView)findViewById(R.id.textview_appusage);
        getPakagesInfoUsingHashMap();
    }



    public void getPakagesInfoUsingHashMap() {
        sb = new StringBuffer();
        final PackageManager pm = getPackageManager();
        // get a list of installed apps.
        List<ApplicationInfo> packages = pm.getInstalledApplications(0);
         mapie=new HashMap<Integer, String>();
        // loop through the list of installed packages and see if the selected
        // app is in the list
        for (ApplicationInfo packageInfo : packages) {
            // get the UID for the selected app
           int UID = packageInfo.uid;
            String package_name = packageInfo.packageName;
            ApplicationInfo app = null;
            try {
                app = pm.getApplicationInfo(package_name, 0);
            } catch (PackageManager.NameNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String name = (String) pm.getApplicationLabel(app);
            Drawable icon = pm.getApplicationIcon(app);
            // internet usage for particular app(sent and received)
            double received = (double) TrafficStats.getUidRxBytes(UID)

                    / (1024 * 1024);
            double send = (double) TrafficStats.getUidTxBytes(UID)
                    / (1024 * 1024);
            double total = received + send;

            if(total>0)

            {   if (total>max){
                max=(int)total;
                  }
                mapie.put((int)total,name);
                sb.append("\nApp Name:--- " + name + " \nTotal Data:--- "
                        + total);
                sb.append("\n----------------------------------");

            }
              mostused= mapie.get(max);
              textview.setText(sb);
        }

    }




}
