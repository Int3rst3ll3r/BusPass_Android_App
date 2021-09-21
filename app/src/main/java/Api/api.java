package Api;

import com.example.buspass.modelresponse.DeleteResponse;
import com.example.buspass.modelresponse.LoginResponse;
import com.example.buspass.modelresponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface                                                                                                                                                                                                                                                                                                                                                            api {

    @FormUrlEncoded
    @POST("register.php")

    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("conpass") String conpass,
            @Field("gender") String gender,
            @Field("con_number") String con_number,
            @Field("address") String address,
            @Field("city") String city,
            @Field("state") String state);
    

    @FormUrlEncoded
    @POST("login.php")

    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
            );


    @FormUrlEncoded
    @POST("update.php")

    Call<LoginResponse> updateuseraccount(
            @Field("userid") int userid,
            @Field("username") String username,
            @Field("email") String email,
            @Field("gender") String gender,
            @Field("con_number") String con_number,
            @Field("address") String address,
            @Field("city") String city,
            @Field("state") String state
    );
    
    @FormUrlEncoded
    @POST("delete.php")

    Call<DeleteResponse> deleteuser(
            @Field("userid") int userid
            );
}

