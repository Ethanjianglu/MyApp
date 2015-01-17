package ie.gmit.computing;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
/**
 * The class is to delete buttons
 * @author Ethan
 *
 */
public class Delete extends Activity {

	Button delete;
	Spinner spinner;
	ArrayAdapter<String> datas;
	String target;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		spinner=(Spinner)findViewById(R.id.spinne_deleter);
		delete=(Button)findViewById(R.id.delete_node);
		
		 datas=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Node.childrensName);
	        datas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        
	        spinner.setAdapter(datas);
	        
	        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

	    		

	    		@Override
	    		public void onNothingSelected(AdapterView<?> parent) {
	    			// TODO Auto-generated method stub
	    			
	    		}

	    		@Override
	    		public void onItemSelected(AdapterView<?> parent, View view,
	    				int position, long id) {
	    			// TODO Auto-generated method stub
	    			target=(String)datas.getItem(position);
	    		}
	    	});
	        
	        delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
						 Node.map.remove(target);
					 
				}
			});
	       
	       
	         
	}
}
