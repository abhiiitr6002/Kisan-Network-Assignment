package example.kissanproject.helper.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import example.kissanproject.R;
import example.kissanproject.helper.dataModels.Contacts;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private List<Contacts> countryList;

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        public TextView countryText;
        public TextView popText;

        public MyViewHolder(View view) {
            super(view);
            countryText = (TextView) view.findViewById(R.id.countryName);
            popText = (TextView) view.findViewById(R.id.pop);
        }

    }

    public ContactAdapter(List<Contacts> countryList) {
        this.countryList = countryList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowdesign,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.MyViewHolder holder, int position) {
        Contacts c = countryList.get(position);
        holder.countryText.setText(c.mName);
        holder.popText.setText(String.valueOf(c.mContactNo));
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
