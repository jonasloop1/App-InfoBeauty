package com.example.app_infobeauty.ui.minha_agenda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app_infobeauty.R;
import com.example.app_infobeauty.databinding.FragmentDicasBinding;
import com.example.app_infobeauty.databinding.FragmentNavMinhaAgendaBinding;
import com.example.app_infobeauty.ui.dicas.DicasViewModel;

public class nav_minha_agenda extends Fragment {

    private MinhaAgendaViewModel minhaAgendaViewModel;
    private FragmentNavMinhaAgendaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        minhaAgendaViewModel =
                new ViewModelProvider(this).get(MinhaAgendaViewModel.class);

        binding = FragmentNavMinhaAgendaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMinhaAgenda;
        minhaAgendaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}