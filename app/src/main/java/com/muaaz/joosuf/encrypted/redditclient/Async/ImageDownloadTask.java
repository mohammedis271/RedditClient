package com.muaaz.joosuf.encrypted.redditclient.Async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownloadTask extends AsyncTask<String,Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... urls) {
        try{
            URL url = new URL(urls[0]);
            HttpURLConnection myConnection =(HttpURLConnection) url.openConnection();
            myConnection.connect();
            InputStream inputStream = myConnection.getInputStream();
            Bitmap myImage = BitmapFactory.decodeStream(inputStream);
            return myImage;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
