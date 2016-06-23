package com.android.benben.http.api;

import com.android.benben.http.model.CustomerBean;
import com.android.benben.http.model.LoginResultBean;



import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by benben on 2016/6/17.
 */
public interface ApiService {



    /*登录*/
    @POST("phone_login")
    Call<LoginResultBean> login(@Query("j_username")String j_username,
                                @Query("j_password")String j_password,
                                @Query("imsi") String imsi);


    /*人员选择*/
    @POST("action/get_user_org_Info.action")
    Call<CustomerBean> customer(@Query("org_id") long id);

}
