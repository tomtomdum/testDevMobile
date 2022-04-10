package com.example.testdevmobile.API;
import com.google.gson.JsonObject;

import java.time.Period;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

//key: 1a4ccf761bb9a9b056e4c047af130474
public interface APIService {

//    @POST("api/user/login")
//    @FormUrlEncoded
//    Call<User> login(@Field("email") String email,
//                     @Field("password") String password
//    );
//    //Ajouter dans le header de la requête: Authorization = Bearer 'Token'
//    @POST("api/user/availability/add")
//    @FormUrlEncoded
//    Call<List<Period>> addAvailability(
//            @Header("Authorization") String token,
//            @Field("day") int dayOfWeek,
//            @Field("starting_hour") String startHour,
//            @Field("ending_hour") String endHour
//    );
//    //Ajouter dans le header de la requête: Authorization = Bearer 'Token'
    @GET("weather")
    Call<JsonObject> getMeteo(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String apiKey);

}