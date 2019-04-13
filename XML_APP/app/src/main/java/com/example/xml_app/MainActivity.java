package com.example.xml_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (android.widget.TextView) findViewById(R.id.textView2);
        parseXML();

    }

    //podle vzoru https://www.youtube.com/watch?v=-deKKeEdpbw
    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream is =  this.getResources().openRawResource(R.raw.zbozi);
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
        ArrayList<Zbozi> zbozis = new ArrayList<>();
        int eventType = parser.getEventType();
        Zbozi curentZbozi = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String eltName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    eltName = parser.getName();

                    if ("zbozi".equals(eltName)) {
                        curentZbozi = new Zbozi();
                        zbozis.add(curentZbozi);
                    } else if (curentZbozi != null) {
                        if ("nazev".equals(eltName)) {
                            curentZbozi.setNazev(parser.nextText());
                        } else if ("cena".equals(eltName)) {
                            curentZbozi.setCena(parser.nextText());
                        } else if ("pocet".equals(eltName)) {
                            curentZbozi.setPocet(parser.nextText());
                        }
                    }break;
            }

            eventType = parser.next();

        }
        printZbozi(zbozis);
    }

    private void printZbozi(ArrayList<Zbozi> zbozis){
        StringBuilder builder = new StringBuilder();

        for(Zbozi zbozi:zbozis){
            builder.append(zbozi.getNazev()).append("\n").
                    append(zbozi.getCena()).append(" Kč ").append("\n").
                    append(zbozi.getPocet()).append(" ks ").append("\n\n");
        }

        txt.setText(builder.toString());
    }
}
