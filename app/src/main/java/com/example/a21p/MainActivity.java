package com.example.a21p;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText celsiusInput;
    Button convertButton;
    TextView resultText;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        celsiusInput = findViewById(R.id.celciusInput);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = celsiusInput.getText().toString();

                if (inputStr.isEmpty()){
                    resultText.setText("Please enter your value");
                }

                else {
                    double celcius = 0;

                    try {
                        celcius = Double.parseDouble(inputStr);
                    } catch (NumberFormatException e) {
                        resultText.setText("Invalid Number");
                    }

                    double fahrenheit = (celcius * 1.8) + 32;

                    resultText.setText(String.format("Result: %.2f F", fahrenheit));
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}