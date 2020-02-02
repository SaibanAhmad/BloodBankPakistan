package com.example.bloodbankpakistan;

import retrofit2.http.POST;

public interface ModelInterface {

    @POST("/GetDetailWithMonthWithCode")
   void userRegistration(ApiModel apiModel);


}
