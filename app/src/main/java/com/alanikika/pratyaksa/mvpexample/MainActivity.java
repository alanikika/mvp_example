package com.alanikika.pratyaksa.mvpexample;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alanikika.pratyaksa.mvpexample.model.MainModel;
import com.alanikika.pratyaksa.mvpexample.presenter.MainPresenter;
import com.alanikika.pratyaksa.mvpexample.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    @BindView(R.id.edit_long) EditText editLength;
    @BindView(R.id.edit_width) EditText editWidth;
    @BindView(R.id.edit_height) EditText editHeight;
    @BindView(R.id.btn_submit) Button btnSubmit;
    @BindView(R.id.tv_result) TextView tvResult;
    @BindView(R.id.screen) LinearLayout linearLayout;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_submit)
    void calculate() {
        String length = editLength.getText().toString().trim();
        String width = editWidth.getText().toString().trim();
        String height = editHeight.getText().toString().trim();

        boolean isEmptyFileds = false;

        if(TextUtils.isEmpty(length) && TextUtils.isEmpty(width) && TextUtils.isEmpty(height)) {
            isEmptyFileds = true;
            Snackbar snackbar = Snackbar
                    .make(linearLayout, getResources().getString(R.string.empty_field), Snackbar.LENGTH_LONG);
            snackbar.show();
        }

        if(!isEmptyFileds) {
            double l = Double.parseDouble(length);
            double w = Double.parseDouble(width);
            double h = Double.parseDouble(height);

            presenter = new MainPresenter((MainView) this);

            presenter.hitungVolume(l, w, h);
        }

    }

    @Override
    public void showVolume(MainModel model) {
        tvResult.setText(String.valueOf(model.getVolume()));
    }
}
