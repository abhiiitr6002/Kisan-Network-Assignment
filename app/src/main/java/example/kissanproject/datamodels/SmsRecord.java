package example.kissanproject.datamodels;

/**
 * Created by abhishek on 12/7/17.
 */

public class SmsRecord {
    private int id;
    private String mNumber;
    private String mName;
    private String mOtp;
    private String Date;

    public SmsRecord() {
    }

    public SmsRecord(int id, String mNumber, String mName, String mOtp, String date) {
        this.id = id;
        this.mNumber = mNumber;
        this.mName = mName;
        this.mOtp = mOtp;
        Date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmOtp() {
        return mOtp;
    }

    public void setmOtp(String mOtp) {
        this.mOtp = mOtp;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
