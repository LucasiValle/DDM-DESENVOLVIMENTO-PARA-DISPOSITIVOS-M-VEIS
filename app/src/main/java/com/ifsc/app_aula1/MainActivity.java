package com.ifsc.app_aula1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    Button colorButton;
    SimplesPaint simplesPaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorButton = findViewById(R.id.btnColors);
        simplesPaint=findViewById(R.id.simplesPaint);
        colorButton.setOnClickListener(v -> {


            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("confirma",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setLayoutColor(envelope);
                                }
                            })
                    .setNegativeButton("cancela",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        });

    }
    public void setLayoutColor(ColorEnvelope envelope){
        simplesPaint.setColor(envelope.getColor());
    }
}