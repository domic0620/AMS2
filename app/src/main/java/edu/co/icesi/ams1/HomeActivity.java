package edu.co.icesi.ams1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private NewItemFragment newItemFragment;
    private ListItemFragment listItemFragment;
    private BottomNavigationView navigator;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigator = findViewById(R.id.navigator);

        newItemFragment = NewItemFragment.newInstance();
        listItemFragment = ListItemFragment.newInstance();

        showFragment(newItemFragment);

        navigator.setOnNavigationItemSelectedListener(
                (menuItem)->{

                    switch (menuItem.getItemId()){

                        case R.id.newitem:
                            showFragment(newItemFragment);
                            break;

                        case R.id.listitem:
                            showFragment(listItemFragment);
                            break;

                    }

                    return true;
                }
        );

    }

    public void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
    

}