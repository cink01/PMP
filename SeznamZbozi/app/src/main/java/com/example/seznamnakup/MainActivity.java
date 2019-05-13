package com.example.seznamnakup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseXML();
    }
    public List<Zbozi> zbozis = Singleton.getInstance().zbozis;
    ListView lv;
    @Override
    public boolean onCreateOptionsMenu(Menu menu ) {
       try {
           MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_items,menu);
        }
        catch (Exception ex) {}
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_pridat) {
            Intent intent = new Intent(this, PridaniActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();
        try {
            Intent i = getIntent();
            ListView lv = findViewById(R.id.listview_seznam);
            Zbozi z = (Zbozi) i.getSerializableExtra("Zbozi");
            Zbozi x = new Zbozi(z.nazev, z.cena, z.pocet);
            zbozis.add(x);
            Refresh();
        }
        catch (Exception ex) {}
    }
    public void onClickPridej(View view) {
        Intent intent = new Intent(this, PridaniActivity.class);
        startActivity(intent);
    }
    private void Refresh() {
        lv = findViewById(R.id.listview_seznam);
        ArrayAdapter<Zbozi> arrayAdapter =
                new ArrayAdapter<Zbozi>(this, android.R.layout.simple_list_item_1, zbozis);
        lv.setAdapter(arrayAdapter);
    }

    //XML SOUBOR
    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is = this.getResources().openRawResource(R.raw.zbozi);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);
            processParsing(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        Zbozi tmpZbozi = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();
                    if ("zbozi".equals(eltName)) {
                        tmpZbozi = new Zbozi("-", ((float) (-1.1)), ((float) (-1.1)));
                        zbozis.add(tmpZbozi);
                    } else if (tmpZbozi != null) {
                        if ("nazev".equals(eltName)) {
                            tmpZbozi.setNazev(parser.nextText());
                        } else if ("cena".equals(eltName)) {
                            tmpZbozi.setCena(Float.parseFloat(parser.nextText()));
                        } else if ("pocet".equals(eltName)) {
                            tmpZbozi.setPocet(Float.parseFloat(parser.nextText()));
                        }
                    }
                    break;
            }
            eventType = parser.next();
        }
        Refresh();
    }
}