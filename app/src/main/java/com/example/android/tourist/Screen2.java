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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Screen2 extends Fragment {

    public static int position;
    // Array of strings storing country names
    String[] countries = new String[] {
            "MANALI",
            "NAINITAL",
            "MATHERAN",
            "SHIMLA",
            "MUNNAR",
            "OOTY",
            "DARJEELING",
            "KODAIKANAL",
            "KODACHADRI"

    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] flags = new int[]{
            R.drawable.manali,
            R.drawable.nainital,
            R.drawable.matheran,
            R.drawable.shimla,
            R.drawable.munnar,
            R.drawable.ooty,
            R.drawable.darjeeling,
            R.drawable.kodaikanal,
            R.drawable.kodachadri

    };

    // Array of strings to store currencies
    int[] currency = new int[]{
            R.drawable.images,
            R.drawable.images,
            1,
            R.drawable.images,
            1,
            R.drawable.images,
            R.drawable.images,
            R.drawable.images,
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
        View v =inflater.inflate(R.layout.activity_screen2,container,false);

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<>();

        for(int i=0;i<9;i++){
            HashMap<String, String> hm = new HashMap<>();
            hm.put("txt", ""+ countries[i]);
             hm.put("cur",Integer.toString(currency[i]));
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        //s  String[] from = { "flag","txt","cur" };
        String[] from = { "flag","txt","cur" };
        // Ids of views in listview_layout
        //s int[] to = { R.id.flag,R.id.txt,R.id.cur};
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

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

                    s= "Manali, with its soothing backdrop of the Himalayas, offers a blend of tranquility and adventure that makes it one of northern India's most popular destinations. You can do as little or as much as you want there. Located in the Kullu Valley of Himachal Pradesh, it's a magical place bordered by cool pine forest and the raging Beas River, which give it a special energy.";
                    bundle.putInt("image",R.drawable.manali);
                    position=i;
                }
                if (i == 1) {
                    //  intent = new Intent(view.getContext(), Detail.class);
                    s="The hill station of Nainital, in the Kumaon region of Uttarakhand, was a popular summer retreat for the British during the time they ruled India. It features the serene, emerald colored Naini Lake and action filled strip called The Mall, lined with restaurants, shops, hotels, and markets. Enjoy one of the many forest walks, explore the surrounding area on horse back, or relax on a boat in the lake";
                    bundle.putInt("image",R.drawable.nainital);
                    position=i;
                }
                if (i == 2) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="The closest hill station to Mumbai in Maharashtra, Matheran offers plenty of walking trails and lookouts. The most unique thing about it and what makes it so special, is that all vehicles are banned there -- even bicycles. It's a soothing place to relax away from any noise and pollution. Get there by taking the scenic toy train and then ride a horse around.";
                    bundle.putInt("image",R.drawable.matheran);
                    position=i;
                }
                if (i == 3) {
                    // intent = new Intent(view.getContext(), Detail.class);
                    s="Shimla used to be the summer capital of the British Raj when they ruled India. Now it's the state capital of Himachal Pradesh. This wonderfully cool and charming town sprawls along a mountain ridge, enveloped in oak, pine and rhododendron forests. It's quite famous for its colonial style buildings and historic railway. The old Christ Church, with its beautiful stained glass windows, is one of Shimla's most prominent landmarks. Also to be enjoyed are the mesmerizing views from Scandal Point, and the Viceregal Lodge (try to be there for the sunrise or sunset) on Observatory Hill. There are plenty of adventure sports and short hikes on offer in the vicinity as well.";

                  bundle.putInt("image",R.drawable.shimla);
                    position=i;
                }
                if (i==4)
                {
                    s="If you like tea, a visit to Munnar, in Kerala, is a must! The surrounding region is renowned for its sprawling tea plantations. The Kundala Tea Plantations, which border a picturesque lake, offers the best opportunity to see the tea being picked and processed, and to try fresh tea straight from the gardens. The area is blessed with the natural beauty of winding lanes, misty hills, and forests full of exotic plants and wildlife. Adventure enthusiasts can trek to Anamudi, the highest peak in south India, explore Eravikulam National Park, or go rock climbing and paragliding.";
                    bundle.putInt("image",R.drawable.munnar);
                    position=i;
                }
                if (i==5)
                {
                    s="Established in the early 19th century by the British as the summer headquarters of the Chennai government, Ooty is now a soothing place to escape the summer heat in Tamil Nadu. If you travel there during the peak season in April and May, do be prepared for it to be crowded though! Ooty's most popular attractions include the 22 hectare Government Botanical Gardens (a flower show is held there every May as part of the Summer Festival), boating on Ooty Lake, and climbing Dodabetta Peak for an excellent view of the Nilgiri hills.";
                    bundle.putInt("image",R.drawable.ooty);
                    position=i;
                }
                if (i==6)
                {
                    s="Darjeeling, in West Bengal, is also famous for its lush tea gardens. In addition, it's blessed with a stunning view of Mount Kanchenjunga, the world's third highest peak. Some of Darjeeling's most popular attractions include historic toy train, monasteries, botanical gardens, a zoo, and the Darjeeling-Rangeet Valley Passenger Ropeway cable car (the longest cable car in Asia). Darjeeling is a wonderful place to walk around, and explore the tea estates, villages, and markets";
                    bundle.putInt("image",R.drawable.darjeeling);
                    position=i;
                }
                if (i==7)
                {
                    s="Secluded Kodaikanal is nestled 120 kilometers from Madurai in the Palani Hills of Tamil Nadu. Its name means \"Gift of the Forest\", and you'll find many varieties of flora and fauna there. Orchards of pear trees, and charming buildings with gabled roofs, will greet you as you enter the town. There's an annual horticultural show at the landscaped botanical Bryant Park in May, waterfalls where you can enjoy a picnic beside, boating on the lake, and plenty of walking trails. Herbs and aromatherapy oils are some of the more interesting things to buy in Kodaikanal, with the eucalyptus oils being particularly popular. ";
                    bundle.putInt("image",R.drawable.kodaikanal);
                    position=i;
                }
                if (i==8)
                {
                    s="Kodachadri is a mountain peak with dense forests (elevation - 1,343 metres above sea level) in the Western Ghats in South India (Shimoga Dist., Karnataka State). It is declared as natural heritage site by Government Karnataka and it is 10th highest peak of Karnataka.";
                    bundle.putInt("image",R.drawable.kodachadri);
                    position=i;
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
