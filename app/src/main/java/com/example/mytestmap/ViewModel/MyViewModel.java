package com.example.mytestmap.ViewModel;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.Api.Api;
import com.example.Api.ApiInterface;
import com.example.mytestmap.Models.DirectionPojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {

    private ApiInterface mApiInterface;

    private static final String TAG = "MyViewModel";
    private MutableLiveData<DirectionPojo> directionList;


    public LiveData<DirectionPojo> getPolyLine(final Activity activity, Map data){


        if (directionList == null) {
            directionList = new MutableLiveData();
        }

        mApiInterface = Api.getDirectionClient().create(ApiInterface.class);

        mApiInterface.getPolyLine(data).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                if (response.body() != null){

                    Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResponse: success: ");
                }
                else {
                    Toast.makeText(activity, "Failed.", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onResponse: not success");
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(activity, "Error, try again.", Toast.LENGTH_SHORT).show();

            }
        });




        return directionList;
    }

}
