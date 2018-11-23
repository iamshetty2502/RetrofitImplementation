package sujeet.android.com.retrofitimplementation.repositries;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sujeet.android.com.retrofitimplementation.interfaces.NetworkInterface;
import sujeet.android.com.retrofitimplementation.pojo.Login;

public class Network {

    NetworkInterface networkInterface;

    private NetworkInterface getInterfaceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);
        return networkInterface;
    }

    public void login(String username,String password){
        networkInterface = this.getInterfaceService();
        Call<Login> mService = networkInterface.registration(username, password);
        mService.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Log.e("Network ", response.body().getToken());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
    }
}
