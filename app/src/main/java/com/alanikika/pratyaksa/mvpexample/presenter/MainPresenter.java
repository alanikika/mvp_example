package com.alanikika.pratyaksa.mvpexample.presenter;

import com.alanikika.pratyaksa.mvpexample.model.MainModel;
import com.alanikika.pratyaksa.mvpexample.view.MainView;


public class MainPresenter {
    private MainView view;


    public MainPresenter(MainView view){
        this.view = view;
    }

    private double volume(double along, double width, double height) {
        return (along * width * height);
    }

    public void hitungVolume(double along, double width, double height) {
        double volume = volume(along, width, height);
        MainModel model = new MainModel(volume);
        view.showVolume(model);
    }
}
