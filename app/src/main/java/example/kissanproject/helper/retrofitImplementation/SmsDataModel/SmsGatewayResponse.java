package example.kissanproject.helper.retrofitImplementation.SmsDataModel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abhishek on 11/7/17.
 */

public class SmsGatewayResponse {
    @SerializedName("ErrorCode")
    private String mErrorCode;

    @SerializedName("ErrorMessage")
    private String getmErrorMessage;

    @SerializedName("JobId")
    private String mJobId;

    @SerializedName("MessageData")
    private String mMessageData;

    public SmsGatewayResponse(String mErrorCode, String getmErrorMessage, String mJobId, String mMessageData) {
        this.mErrorCode = mErrorCode;
        this.getmErrorMessage = getmErrorMessage;
        this.mJobId = mJobId;
        this.mMessageData = mMessageData;
    }

    public String getmErrorCode() {
        return mErrorCode;
    }

    public void setmErrorCode(String mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public String getGetmErrorMessage() {
        return getmErrorMessage;
    }

    public void setGetmErrorMessage(String getmErrorMessage) {
        this.getmErrorMessage = getmErrorMessage;
    }

    public String getmJobId() {
        return mJobId;
    }

    public void setmJobId(String mJobId) {
        this.mJobId = mJobId;
    }

    public String getmMessageData() {
        return mMessageData;
    }

    public void setmMessageData(String mMessageData) {
        this.mMessageData = mMessageData;
    }
}
