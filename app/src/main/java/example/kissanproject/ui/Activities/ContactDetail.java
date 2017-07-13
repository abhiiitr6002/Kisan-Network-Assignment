package example.kissanproject.ui.Activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import example.kissanproject.Constants;
import example.kissanproject.R;


public class ContactDetail extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ContactDetails";
    TextView contactNumber;
    TextView contactName;

    private String mName;
    private String mContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);


        mName = "Me";
        mContact = "919999999999";

//        databaseHelper.deleteToDo(4);
////        databaseHelper.deleteToDo(2);
////        databaseHelper.deleteToDo(3);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mName = extras.getString("extraName");
            mContact = extras.getString("extraContact");
        }


;

//        insertDb("8791566289");

        contactName = (TextView)findViewById(R.id.text_contactName);
        contactName.setText(mContact);

        contactNumber = (TextView)findViewById(R.id.text_message);
        contactNumber.setText(mName);
        findViewById(R.id.button_Contact).setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button_Contact:
                Intent in = new Intent(this,ComposeMessage.class);
                in.putExtra("extraName",mName);
                in.putExtra("extraContact",mContact);
                startActivity(in);
                break;
        }
    }
}
