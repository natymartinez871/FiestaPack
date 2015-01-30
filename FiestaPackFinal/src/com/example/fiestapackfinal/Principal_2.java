package com.example.fiestapackfinal;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;



public class Principal_2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_2);

        //Aqui esta el boton principal    	
        Button button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// este es el onClick de cuando cambio de una aplicación a otra 
				
				
				Intent intent_b = new Intent("com.example.ejemplogooglemaps.ANOTHER_ACTIVITY");
		        startActivity(intent_b); 
				
			}
		});
       
        //Aqui comienza el listview de todas las tareas
            
        
        final ListView listview = (ListView) findViewById(R.id.listView1);
        String[] values = new String[] { "Tarea 1: Layouts", "Tarea 2: Bandera ",
            "Tarea 3: Mostrar un Mapa", "Tarea 4: TomaFoto", "Tarea 5: Cliente-Servidor", "Proyecto Final: JSON" };
        
     
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
          list.add(values[i]);
        }
        
 
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
            
        	listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	
                @Override
                public void onItemClick(AdapterView<?> parent, final View view,
                    int position, long id) {
                	
                	 final String item = (String) parent.getItemAtPosition(position);
                     view.animate().setDuration(1000).alpha(0)
                         .withEndAction(new Runnable() {
                           @Override
                           public void run() {
                             list.remove(item);
                             adapter.notifyDataSetChanged();
                             view.setAlpha(1);
                             if (item == "Tarea 1: Layouts") {
                              	 
                               	// Toast.makeText(getApplicationContext(),
                                 //	      "Actividad Nro" + position, Toast.LENGTH_LONG).show(); 
                                    Intent intent = new Intent(view.getContext(), Tarea1.class); 
                                 		   //getApplicationContext(), Tarea1.class);
                                    startActivity(intent);
                                    }
                             if (item == "Tarea 2: Bandera "){
                            	 Intent intent_2 = new Intent(getApplicationContext(), Tarea2.class);
                                 startActivity(intent_2);
                            	 
                             }
                           //  if (item == "Tarea 3: Fragmentos"){
                           //	 Intent intent_3 = new Intent(getApplicationContext(), );
                            //     startActivity(intent_3);
                            	 
                            // }
                             if (item == "Tarea 3: Mostrar un Mapa"){
                            	 Intent intent_4 = new Intent("com.example.ejemplogooglemaps.ANOTHER_ACTIVITY");
                 		        startActivity(intent_4);
                            	 
                             }
                             if (item == "Tarea 4: TomaFoto"){
                            	 Intent intent_5 = new Intent("com.example.foto.ANOTHER_APP_2");
                                 startActivity(intent_5);
                            	 
                             }
                             if (item == "Tarea 5: Cliente-Servidor"){
                            	 Intent intent_6 = new Intent("com.example.cliente_1.ANOTHER_APP_1");
                                 startActivity(intent_6);
                            	 
                             }
                             
                             if (item == "Proyecto Final: JSON"){
                            	 Intent intent_7 = new Intent("com.example.proyectojson.ANOTHER_APP_3"); //tengo que declarar esto donde es 
                            	 startActivity(intent_7);
                            	 
                             }
                             
                           }
                         });
                 
                }


              });
            
    }
    
     
    
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
            List<String> objects) {
          super(context, textViewResourceId, objects);
          for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
          }
        }
        
       
        @Override
        public long getItemId(int position) {
          String item = getItem(position);
          return mIdMap.get(item);
        }    
        
        @Override
        public boolean hasStableIds() {
          return true;
        }
     
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal_2, menu);
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
