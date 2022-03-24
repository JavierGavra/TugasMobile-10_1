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

public class KecepatanActivity extends AppCompatActivity {
    EditText txt_input, tv_output;
    Button btn_convert;
    ImageButton btn_back;

    String[] items = {"Mil/Jam", "KM/Jam", "M/Detik"};
    AutoCompleteTextView autoComplete1Txt, autoComplete2Txt;
    ArrayAdapter<String> adapterItems;

    String option1, option2, stringInput, stringResult;
    double input, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecepatan);

        // Tombol Back
        btn_back = findViewById(R.id.btn_back_cepat);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_convert = findViewById(R.id.btn_convert_cepat);
        txt_input = findViewById(R.id.txt_input_cepat);
        tv_output = findViewById(R.id.tv_output_cepat);

        autoComplete1Txt = findViewById(R.id.autoComplete1_txt_cepat);
        autoComplete2Txt = findViewById(R.id.autoComplete2_txt_cepat);
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


    // Jangan di buka
    private String ifElseMenu(String option1, String option2, double input) {
        if (stringInput.trim().isEmpty()) {
            stringResult = "Kosong";
            return stringResult;
        }
        else if (option1.equals(items[0]) && option2.equals(items[0])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[0]) && option2.equals(items[1])) {
            result = milToKM(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[2])) {
            result = milToM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[1]) && option2.equals(items[0])) {
            result = kmToMil(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[1])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[1]) && option2.equals(items[2])) {
            result = kmToM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[2]) && option2.equals(items[0])) {
            result = mToMil(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[1])) {
            result = mToKM(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[2])) {
            stringResult = stringInput;
            return stringResult;
        } else {
            stringResult = "comming soon";
        }

        int angkaSignifikan = 6;
        double temp = Math.pow(10, angkaSignifikan);
        double x = (double) Math.round(result*temp)/temp;
        stringResult = String.valueOf(x);
        return stringResult;
    }

    // Mil to all
    private double milToKM(double mil) {
        return mil * 1.609;
    }
    private double milToM(double mil) {
        return mil / 2.237;
    }

    // Km to all
    private double kmToMil(double km) {
        return km / 1.609;
    }
    private double kmToM(double km) {
        return km / 3.6;
    }

    // M to all
    private double mToMil(double m) {
        return m * 2.237;
    }
    private double mToKM(double m) {
        return m * 3.6;
    }
}