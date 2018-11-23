package sujeet.android.com.retrofitimplementation.interfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;
import sujeet.android.com.retrofitimplementation.pojo.Login;

public interface NetworkInterface {
    @POST("api/login")
    @FormUrlEncoded
    Call<Login> registration(@Field("email") String email, @Field("password") String password);
}
