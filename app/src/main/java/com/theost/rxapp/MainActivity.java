package com.theost.rxapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.theost.rxapp.databinding.ActivityMainBinding;

import java.util.Objects;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            String text = Objects.requireNonNull(binding.editText.getText()).toString();
            binding.button.setVisibility(View.GONE);
            binding.progressBar.setVisibility(View.VISIBLE);
            compositeDisposable.add(
                    Api.getData().map(
                                    apiObjects -> apiObjects
                                            .stream()
                                            .filter(apiObject ->
                                                            apiObject
                                                                    .getValue().contains(text)
                                            )
                                            .limit(10)
                                            .collect(Collectors.toList())
                            )
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(apiObjects -> {
                                binding.textView.setText(apiObjects.toString());
                                binding.progressBar.setVisibility(View.GONE);
                                binding.button.setVisibility(View.VISIBLE);
                            }, Throwable::printStackTrace)
            );

        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
