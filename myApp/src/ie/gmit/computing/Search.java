package ie.gmit.computing;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * This class is to show the parent node and its children in the form of spinner
 * @author Ethan
 *
 */
public class Search extends Activity {

	Spinner spinner;
	Spinner child;
	ArrayAdapter<String> datas;
	
	ArrayAdapter<String> childdatas;
	Button save;
	List<String> children=new ArrayList<String>();
	String parentName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		save=(Button)findViewById(R.id.save);
		spinner=(Spinner)findViewById(R.id.parent);
		child=(Spinner)findViewById(R.id.node);
		
		datas=new ArrayAdapter<String>(Search.this, android.R.layout.simple_dropdown_item_1line, Node.childrensName);
		datas.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		spinner.setAdapter(datas);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				parentName=(String)datas.getItem(position);
				
				getChildren(parentName);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Get the children of a parent
	 * @param parent
	 */
	public void getChildren(String parent){
		Node node=Node.map.get(parent);
		
		List<Node> nodes=node.getChildrens();
		
		for(int i=0;i<nodes.size();i++){
			children.add(nodes.get(i).getTitle());
		}
		
		childdatas=new ArrayAdapter<String>(Search.this, android.R.layout.simple_dropdown_item_1line,children);
		childdatas.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		child.setAdapter(childdatas);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
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
