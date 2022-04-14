package com.upgrading.tugasmobileprogramming1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class TemperaturActivity extends AppCompatActivity {
    EditText txt_input, tv_output;
    Button btn_convert;
    ImageButton btn_back;

    String[] items = {"Fahrenheit", "Celcius", "Kelvin"};
    AutoCompleteTextView autoComplete1Txt, autoComplete2Txt;
    ArrayAdapter<String> adapterItems;

    String option1, option2, stringInput, stringResult;
    double input, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatur);

        // Tombol Back
        btn_back = findViewById(R.id.btn_back_temper);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_convert = findViewById(R.id.btn_convert_temper);
        txt_input = findViewById(R.id.txt_input_temper);
        tv_output = findViewById(R.id.tv_output_temper);

        autoComplete1Txt = findViewById(R.id.autoComplete1_txt_temper);
        autoComplete2Txt = findViewById(R.id.autoComplete2_txt_temper);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoComplete1Txt.setAdapter(adapterItems);
        autoComplete2Txt.setAdapter(adapterItems);

        autoComplete1Txt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                option1 = parent.getItemAtPosition(position).toString();
            }
        });
        autoComplete2Txt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent2, View view, int position2, long id2) {
                option2 = parent2.getItemAtPosition(position2).toString();
            }
        });

        // Button Eksekusi
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringInput = txt_input.getText().toString();
                if (stringInput.trim().isEmpty()) {
                    input = 0;
                } else {
                    input = Double.parseDouble(stringInput);
                }

                stringResult = ifElseMenu(option1, option2, input);
                tv_output.setText(String.valueOf(stringResult));
            }
        });
    }


    // IF ELSE
    private String ifElseMenu(String option1, String option2, double input) {
        try {
            if (stringInput.trim().isEmpty()) {
                stringResult = "Kosong";
                return stringResult;
            }
            else if (option1.equals(items[0]) && option2.equals(items[0])) {
                stringResult = stringInput;
                return stringResult;
            } else if (option1.equals(items[0]) && option2.equals(items[1])) {
                result = FtoC(input);
            } else if (option1.equals(items[0]) && option2.equals(items[2])) {
                result = FtoK(input);
            }
            else if (option1.equals(items[1]) && option2.equals(items[0])) {
                result = CtoF(input);
            } else if (option1.equals(items[1]) && option2.equals(items[1])) {
                stringResult = stringInput;
                return stringResult;
            } else if (option1.equals(items[1]) && option2.equals(items[2])) {
                result = CtoK(input);
            }
            else if (option1.equals(items[2]) && option2.equals(items[0])) {
                result = KtoF(input);
            } else if (option1.equals(items[2]) && option2.equals(items[1])) {
                result = KtoC(input);
            } else if (option1.equals(items[2]) && option2.equals(items[2])) {
                stringResult = stringInput;
                return stringResult;
            }
            else {
                stringResult = "comming soon";
            }
        } catch (Exception e) {
            stringResult = "Opsi belum dipilih";
        }

        int angkaSignifikan = 3;
        double temp = Math.pow(10, angkaSignifikan);
        double x = (double) Math.round(result*temp)/temp;
        stringResult = String.valueOf(x);
        return stringResult;
    }

    // F to all
    private Double FtoC(double F) {
        return (F - 32) * 5/9;
    }
    private Double FtoK(double F) {
        return (F - 32) * 5/9 + 273.15;
    }

    // C to all
    private Double CtoF(double C) {
        return (C * 9/5) + 32;
    }
    private Double CtoK(double C) {
        return C + 273.15;
    }

    // K to all
    private Double KtoF(double K) {
        return (K - 273.15) * 9/5 + 32;
    }
    private Double KtoC(double K) {
        return K - 273.15;
    }
}