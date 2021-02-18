package edu.co.icesi.ams1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemFragment extends Fragment{

    //State
    ArrayList<String> tareas;

    //UI
    private TextView taskList;


    public ListItemFragment() {
        // Required empty public constructor
        tareas = new ArrayList<>();
    }

    public static ListItemFragment newInstance() {
        ListItemFragment fragment = new ListItemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_list_item, container, false);
        taskList = root.findViewById(R.id.taskList);


        //Recuperar el estado
        taskList.setText("");
        for(String task : tareas){
            taskList.append(task+"\n");
        }

        return root;
    }

    @Override
    public void onNewTask(String task) {
        tareas.add(task);
    }
}