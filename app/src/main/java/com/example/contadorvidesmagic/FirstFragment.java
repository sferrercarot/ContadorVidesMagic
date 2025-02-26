package com.example.contadorvidesmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.contadorvidesmagic.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Integer lifeP1;
    private Integer poisonP1;
    private Integer lifeP2;
    private Integer poisonP2;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null){
            lifeP1 = savedInstanceState.getInt("lifeP1");
            poisonP1 = savedInstanceState.getInt("poisonP1");
            lifeP2 = savedInstanceState.getInt("lifeP2");
            poisonP2 = savedInstanceState.getInt("poisonP2");
        }
        else {
            reset();
        }
        refresh();






        binding.BotonVenenoMasP1.setOnClickListener(v -> {
            poisonP1++;
            refresh();
        });
        binding.BotonVenenoMenosP1.setOnClickListener(v -> {
            poisonP1--;
            refresh();
        });
        binding.BotonSumarVenenoP2.setOnClickListener(v -> {
            poisonP2++;
            refresh();
        });
        binding.BotonRestarVenenoP2.setOnClickListener(v -> {
            poisonP2--;
            refresh();
        });

        binding.BotonSumarVidaP1.setOnClickListener(v -> {
            lifeP1++;
            refresh();
        });
        binding.BotonRestarVidaP1.setOnClickListener(v -> {
            lifeP1--;
            refresh();
        });
        binding.BotonSumarVidaP2.setOnClickListener(v -> {
            lifeP2++;
            refresh();
        });
        binding.BotonRestarVidaP2.setOnClickListener(v -> {
            lifeP2--;
            refresh();
        });
        binding.imageButton.setOnClickListener(v -> {
            if (lifeP2 > 0) {
                lifeP1++;
                lifeP2--;
                refresh();
            }
        });
        binding.imageButton2.setOnClickListener(v -> {
            if (lifeP1 > 0) {
                lifeP2++;
                lifeP1--;
                refresh();
            }
        });


    }


    private void refresh() {
        binding.TextoP1.setText(lifeP1 + "/" + poisonP1);
        binding.Texto2.setText(lifeP2 + "/" + poisonP2);
    }

    private void reset(){
        lifeP1 = 20;
        lifeP2 = 20;
        poisonP1 = 0;
        poisonP2 = 0;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lifeP1", lifeP1);
        outState.putInt("lifeP2", lifeP2);
        outState.putInt("poisonP1", poisonP1);
        outState.putInt("poisonP2", poisonP2);



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}