package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi;

import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments.CommentsDataHolder;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts.PostsData;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.oauth2.AccessToken;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RedditClient {

  //  @Headers("Accept: application/json")
    @POST("api/v1/access_token")
    @FormUrlEncoded
    Call<AccessToken> getAccessToken(
            @HeaderMap Map<String,String> headers,
            @Field("grant_type")String grantType,
            @Field("code") String code,
            @Field("redirect_uri")String redirectUri
    );

    @GET(".json")
    Call<PostsData> getPostData(
            @Query("sort") String sort_type,
            @Query("after") String after
    );

    @GET("{subreddit}/.json")
    Call<PostsData>getSubredditPostData(
            @Path("subreddit")String subreddit
    );

    @GET("r/pics/comments/c524hp/frida_who_was_mexico_symbol_of_hope_during_the/.json")
    Call<CommentsDataHolder> getPostComments();

}
