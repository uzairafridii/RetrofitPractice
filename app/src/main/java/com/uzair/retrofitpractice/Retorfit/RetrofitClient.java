package com.uzair.retrofitpractice.Retorfit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// retrofit client is a class which contain the instance of retrofit
// and provide the base url of api here
// create a static method to get the instance of this class
public class RetrofitClient
{

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}
