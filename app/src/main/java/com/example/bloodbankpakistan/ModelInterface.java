package com.example.bloodbankpakistan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ModelInterface {

    @POST("/GetDetailWithMonthWithCode")
    Call<ApiModel> userRegistration(@Body ApiModel apiModel);


}
