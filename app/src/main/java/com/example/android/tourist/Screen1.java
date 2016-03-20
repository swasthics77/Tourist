package com.example.android.tourist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Screen1 extends Fragment {

    public static int pos;
    // Array of strings storing country names
    String[] countries = new String[] {
            "KOVALAM",
            "PALOLEM BEACH",
            "BAGA",
            "VARKALA",

            "MARAVANTHE",
            "PANAMBUR",
            "ST MARY'S ISLAND",
            "DEVBAGH"

    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{

            R.drawable.kovalam,
            R.drawable.palolem,
            R.drawable.baga,
            R.drawable.varkala,
            R.drawable.maravanthe,
            R.drawable.panambur,
            R.drawable.stmary,
            R.drawable.dev

    };

    // Array of strings to store currencies
    int[] currency = new int[]{
            R.drawable.gliding,
            1,
            R.drawable.gliding,
            1,
            R.drawable.gliding,
            R.drawable.gliding,
            1,
            1




    };

    /** Called when the activity is first created. */
  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
*/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_screen1,container,false);

          // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<>();

        for(int i=0;i<8;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("txt", ""+ countries[i]);
           hm.put("cur",Integer.toString(currency[i]));
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
      //s  String[] from = { "flag","txt","cur" };
        String[] from = { "flag","txt","cur"};
        // Ids of views in listview_layout
       //s int[] to = { R.id.flag,R.id.txt,R.id.cur};
        int[] to = { R.id.flag,R.id.txt,R.id.cur1};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) v.findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(view.getContext(), Detail.class);
                String s="";
                Bundle bundle=new Bundle();

             // if (i==4)
             /* {
                  s="A turquoise-hued world of clear, warm seas and silver sand, the Bangaram Island Beach in Lakshwadeep is widely regarded as one of the top ten secret beaches in the world, where tourists are flown in by helicopters during the monsoon season. Silvery beaches and swaying coconut palms make Bangaram a heavenly escapade for travel enthusiasts. Adventure seekers can go diving, snorkelling, sailing and deep-sea fishing.";
              bundle.putInt("image",R.drawable.bangaram);
                  pos=i;
              }*/
              if(i==0)
              {
                  s="A long stretch of white sandy beach running alongside the Malabar Coast—Kovalam beach has been Kerala’s most popular destination for years. Located 16 km from Trivandrum, the beach is a union of three coves, namely the Hawa Beach, the Lighthouse beach and the Samudra Beach. Named after the lighthouse perched atop the Kurumkal Hill, the Lighthouse beach is the one most frequented by tourists.";
                  bundle.putInt("image",R.drawable.kovalam);
                  pos=i;
              }
                if(i==1)
                {
                    s="Palolem Beach, Goa Enclosed by a thick forest of coconut palms in south Goa, Palolem Beach, known for its dolphin-spotting tours, is arguably the state’s most idyllic beach. Its southern end tends to be much busier while the northern stretch is comparatively quieter being surrounded by a picturesque island that you can walk out to during low tide.";
                    bundle.putInt("image",R.drawable.palolem);
                    pos=i;
                }
                if (i==2)
                {
                    s="For those who like long sandy beaches packed with lively shacks and a party atmosphere, Baga beach in north Goa is the perfect destination. Water sports, para sailing, dolphin sightseeing, beach shacks, bars and clubs—you’ll find them all here! The crowd here is young and lively, the music loud, and the atmosphere runs from cheerful to crazy.";
                    bundle.putInt("image",R.drawable.baga);
                    pos=i;
                }
                if(i==3)
                {
                    s="Lying along the edge of stunning cliffs, Varkala Beach is located an hour’s drive north of Trivandrum in Kerala. A haven for sun-bathing and swimming, the beach offers picturesque evening views that extend over the Arabian Sea. The beach is believed to have medicinal and curative properties and a dip in its waters is believed to purge the body of all impurities.";
                    bundle.putInt("image",R.drawable.varkala);
                    pos=i;
                }

               if (i == 4) {

                    s= "Maravanthe is a village and a beach near Kundapura, Karnataka, India. Outlook travel considers it one of Karnataka's most beautiful beaches.It is about 55 kilometres (34 mi) from Udupi. NH-66 (Erstwhile NH-17) runs right next to the beach and the Suparnika River flows on the other side of the road, creating a spectacular scenery and considered only one of its kind in India. The river Souparnika, which almost touches Arabian Sea here, makes a U turn and goes westward to join the Sea only after a journey of more than 10 kilometres (6.2 mi).";
                    bundle.putInt("image",R.drawable.mara);
                    pos=i;
                }
                if (i == 6) {
                  //  intent = new Intent(view.getContext(), Detail.class);
                    s="St. Mary's Islands, also known as Coconut Island and Thonsepar, are a set of four small islands in the Arabian Sea off the coast of Malpe in Udupi, Karnataka, India. They are known for their distinctive geological formation of columnar basaltic lava (pictured).[1]\n" +
                            "\n" +
                            "Scientific studies indicate that the basalt of the St. Mary's Islands was formed by sub-aerial subvolcanic activity, because at that time Madagascar was attached to India. The rifting of Madagascar took place around 88 million years ago.";
                    bundle.putInt("image",R.drawable.st);
                   pos=i;
                }
                if (i == 7) {
                   // intent = new Intent(view.getContext(), Detail.class);
                    s="Devbagh is a mesmerizing experience for all beach lovers. A land of converging landscapes, Karwar lies on a thin strip of tropical sand that is bound by the Western Ghats on its eastern side and embraced by the Arabian Sea on the west, about 3 km away, is Devbagh. Building sandcastles, collecting colourful seashells, chasing small crabs on the sands, swimming in the sea... will all bring back your childhood days! Not to forget the endless sessions of beachcombing, beach-volleyball, or just plain lazing on a hammock watching the shimmering sea. ";
                    bundle.putInt("image",R.drawable.dev);
                    pos=i;
                }
                if (i == 5) {
                   // intent = new Intent(view.getContext(), Detail.class);
                    s="Panambur Beach which is located 10Kms for the city of Mangalore  is known for its cleanliness and safety. It is the site of New Mangalore Port. It is located in north of the Gurupura river.\n" +
                            "\n" +
                            "The city’s most visited beach, Panambur is a place where one can enjoy the breath taking view of the sunset. The beach aura warms up during the carnivals, organized by the district authorities. The festivity includes boat races, beach sports and sand sculpture contests. Besides, the kite festival, organized every year, attracts  participants from across the country and also abroad during the International Kite Festival held every 2 years at Panambur Beach Mangalore.";
                    bundle.putInt("image",R.drawable.pana);
                    pos=i;
                }
                intent.putExtra("Text",s);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }


        });
        return v;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
