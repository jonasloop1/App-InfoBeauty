package com.example.app_infobeauty.ui.minha_agenda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MinhaAgendaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MinhaAgendaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is minha agenda fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
