package com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers;
/**
 * Mandatory interface described within https://square.github.io/retrofit/
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLTags.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface XMLHandler {

    @GET("{feed_name}/.rss")
    Call<Feed>
    getSubRedditFeed(@Path("feed_name") String feed_name);

    /**
     * @Type may have values
     * best
     * hot
     * top
     * new
     * rising
     * controversial
     * gilded (not common)
     * wiki (not common)
     */
    @GET("{type}/.rss")
    Call<Feed>
    getFrontPageFeed(@Path("type")String type);
}