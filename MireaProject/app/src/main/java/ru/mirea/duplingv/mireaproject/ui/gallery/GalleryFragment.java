package ru.mirea.duplingv.mireaproject.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Random;

import ru.mirea.duplingv.mireaproject.R;
import ru.mirea.duplingv.mireaproject.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    final Random randomGenerator = new Random();
    final ArrayList sample = new ArrayList() {{ add("Барсуки"); add("Жители морских глубин"); add("Азиатские мифы о чудовищах"); add("Примеры неоднозначности математических терминов в культуре древних инков");}};
    private FragmentGalleryBinding binding;
    String item;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.button2.setOnClickListener(v -> {
            String tmp_text = (String) ((TextView) v.findViewById(R.id.editTextSubject)).getText();
            if (tmp_text.equals(""))
                item = (String) sample.get(randomGenerator.nextInt(sample.size()));
            else
                item = tmp_text;
            ((TextView) v.findViewById(R.id.textView3)).setText(item);
        });

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        item = (String) sample.get(randomGenerator.nextInt(sample.size()));
        ((TextView) root.findViewById(R.id.textView3)).setText(item);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}