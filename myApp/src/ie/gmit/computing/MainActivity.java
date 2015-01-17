package ie.gmit.computing;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

/**
 * This class contains buttons to go to another pages
 * @author Ethan
 *
 */
public class MainActivity extends Activity {
/**
 * The set up button(add,search,camera,delete,settings)
 */
	Button add;
	Button search;
	Button camera;
	Button delete;
	Button settings;
	ImageView img;
	static int c=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		add = (Button) findViewById(R.id.add);
		search = (Button) findViewById(R.id.search);
		camera = (Button) findViewById(R.id.can);
		img = (ImageView) findViewById(R.id.imageView);
		delete = (Button) findViewById(R.id.delete);
		settings = (Button) findViewById(R.id.setings);

		settings.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						activity_setting.class);
				startActivity(intent);
			}

		});

		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), Add.class);
				startActivity(intent);
			}

		});

		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						Delete.class);
				startActivity(intent);
			}
		});
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),
						Search.class);
				startActivity(intent);

			}
		});

		camera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, 111);// 打开照相机
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 111 && resultCode == RESULT_OK) {
			Bundle bundle = data.getExtras();
			Bitmap bitmap = (Bitmap) bundle.get("data");
			img.setImageBitmap(bitmap);
			
			FileOutputStream fos=null;
			FileOutputStream fos1=null;
			BufferedWriter bb=null;
			try {
				fos=getApplicationContext().openFileOutput("img_"+c+".png", Context.MODE_MULTI_PROCESS);
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
				fos1=getApplicationContext().openFileOutput("gps_"+c+".txt", Context.MODE_MULTI_PROCESS);
				bb=new BufferedWriter(new OutputStreamWriter(fos1));
				bb.write(gps());
				bb.newLine();
				Date date=new Date(System.currentTimeMillis());
				bb.write(date.toString());
				fos.close();
				fos1.close();
				c++;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**This method is used to obtain the GPS and time.
	 * 
	 * @return
	 */
	public String gps() {
        LocationManager locationManager;
        String serviceName = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getSystemService(serviceName);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(criteria, true);

        Location location = locationManager.getLastKnownLocation(provider);
        String gps = updateWithNewLocation(location);
        locationManager.requestLocationUpdates(provider, 2000, 10, locationListener);
        return gps;
    }

    public final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            updateWithNewLocation(location);
        }

        public void onProviderDisabled(String provider) {
            updateWithNewLocation(null);
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };

/**
 * Update the lastest version of location
 * @param location
 * @return
 */
    public String updateWithNewLocation(Location location) {
        if (location != null) {
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            return "Latitude:" + lat + " Longitude:" + lng;
        } else
            return "cannot get GPS";
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
