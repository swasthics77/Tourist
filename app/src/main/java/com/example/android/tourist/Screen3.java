package com.example.android.tourist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Screen3 extends Fragment {
    public static int pos1;
    // Array of strings storing country names
    String[] countries = new String[] {
            "DUDHSAGAR FALLS",
            "MEENMUTTY FALLS",
            "THALAIYAR FALLS",
            "JOG FALLS",
            "VANTAWNG FALLS",
            "BAREHIPANI",
            "LANGSHIANG",
            "KUNCHIKAL",
            "NOHKALIKAI"

    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
            R.drawable.dudh,
            R.drawable.meen,
            R.drawable.thali,
            R.drawable.jog,
            R.drawable.vantwang,
            R.drawable.bareh,
            R.drawable.lang,
            R.drawable.kunchikal,
            R.drawable.noh

    };

    // Array of strings to store currencies
    String[] currency = new String[]{
            "UDUPI",
            "MANGALORE",
            "MALPE",
            "KARWAR"
    };

    /** Called when the activity is first created. */
  /*  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
*/
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_screen3,container,false);

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<>();

        for(int i=0;i<9;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("txt", ""+ countries[i]);
            //  hm.put("cur","" + currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        //s  String[] from = { "flag","txt","cur" };
        String[] from = { "flag","txt" };
        // Ids of views in listview_layout
        //s int[] to = { R.id.flag,R.id.txt,R.id.cur};
        int[] to = { R.id.flag,R.id.txt};

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



                if (i == 0) {

                    s= "Dudhsagar waterfalls or The Sea of Milk is well renowned for its spectacular trajectory. Dudhsagar is the fifth highest waterfall in India falling from a height of 1020ft. Dudhsagar falls is obviously one of the most popular falls in the country and a great tourist attraction of Goa apart from its exotic beaches. ";
                          bundle.putInt("image",R.drawable.dudh);
                    pos1=i;
                }
                if (i == 1) {
                    //  intent = new Intent(view.getContext(), Detail.class);
                    s="Meenmutty waterfalls is one of the most beautiful waterfalls, falling from a height of some 980 ft in Wayanad district of Kerala. It is one of the famous tourist spot in south India. The peak is famous for its wilderness and Meenmutty Falls is the largest and most spectacular waterfall in Wayanad. ";
                    bundle.putInt("image",R.drawable.meen);
                    pos1=i;
                }
                if (i == 2) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="Thalaiyar waterfalls also known as rat tail falls situated in Dindigul district of Tamilnadu. It is one of the biggest water fall form a height 974 ft and one of one of the tallest falls in Asia. ";
                    bundle.putInt("image",R.drawable.thali);
                    pos1=i;
                }
                if (i == 3) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The Jog water falls created by the Sharavathi river in sharavathi valley in Shimoga district of Karnataka. Its breathtaking spectacle when sharavathi river falling from a height of 829 ft.";
                    bundle.putInt("image",R.drawable.jog);
                    pos1=i;
                }
                if (i == 4) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The nick point of the waterfall is situated at a height of 751 feet in Serchhip district of Mizoram. This is largest and most famous waterfall in Mizoram.The most magnificent falls is surrounded by lush forest teeming and a vast stretch of thick bamboo forests.";
                    bundle.putInt("image",R.drawable.vantwang);
                    pos1=i;
                }
                if (i == 5) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The Barehipani is a picturesque waterfall situated in the core area of Simlipal National Park in Mayurbhanj district of Orissa. This waterfall is second highest waterfalls of India with a height of 1,309 ft. The gorgeous fall is surrounded by deep forest which again adds the wildness to its beauty. This two-tiered’ waterfall is originating near the Bay of Bengal.";
                    bundle.putInt("image",R.drawable.bareh);
                    pos1=i;
                }
                if (i == 6) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The Langshiang Falls at Meghalaya is one of the largest waterfalls in West Khasi hills district of Meghalaya. Langshiang falls formed immediately after the confluence of the diverged streams of the Kynshi river and the water falls from a height of 1,106 ft.";
                    bundle.putInt("image",R.drawable.lang);
                    pos1=i;
                }
                if (i == 8) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The Nohkalikai falls is one of the tallest waterfalls in India. It is located near Cherrapunji, one of the wettest places on Earth in East Khasi Hills district Meghalaya. The 3rd highest waterfalls in India with a height of 1100 feet. Cherrapunji is very famous for Hills, rainfall, living bridges and oranges.";
                    bundle.putInt("image",R.drawable.dev);
                    pos1=i;
                }
                if (i == 7) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The Kunchikal falls is the highest waterfalls in India and second highest in Asia. The tallest waterfall of India with a height of 1,493 ft is located near Agumbe in Shimoga district of Karnatak. Agumbe valley is among the places in India that receive very heavy rainfall and it has the only permanent rain forest research station in India.";
                    bundle.putInt("image",R.drawable.kunchikal);
                    pos1=i;
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
