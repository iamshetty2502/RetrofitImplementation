package sujeet.android.com.retrofitimplementation.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import sujeet.android.com.retrofitimplementation.BR;
import sujeet.android.com.retrofitimplementation.repositries.Network;

public class MainViewModel extends BaseObservable {

    public MainViewModel() {
        userName=new String();
        passWord=new String();
        network=new Network();
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(!TextUtils.isEmpty(userName)&& !this.userName.equals(userName))
        {
            this.userName = userName;
            Log.e("MainViewModel ",userName);
        }
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if(!TextUtils.isEmpty(passWord)&& !this.passWord.equals(passWord))
        {
            this.passWord = passWord;
            Log.e("MainViewModel ",passWord);
        }
        notifyPropertyChanged(BR.passWord);
    }

    public void onLoginClick(){
        Log.e("MainViewModel ",userName + " "+passWord);

        network.login(userName,passWord);


    }



    String userName;
    String passWord;
    Network network;
}
