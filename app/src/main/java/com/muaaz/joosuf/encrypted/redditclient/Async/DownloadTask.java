package com.muaaz.joosuf.encrypted.redditclient.Async;
/**
 * General Async download task used for pulling html/ rss/ Json or any information from a given link.
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        URL url;
        InputStream is;
        BufferedReader br;
        String data;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            url = new URL(strings[0]);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((data = br.readLine()) != null){
                stringBuilder.append(data);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }
}
