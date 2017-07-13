package example.kissanproject.helper.dataModels;

/**
 * Created by abhishek on 11/7/17.
 */

public class Contacts {
    public String mName;
    public String mContactNo;

    public Contacts(String mName, String mContactNo) {
        this.mName = mName;
        this.mContactNo = mContactNo;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmContactNo() {
        return mContactNo;
    }

    public void setmContactNo(String mContactNo) {
        this.mContactNo = mContactNo;
    }
}
