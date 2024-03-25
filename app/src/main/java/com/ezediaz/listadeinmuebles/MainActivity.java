package com.ezediaz.listadeinmuebles;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ezediaz.listadeinmuebles.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel vm;
    private InmuebleAdapter inmuebleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Inmueble> listaInmuebles = new ArrayList<>();
        listaInmuebles.add(new Inmueble(R.drawable.casa1, "San Luis", 70000));
        listaInmuebles.add(new Inmueble(R.drawable.casa2, "Potrero de los Funes", 80000));
        listaInmuebles.add(new Inmueble(R.drawable.casa3, "Villa Mercedes", 90000));
        listaInmuebles.add(new Inmueble(R.drawable.casa4, "Conlara", 100000));
        listaInmuebles.add(new Inmueble(R.drawable.casa5, "Villa de Merlo", 110000));
        inmuebleAdapter = new InmuebleAdapter(this, listaInmuebles);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getListaInmueblesLiveData().observe(this, inmuebles -> {
            // Actualizar el adaptador cuando cambian los datos
            inmuebleAdapter.setInmuebles(inmuebles);
        });
        binding.lvListaDeInmuebles.setAdapter(inmuebleAdapter);
    }
}
