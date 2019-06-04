package com.phamminhtri.mohinhmvp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.phamminhtri.mohinhmvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginRegisterFragment extends Fragment implements View.OnClickListener {
    private TextView tvLogin;
    private TextView tvRegistor;
    private Button btnRegister;
    private EditText edtUsername;


    public LoginRegisterFragment() {
        // Required empty public constructor
    }

    public static LoginRegisterFragment newInstance() {
        LoginRegisterFragment loginRegisterFragment = new LoginRegisterFragment();
        return loginRegisterFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_register, container, false);


        tvLogin = (TextView) view.findViewById(R.id.tv_login);
        tvRegistor = (TextView) view.findViewById(R.id.tv_registor);
        edtUsername = (EditText) view.findViewById(R.id.edt_username);
        EditText edtEmail = (EditText) view.findViewById(R.id.edt_email);
        EditText edtPassword = (EditText) view.findViewById(R.id.edt_password);
        btnRegister = (Button) view.findViewById(R.id.btn_register);


        tvLogin.setOnClickListener(this);
        tvRegistor.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login:
                tvLogin.setBackgroundResource(R.drawable.bg_loginregistor_active);
                tvRegistor.setBackgroundResource(R.drawable.bg_loginregistor_inactive);
                edtUsername.setVisibility(View.GONE);
                btnRegister.setText("login");

                break;
            case R.id.tv_registor:
                tvLogin.setBackgroundResource(R.drawable.bg_loginregistor_inactive);
                tvRegistor.setBackgroundResource(R.drawable.bg_loginregistor_active);
                edtUsername.setVisibility(View.VISIBLE);
                btnRegister.setText("Registor");
                break;
            case R.id.btn_register:
                break;
        }

    }
}
