package com.example.assistant;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

public class Messageactivity extends Activity {
ContactHelper sh;
    TextView tv;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messageactivity);
        sh= new ContactHelper(this);
        tv=(TextView)findViewById(R.id.allabout);
        sb= new StringBuffer();
        getOwnername();
    }
    public void getOwnername(){

        Cursor c = this.getContentResolver().query(ContactsContract.Profile.CONTENT_URI, null, null, null, null);
        int count = c.getCount();
        String[] columnNames = c.getColumnNames();
        boolean b = c.moveToFirst();
        int position = c.getPosition();
        if (count == 1 && position == 0) {
            for (int j = 0; j < columnNames.length; j++) {
                String columnName = columnNames[j];
                String columnValue = c.getString(c.getColumnIndex(columnName));

            }
        }
        c.close();
        sb.append("\nName:--- " + " \nMost Incomming calls from:--- "
                 + " \nMost Incomming calls TO:--- " + "Not implemented Algo"
                + " \nMost used app:--- " + Appusageactivity.mostused);
        sb.append("\n----------------------------------");
        c.close();
        tv.setText(sb);

    }

}
