package com.example.myapplication;

import com.google.gson.JsonObject;
import okhttp3.RequestBody;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DjangoApi {

    String DJANGO_SITE = "http://13.125.171.174/";

    @Headers({"X-CSRFToken:CzIYG6M19yxYhKjuSqTBaC2XnMFZUPbIHq46BVAXXlm6nP8MQaoQwme8HoUwdtYw", "Content-Type:application/json", "Cookie: csrftoken=CzIYG6M19yxYhKjuSqTBaC2XnMFZUPbIHq46BVAXXlm6nP8MQaoQwme8HoUwdtYw"})
    @POST("/rest_api_test/")
        //Call<RequestBody> addPostVoditel(@Body JSONObject jsonObject);
    Call<RequestBody> addPostVoditel(@Body JsonObject jsonObject);



}