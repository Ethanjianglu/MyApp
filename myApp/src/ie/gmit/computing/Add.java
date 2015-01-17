package ie.gmit.computing;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * The class is to add a new node
 * @author Ethan
 *
 */
public class Add extends Activity {

	 Button add;
	Spinner spinner;
	ArrayAdapter<String> datas;
	List<String> list=new ArrayList<String>();
	EditText nodeName;
	String parentname;
	Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        model=new Model();
       
        
        spinner=(Spinner)findViewById(R.id.spinner);
        add=(Button)findViewById(R.id.add);
        nodeName=(EditText)findViewById(R.id.nodeName);
        
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
			parentname=(String)datas.getItem(position);
		}
	});
      add.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(nodeName.getText().toString()!=""){
				
				Node parentNode=Node.map.get(parentname);
				Node node=new Node(nodeName.getText().toString(),parentNode);
				parentNode.addNode(node);
				//Search.list.add(node);
			}
		}
	});
    }
}
