package com.harsha.dell.placesnearby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.app.ListActivity;
import android.content.Intent;
import android.view.*;
import android.view.View;
import android.widget.*;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstActi extends Activity {

    TextView tv;
    int r=0;
    String[] places=
            {
                    "ATM",
                    "BANK",
                    "BUS STATION",
                    "DOCTOR",
                    "CHURCH",
                    "HOSPITAL",
                    "HINDU TEMPLE",
                    "MOSQUE",
                    "MOVIE THEATRE",
                    "POLICE STATION",
                    "SCHOOL",
                    "AIRPORT",
                    "RAILWAY STATION",
                    "RESTAURANT"

            };
    int[] im=
            {

                    R.mipmap.t1,
                    R.mipmap.t2,
                    R.mipmap.t3,
                    R.mipmap.t4,
                    R.mipmap.t5,
                    R.mipmap.t7,
                    R.mipmap.t14,
                    R.mipmap.t6,
                    R.mipmap.t8,
                    R.mipmap.t9,
                    R.mipmap.t10,
                    R.mipmap.t11,
                    R.mipmap.t12,
                    R.mipmap.t13,

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        tv = (TextView)findViewById(R.id.rad);
        List<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
        for(int i=0;i<14;i++)
        {
            HashMap<String,String> hm=new HashMap<String,String>();
            hm.put("place",places[i]);
            hm.put("imag",Integer.toString(im[i]));
            list.add(hm);
        }
        String[] from={"imag","place"};
        int[] arr={R.id.flag,R.id.txt};
        SimpleAdapter adapter=new SimpleAdapter(getBaseContext(),list,R.layout.layout11,from,arr);
        ListView listView= (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seek);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        r=progress*50;

                    String  asd= "";
                    asd = String.valueOf(r);
                    asd = asd + "m";
                    tv.setText(asd);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(FirstActi.this,navi.class);
                String type = places[position];
               // Toast.makeText(getApplicationContext(),type,Toast.LENGTH_LONG).show();
                //l.getItemAtPosition(position).toString();
                i.putExtra("type",type);
                i.putExtra("radius",String.valueOf(r));
                startActivity(i);
            }
        });
    }
/*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);


    }*/
}
