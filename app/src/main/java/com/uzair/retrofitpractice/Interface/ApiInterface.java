package com.uzair.retrofitpractice.Interface;

import com.uzair.retrofitpractice.Models.Albums;
import com.uzair.retrofitpractice.Models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


// api interface contain the method that will use for api transaction

public interface ApiInterface {
    // this method get the albums list
    @GET("/albums")
    Call<List<Albums>> getAlbums();


    // this method get the albums with provide ID using path
    @GET("posts/{id}")
    Call<Albums> getCurrentAlbum(@Path("id") int id);

    // get single post comments with post id
    @GET("posts/{postId}/comments")
    Call<List<Posts>> getCurrentPostComment(@Path("postId") int id);

}
