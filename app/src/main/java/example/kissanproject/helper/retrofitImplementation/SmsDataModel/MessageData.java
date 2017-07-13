package example.kissanproject.helper.retrofitImplementation.SmsDataModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abhishek on 11/7/17.
 */

public class MessageData {
    @SerializedName("Number")
    private String mNumber;

    @SerializedName("MessageId")
    private String mMessageId;

    @SerializedName("Message")
    private String mMessage;

    public MessageData(String mNumber, String mMessageId, String mMessage) {
        this.mNumber = mNumber;
        this.mMessageId = mMessageId;
        this.mMessage = mMessage;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmMessageId() {
        return mMessageId;
    }

    public void setmMessageId(String mMessageId) {
        this.mMessageId = mMessageId;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }
}
