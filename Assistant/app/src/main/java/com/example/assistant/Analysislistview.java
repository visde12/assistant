package com.example.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Analysislistview extends Activity {
	ContactHelper db = new ContactHelper(this);
	List<Contact> list;

    TextView textview;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.analysis);
		// drop this database if already exists
        textview=(TextView)findViewById(R.id.textview_call1);
		StringBuffer sb= new StringBuffer();
		// get all books
		list = db.getAllContacts();
        db.getIncomming();

		for (int i = 0; i < list.size(); i++) {
			sb.append("\nDate:--- " + list.get(i).getDay()
					+ " \nCall duration in sec :--- " + list.get(i).getDuration());
			sb.append("\n----------------------------------");
		}
		textview.setText(sb);

	}


}
