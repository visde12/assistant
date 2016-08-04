package com.example.assistant;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.TextView;

import java.util.Date;

public class Callhistoryactivity extends Activity {

	TextView textView = null;
	Cursor managedCursor;
	ContactHelper db;

	public static StringBuffer sb;
	private long outgoing = 0, incomming = 0, missed = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.callhistory);
		textView = (TextView) findViewById(R.id.textview_call);


			getCallDetails();

	}

	private void getCallDetails() {
		sb = new StringBuffer();
		db = new ContactHelper(this);
		db.onUpgrade(db.getWritableDatabase(), 1, 2);
		String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
		managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null,
				null, null, strOrder);
		/* Query the CallLog Content Provider */

		int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
		int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
		int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
		int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
		sb.append("Call Log :");
		while (managedCursor.moveToNext()) {
			String phNum = managedCursor.getString(number);
			String callTypeCode = managedCursor.getString(type);
			String strcallDate = managedCursor.getString(date);
			Date callDate = new Date(Long.valueOf(strcallDate));
			String num=callDate.toString();
			String month =num.substring(4, 7);
			String day= num.substring(8,10);
			String callDuration = managedCursor.getString(duration);
			String callType = null;
			int callcode = Integer.parseInt(callTypeCode);
			switch (callcode) {
				case CallLog.Calls.OUTGOING_TYPE:
					callType = "Outgoing";
					break;
				case CallLog.Calls.INCOMING_TYPE:
					callType = "Incoming";
					break;
				case CallLog.Calls.MISSED_TYPE:
					callType = "Missed";
					break;
			}
			if(callType.equalsIgnoreCase("Outgoing")){
				outgoing+=Integer.parseInt(callDuration);
			}else if(callType.equalsIgnoreCase("Incoming")){
				incomming+=Integer.parseInt(callDuration);
			} else {
				missed+=Integer.parseInt(callDuration);
			}


			db.createContact(new Contact(phNum, callType, day, month, callDuration));
			sb.append("\nPhone Number:--- " + phNum + " \nCall Type:--- "
					+ callType + " \nCall Date:--- " + callDate
					+ " \nCall duration in sec :--- " + callDuration);
			sb.append("\n----------------------------------");
		}
		textView.setText(sb);
		managedCursor.close();

	}


}
