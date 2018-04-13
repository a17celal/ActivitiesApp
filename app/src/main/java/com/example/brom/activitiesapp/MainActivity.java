package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};

    //private Mountains m = new Mountains("Matterhorn", "Alps", 4478);

    private List<Mountains> namnen = new ArrayList<Mountains>();

    // Create ArrayLists from the raw data above and use these lists when populating your ListView.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.

        for (int i=0; i<mountainNames.length;i++){
             Mountains m = new Mountains(mountainNames[i],mountainLocations[i], mountainHeights[i]);
            namnen.add(m);
        }

        Mountains b = new Mountains("Keb", "swe", 2117);
        namnen.add(b);

        List<String> listData = new ArrayList<String>(Arrays.asList(mountainNames));

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.list_item_textview,
                R.id.my_item_textview, namnen);

        ListView myListView = (ListView)findViewById(R.id.my_listview);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Mountains n = namnen.get(position);
                Toast.makeText(MainActivity.this,n.fakta(), Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this, mountainNames[position] + mountainHeights[position]  + mountainLocations[position], Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(), MountainDetailsActivity.class);
                intent.putExtra("mountainnames", n.toString());
                intent.putExtra("mountainheights", n.hojd());
                intent.putExtra("mountainlocations", n.plats());
                startActivity(intent);




            }
        });
        myListView.setAdapter(adapter);



    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Céline", "nu pausar main activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Céline", "nu startar main activity efter en paus");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Céline", "nu startar main activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Céline", "nu stoppar main activity");
    }


}
