package com.rba.androidmvp.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rba.androidmvp.R;
import com.rba.androidmvp.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter mainPresenter;
    private Button btnSave;
    private EditText txtUserName;
    private EditText txtAge;
    private Button btnGetUser;

    private RecyclerView rcvUser;
    private List<UserEntity> userEntities = new ArrayList<>();
    private MainAdapter mainAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        toolbar = (Toolbar) this.findViewById(R.id.toolbar);

        txtUserName = (EditText) findViewById(R.id.txtUserName);
        btnGetUser = (Button) findViewById(R.id.btnGetUser);
        txtAge = (EditText) findViewById(R.id.txtAge);

        rcvUser = (RecyclerView) findViewById(R.id.rcvUser);
        btnSave = (Button) findViewById(R.id.btnSave);

        mainAdapter = new MainAdapter(this);
        mainPresenter = new MainPresenter(this);

        rcvUser.setLayoutManager(new LinearLayoutManager(this));
        rcvUser.setAdapter(mainAdapter);
        setSupportActionBar(toolbar);
        btnSave.setOnClickListener(this);
        btnGetUser.setOnClickListener(this);
    }


    @Override
    public void showToast(String carloMessage) {

    }

    @Override
    public void updateUserList(List<UserEntity> userEntityList) {
        userEntities.clear();
        userEntities.addAll(userEntityList);
        mainAdapter.addData(userEntities);
        mainAdapter.notifyDataSetChanged();
    }

    @Override
    public void closeToast() {

    }

    @Override
    public void updateAdapter(String name) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSave) {
            mainPresenter.validateUser(txtUserName.getText().toString(),
                    Integer.parseInt(txtAge.getText().toString()));

        }else if(view.getId() == R.id.btnGetUser){
            mainPresenter.getUsers();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.destroyData();
    }
}
