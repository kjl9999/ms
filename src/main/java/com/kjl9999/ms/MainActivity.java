package com.kjl9999.ms;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
public ArrayList<String> values = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //myCode

        InputStream file = getResources().openRawResource(R.raw.ms);
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String line;
        try {
            while((line = reader.readLine()) != null) {
                String[] strings = line.split(";");
                for(String s : strings) {
                    values.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView mainText=(TextView) findViewById(R.id.maintext);
        mainText.setText( (String) getMS());

        //myCode
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView mainText=(TextView) findViewById(R.id.maintext);

        switch (item.getItemId()) {
            case R.id.menu_roll:
                mainText.setText( (String) getMS());

                break;

            case R.id.menu_list:
                mainText.setText("");
                for (int i=0; i<values.size(); i+=2){
                    mainText.append(values.get(i+1));
                    mainText.append("\n \n");

                }

                break;

            default:
                break;
        }

        return true;
    }

    public String getMS(){

        Random rand = new Random();

        int  n = (rand.nextInt(600) + 1)*2-1;
        String ms = values.get(n);
        return ms;
    }

}
