package com.ezediaz.listadeinmuebles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Inmueble>> listaInmueblesMutableLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void cargarInmuebles() {
        List<Inmueble> listaInmuebles = new ArrayList<>();
        listaInmuebles.add(new Inmueble(R.drawable.casa1, "San Luis", 70000));
        listaInmuebles.add(new Inmueble(R.drawable.casa2, "Potrero de los Funes", 80000));
        listaInmuebles.add(new Inmueble(R.drawable.casa3, "Villa Mercedes", 90000));
        listaInmuebles.add(new Inmueble(R.drawable.casa4, "Conlara", 100000));
        listaInmuebles.add(new Inmueble(R.drawable.casa5, "Villa de Merlo", 110000));
        listaInmueblesMutableLiveData.setValue(listaInmuebles);
    }

    public LiveData<List<Inmueble>> getListaInmueblesLiveData() {
        if(listaInmueblesMutableLiveData == null){
            listaInmueblesMutableLiveData = new MutableLiveData<>();
        }
        return listaInmueblesMutableLiveData;
    }
}

