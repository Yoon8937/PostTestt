package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddPostServer();
    }



    public void AddPostServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DjangoApi.DJANGO_SITE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DjangoApi postApi= retrofit.create(DjangoApi.class);


        PostModel postModel = new PostModel("this is a test123123", "from cyh123", "hello111 Django", 123123);
        Gson gson = new Gson();

        String obj = gson.toJson(postModel); //{"age":30,"job":"programmer","name":"Cyh","type":"type"}
        JsonObject object = gson.fromJson(obj, JsonObject.class);

        System.out.println("Data: " + object);
        System.out.println("Type: " + object.getClass().getName());

        Call<RequestBody> call = postApi.addPostVoditel(object);

        call.enqueue(new Callback<RequestBody>() {
            @Override
            public void onResponse(Call<RequestBody> call, Response<RequestBody> response) {
                Log.d("good", "good");
            }
            @Override
            public void onFailure(Call<RequestBody> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });
    }


}