package example.kissanproject.ui.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import example.kissanproject.Constants;
import example.kissanproject.R;
import example.kissanproject.datamodels.DatabaseHelper;
import example.kissanproject.datamodels.SmsRecord;
import example.kissanproject.helper.retrofitImplementation.SmsDataModel.SmsGatewayResponse;
import example.kissanproject.helper.retrofitImplementation.retrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComposeMessage extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ComposeMessage";

    private DatabaseHelper databaseHelper;
    private String mOtp;
    private String mName;
    private EditText mEditSms;
    private String mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);

        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        mOtp = String.valueOf(n);

        mEditSms = (EditText)findViewById(R.id.edit_message);
        mEditSms.setText("Hi. Your OTP is: "+mOtp);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mName = extras.getString("extraName");
            mContact = extras.getString("extraContact");
        }


        databaseHelper = new DatabaseHelper(getApplicationContext());
        findViewById(R.id.button_sendMessage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button_sendMessage:
                String message = String.valueOf(mEditSms.getText());
                if (mContact!=null||message!=null){
                    insertDb(mContact);
                    sendSms(mContact,message);
                }
                Intent in = new Intent(this,MainActivity.class);
                startActivity(in);
                break;
        }
    }
    private void insertDb(String number){
        SmsRecord sms = new SmsRecord();
        sms.setmOtp(mOtp);
        sms.setDate(getDateTime());
        sms.setmName(mName);
        sms.setmNumber(number);
        long id = databaseHelper.createToDo(sms);
        databaseHelper.closeDB();
        Log.e("error_database", String.valueOf(id));
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
    public void sendSms(final String number, String testmessage){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface service = retrofit.create(retrofitInterface.class);
        Call<SmsGatewayResponse> call2 = service.getDataSms(Constants.BASE_URL1 + "SendSMS?APIKey=" +
                Constants.API_KEY1+"&senderid=TESTIN&channel=2&DCS=0&flashsms=0&number="+
                number+"&text="+testmessage+"&route=1");
        call2.enqueue(new Callback<SmsGatewayResponse>() {
            @Override
            public void onResponse(Call<SmsGatewayResponse> call, Response<SmsGatewayResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Messeage sent", Toast.LENGTH_SHORT).show();
                        Log.e(TAG + "response", response.body().getGetmErrorMessage());
//                        insertDb(number);

                    } else {
                        Toast.makeText(getApplicationContext(), "Messeage not sent", Toast.LENGTH_SHORT).show();
                        Log.e(TAG + "error", response.message());
                        Log.e(TAG + "error1", String.valueOf(response.code()));
                    }
                }catch (Exception e){

                }

            }

            @Override
            public void onFailure(Call<SmsGatewayResponse> call, Throwable t) {
              //  Toast.makeText(getApplicationContext(),"Internet Connection Problem",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
