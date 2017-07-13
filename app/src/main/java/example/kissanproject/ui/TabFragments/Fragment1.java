package example.kissanproject.ui.TabFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.kissanproject.ui.Activities.ContactDetail;
import example.kissanproject.R;
import example.kissanproject.helper.adapters.ContactAdapter;
import example.kissanproject.helper.adapters.ContactAdapterListener;
import example.kissanproject.helper.dataModels.Contacts;


public class Fragment1 extends Fragment {

    private static List<Contacts> mContacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContacts = new ArrayList<>();
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);
        createList();
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        ContactAdapter ca = new ContactAdapter(mContacts);
        rv.setAdapter(ca);
        rv.addOnItemTouchListener(new ContactAdapterListener(getContext(), rv, new ContactAdapterListener.RecyclerTouchListener() {
            @Override
            public void onClickItem(View v, int position) {
                Intent in = new Intent(getActivity(),ContactDetail.class);
                in.putExtra("extraName",mContacts.get(position).getmName());
                in.putExtra("extraContact",mContacts.get(position).getmContactNo());
                startActivity(in);
            }

            @Override
            public void onLongClickItem(View v, int position) {

            }
        }));
    }

    public void createList(){
        mContacts.add(new Contacts("Abhishek","918791566289"));
        mContacts.add(new Contacts("Kisan Test Number","919971792703"));
    }

}
