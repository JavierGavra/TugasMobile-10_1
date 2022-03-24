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

import java.util.Locale;

public class DataActivity extends AppCompatActivity {
    EditText txt_input, tv_output;
    Button btn_convert;
    ImageButton btn_back;

    String[] items = {"TeraBytes", "GigaBytes", "MegaBytes", "KiloBytes", "Bytes"};
    AutoCompleteTextView autoComplete1Txt, autoComplete2Txt;
    ArrayAdapter<String> adapterItems;

    String option1, option2, stringInput, stringResult;
    double input, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // Tombol Back
        btn_back = findViewById(R.id.btn_back_data);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_convert = findViewById(R.id.btn_convert_data);
        txt_input = findViewById(R.id.txt_input_data);
        tv_output = findViewById(R.id.tv_output_data);

        autoComplete1Txt = findViewById(R.id.autoComplete1_txt_data);
        autoComplete2Txt = findViewById(R.id.autoComplete2_txt_data);
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


    // Jangan dibuka!!!
    private String ifElseMenu(String option1, String option2, double input) {
        if (stringInput.trim().isEmpty()) {
            stringResult = "Kosong";
        }
        else if (option1.equals(items[0]) && option2.equals(items[0])){
            stringResult = stringInput;
        } else if (option1.equals(items[0]) && option2.equals(items[1])) {
            result = BytestoGiga(TeratoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[2])) {
            result = BytestoMega(TeratoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[3])) {
            result = BytestoKilo(TeratoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[4])) {
            result = TeratoBytes(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[1]) && option2.equals(items[0])){
            result = BytestoTera(GigatoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[1])) {
            stringResult = stringInput;
        } else if (option1.equals(items[1]) && option2.equals(items[2])) {
            result = BytestoMega(GigatoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[3])) {
            result = BytestoKilo(GigatoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[4])) {
            result = GigatoBytes(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[2]) && option2.equals(items[0])){
            result = BytestoTera(MegatoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[1])) {
            result = BytestoGiga(MegatoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[2])) {
            stringResult = stringInput;
        } else if (option1.equals(items[2]) && option2.equals(items[3])) {
            result = BytestoKilo(MegatoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[4])) {
            result = MegatoBytes(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[3]) && option2.equals(items[0])){
            result = BytestoTera(KilotoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[1])) {
            result = BytestoGiga(KilotoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[2])) {
            result = BytestoMega(KilotoBytes(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[3])) {
            stringResult = stringInput;
        } else if (option1.equals(items[3]) && option2.equals(items[4])) {
            result = KilotoBytes(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[4]) && option2.equals(items[0])){
            result = BytestoTera(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[1])) {
            result = BytestoGiga(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[2])) {
            result = BytestoMega(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[3])) {
            result = KilotoBytes(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[4])) {
            stringResult = stringInput;
        }
        else {
            stringResult = "comming soon";
        }

        return stringResult;
    }

    // all to bytes
    private double TeratoBytes(double tera) {
        return (tera * 1000000000) * 1000;
    }
    private double GigatoBytes(double giga) {
        return giga * 1000000000;
    }
    private double MegatoBytes(double mega) {
        return mega * 1000000;
    }
    private double KilotoBytes(double kilo) {
        return kilo * 1000;
    }

    // Bytes to all
    private double BytestoTera(double bytes) {
        return (bytes / 1000000000) / 1000;
    }
    private double BytestoGiga(double bytes) {
        return bytes / 1000000000;
    }
    private double BytestoMega(double bytes) {
        return bytes / 1000000;
    }
    private double BytestoKilo(double bytes) {
        return bytes / 1000;
    }
}