package sion.my.jinxiu.until;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetRequest {
    public static Retrofit getRetrofit(String api){
        return new Retrofit.Builder().baseUrl(api).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static <T> T getApiMethod(Retrofit retrofit,Class<T> tclass){
       return retrofit.create(tclass);
    }

}
