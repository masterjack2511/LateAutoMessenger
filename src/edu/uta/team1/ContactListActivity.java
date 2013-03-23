package edu.uta.team1;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactListActivity extends ListActivity {
	private ArrayList<String> contacts;
	
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    contacts = getIntent().getExtras().getStringArrayList("contacts");
	    loadContacts();
	  }
	  
	  public void onListItemClick(ListView parent, View v, int position, long id)
	  {

	  }
	  
	  private void loadContacts(){
		  setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts));
	  }
}
