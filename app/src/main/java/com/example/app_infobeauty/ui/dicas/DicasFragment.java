package com.example.app_infobeauty.ui.dicas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app_infobeauty.databinding.FragmentDicasBinding;

public class DicasFragment extends Fragment {

    private DicasViewModel dicasViewModel;
    private FragmentDicasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dicasViewModel =
                new ViewModelProvider(this).get(DicasViewModel.class);

        binding = FragmentDicasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDicas;
        dicasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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