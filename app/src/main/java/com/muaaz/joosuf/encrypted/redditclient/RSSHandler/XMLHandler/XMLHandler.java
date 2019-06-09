package com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLHandler;
/**
 * Mandatory interface described within https://square.github.io/retrofit/
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.SubReddit.XMLTAGS.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface XMLHandler {

    @GET("earthporn/.rss")
    Call<Feed> getFeed();
}
