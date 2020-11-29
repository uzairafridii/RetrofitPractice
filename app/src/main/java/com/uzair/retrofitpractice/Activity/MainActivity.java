package com.uzair.retrofitpractice.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.uzair.retrofitpractice.Interface.ApiInterface;
import com.uzair.retrofitpractice.Models.Albums;
import com.uzair.retrofitpractice.Models.Posts;
import com.uzair.retrofitpractice.R;
import com.uzair.retrofitpractice.Retorfit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a api reference
       ApiInterface retrofitClient = RetrofitClient.getClient().create(ApiInterface.class);

       // call the getalbums method to get the list of albums
       Call<List<Albums>> call = retrofitClient.getAlbums();
       Call<Albums> call2 = retrofitClient.getCurrentAlbum(3);
       Call<List<Posts>> call3 = retrofitClient.getCurrentPostComment(2);

       // call enqueue to run in background
       call.enqueue(new Callback<List<Albums>>() {
           @Override
           public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {

               // to get the list of albumb use foreach loop
               for (Albums res: response.body())
               {
                   Log.d("firstTry", "onResponse: "+res.getTitle()+" Id : "+res.getUserId());
               }
           }
           @Override
           public void onFailure(Call<List<Albums>> call, Throwable t) {

               Log.d("firstTry", "onFailure: "+t.getMessage().toString());
           }
       });



       // get the album by id
        call2.enqueue(new Callback<Albums>() {
            @Override
            public void onResponse(Call<Albums> call, Response<Albums> response) {
                Log.d("getByUserId", "onResponse: "+response.body().getId()+" "+response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Albums> call, Throwable t) {

            }
        });



        //get current post comments using query
       call3.enqueue(new Callback<List<Posts>>() {
           @Override
           public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

               for (Posts post: response.body())
               {
                   Log.d("getPostCommentById", "onResponse: "+post.getPostId()+"::"+post.getName()+"::"+post.getEmail());

               }

           }

           @Override
           public void onFailure(Call<List<Posts>> call, Throwable t) {

           }
       });


    }
}