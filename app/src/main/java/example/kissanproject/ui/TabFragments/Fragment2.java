package example.kissanproject.ui.TabFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.kissanproject.R;
import example.kissanproject.datamodels.DatabaseHelper;
import example.kissanproject.datamodels.SmsRecord;
import example.kissanproject.helper.adapters.ContactAdapter;
import example.kissanproject.helper.adapters.SentSmsAdapter;


public class Fragment2 extends Fragment {

    static List<SmsRecord> smsRecords;
    DatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dbHelper = new DatabaseHelper(getContext());

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);
        smsRecords = new ArrayList<>();
        createList();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        SentSmsAdapter ss = new SentSmsAdapter(smsRecords);
        rv.setAdapter(ss);
    }

    private void createList(){
        smsRecords = dbHelper.getAllToDos();
        dbHelper.closeDB();
//        Log.e("error_dbinflate", String.valueOf(smsRecords.get(0).getmNumber()));
    }
}
