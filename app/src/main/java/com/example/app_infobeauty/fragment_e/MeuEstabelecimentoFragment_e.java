package com.example.app_infobeauty.fragment_e;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_infobeauty.R;
import com.example.app_infobeauty.empresa.Empresa;

public class MeuEstabelecimentoFragment_e extends Fragment {

    EditText estabelecimento, endereco, email, cnpj;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meu_estabelecimento_e, container, false);
/*
        estabelecimento = findViewById(R.id.edtNomeEstabelecimento);
        endereco = findViewById(R.id.edtEnderecoEstabelecimento);
        email = findViewById(R.id.edtEmailEstabelecimento);
        cnpj = findViewById(R.id.edtCnpjEstabelecimento);

        final Intent itEstabelecimento = getIntent();
        final Empresa empresa = (Empresa) itEstabelecimento.getExtras().getSerializable("objEstabelecimento");
        estabelecimento.setText(empresa.getNome_empresa());
        endereco.setText(empresa.getEndereco_empresa());
        email.setText(empresa.getEmail_empresa());
        cnpj.setText(empresa.getCnpj_empresa());
*/

    }
}
