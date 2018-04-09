package net.unadeca.ana.examencal.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.unadeca.ana.examencal.R;

/**
 * Created by ANA on 08/04/2018.
 */

public class ResultadosActivityFragments extends Fragment {
    public ResultadosActivityFragments(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_historialver, container, false);
    }
}


