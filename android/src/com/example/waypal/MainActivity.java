package com.example.waypal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MainActivity extends Activity {

	ListView listView;
	MapFragment mapFragment;
	POIFragment poiFragment;
	GoogleMap map;
	Firebase myFirebaseRef;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
			poiFragment = (POIFragment) getFragmentManager().findFragmentById(R.id.pois);
			System.out.println(mapFragment);
		}
		
		// Setup Firebase listener
		Firebase.setAndroidContext(this);
		myFirebaseRef = new Firebase("https://waypal.firebaseio.com/");
		myFirebaseRef.child("trip1").addValueEventListener(new ValueEventListener() {

			  @Override
			  public void onDataChange(DataSnapshot snapshot) {
			    System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
			  }

			  @Override public void onCancelled(FirebaseError error) { }

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
//		Intent intent = getIntent();
//		String message = intent.getStringExtra(HomeActivity.EXTRA_MESSAGE);
//		
//		TextView textView = new TextView(this);
//		textView.setTextSize(40);
//		textView.setText(message);
		
		//setContentView(textView);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}