package example.kissanproject.helper.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.kissanproject.R;
import example.kissanproject.datamodels.SmsRecord;

/**
 * Created by abhishek on 12/7/17.
 */

public class SentSmsAdapter extends RecyclerView.Adapter<SentSmsAdapter.MyViewHolder> {

    List<SmsRecord> list;


    public SentSmsAdapter(List<SmsRecord> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowsentsms,parent, false);
        return new SentSmsAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SmsRecord c = list.get(position);
        holder.countryText.setText(c.getmName());
        holder.popText.setText(String.valueOf(c.getmOtp()));
        holder.mDateText.setText(c.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        public TextView countryText;
        public TextView popText;
        public TextView mDateText;

        public MyViewHolder(View view) {
            super(view);
            countryText = (TextView) view.findViewById(R.id.countryName);
            popText = (TextView) view.findViewById(R.id.pop);
            mDateText = (TextView)view.findViewById(R.id.date);
        }

    }
}
