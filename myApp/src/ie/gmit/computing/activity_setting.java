package ie.gmit.computing;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * The class is to set the preference values
 * @author Ethan
 *
 */
public class activity_setting extends Activity{

	EditText ship;
	EditText person;
	EditText email;
	Button save;
	
	String shipName;
	String personName;
	String emaill;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		ship=(EditText)findViewById(R.id.name);
		person=(EditText)findViewById(R.id.person_name);

		email=(EditText)findViewById(R.id.email);
		
		save=(Button)findViewById(R.id.Save_info);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ship.getText().toString()!="" && person.getText().toString()!="" &&email.getText().toString()!=""){
					
					SharedPreferences sharedPreferences= getSharedPreferences("new.txtx", 0);
					
					Editor editor=sharedPreferences.edit();
					
					editor.putString("ship", ship.getText().toString());
					editor.putString("person", person.getText().toString());
					editor.putString("email", email.getText().toString());
					
					editor.commit();
				}
			}
		});

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		SharedPreferences sharedPreferences= getSharedPreferences("new.txtx", 0);
		
		Editor editor=sharedPreferences.edit();
		
		shipName=sharedPreferences.getString("ship", "null");
		personName=sharedPreferences.getString("person", "null");

		emaill=sharedPreferences.getString("email", "null");
		
		ship.setText(shipName);
        person.setText(personName);
        email.setText(emaill);
	}
}
