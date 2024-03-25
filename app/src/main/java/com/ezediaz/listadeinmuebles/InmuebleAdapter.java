package com.ezediaz.listadeinmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.ezediaz.listadeinmuebles.databinding.ItemBinding;
import java.util.List;

public class InmuebleAdapter extends ArrayAdapter<Inmueble> {

    private List<Inmueble> inmuebles;
    private Context context;

    public InmuebleAdapter(Context context, List<Inmueble> inmuebles) {
        super(context, 0, inmuebles);
        this.context = context;
        this.inmuebles = inmuebles;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemBinding binding;

        if (convertView == null) {
            binding = ItemBinding.inflate(LayoutInflater.from(context), parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemBinding) convertView.getTag();
        }

        Inmueble inmueble = inmuebles.get(position);
        binding.tvDireccion.setText(inmueble.getDireccion());
        binding.tvPrecio.setText(String.valueOf(inmueble.getPrecio()));
        binding.ivFoto.setImageResource(inmueble.getFoto());

        return convertView;
    }
}
