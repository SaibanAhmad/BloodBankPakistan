package com.example.bloodbankpakistan;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModelImplementation {

   public static ModelInterface modelInterface = null ;
    public static ModelInterface getImpl ()
    {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("YOUR URL")
                .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            modelInterface = retrofit.create(ModelInterface.class);
            return modelInterface;
    }
}
