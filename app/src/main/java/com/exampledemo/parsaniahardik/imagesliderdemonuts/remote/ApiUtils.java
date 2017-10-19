package com.exampledemo.parsaniahardik.imagesliderdemonuts.remote;

/**
 * Created by infoava(nlk) .
 */

public class ApiUtils {

    private ApiUtils() {}

//    public static final String BASE_URL = "http://192.168.100.13:9090/consumer/product/";
 //public static final String BASE_URL = "http://willmel.com/product/";
        public static final String BASE_URL ="http://192.168.100.14:8080/advertisement/welcomePage/";

    public static SOService getSOService(){
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
