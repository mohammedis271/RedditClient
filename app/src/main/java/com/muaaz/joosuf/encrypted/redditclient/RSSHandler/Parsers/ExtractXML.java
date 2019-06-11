package com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers;
/**
 * Custom built XML extractor for content side of posts.
 * Filters out any generic text for links within diamond <></> tags
 *
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ExtractXML {
    private static final String TAG = "ExtractXML";

    private String startTag;
    private String xml;
    private String endTag;

    public ExtractXML(String xml, String startTag) {
        this.startTag = startTag;
        this.xml = xml;
    }

    public ExtractXML(String xml, String startTag, String endTag) {
        this.startTag = startTag;
        this.xml = xml;
        this.endTag = endTag;
    }

    public List<String> start() {
        List<String> result = new ArrayList<>();
        String[] splitXML;
        String marker;


        if (endTag == null) {
            marker = "\"";
            splitXML = xml.split(startTag + marker);
        } else {
            marker = endTag;
            splitXML = xml.split(startTag);
        }

        int count = splitXML.length;

        for (int i = 1; i < count; i++) {
            String temp = splitXML[i];
            int index = temp.indexOf(marker);
            Log.d(TAG, "start: index: " + index);
            Log.d(TAG, "start: extracted: " + temp);

            temp = temp.substring(0, index);
            Log.d(TAG, "start: snipped: " + temp);
            result.add(temp);
        }

        return result;
    }
}
