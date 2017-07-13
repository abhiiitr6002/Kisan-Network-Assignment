package example.kissanproject.helper.retrofitImplementation;

import example.kissanproject.helper.retrofitImplementation.SmsDataModel.SmsGatewayResponse;
import retrofit2.Call;
import retrofit2.http.HTTP;
import retrofit2.http.Url;

import static java.net.Proxy.Type.HTTP;

/**
 * Created by abhishek on 11/7/17.
 */

public interface retrofitInterface {

    //Sending Sms
    @retrofit2.http.HTTP(method = "GET")
    Call<SmsGatewayResponse> getDataSms(@Url String Sms);
}
