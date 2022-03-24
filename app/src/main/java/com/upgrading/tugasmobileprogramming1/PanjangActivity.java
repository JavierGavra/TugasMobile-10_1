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

public class PanjangActivity extends AppCompatActivity {
    EditText txt_input, tv_output;
    Button btn_convert;
    ImageButton btn_back;

    String[] items = {"km", "hm", "dam", "m", "dm", "cm", "mm"};
    AutoCompleteTextView autoComplete1Txt, autoComplete2Txt;
    ArrayAdapter<String> adapterItems;

    String option1, option2, stringInput, stringResult;
    double input, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panjang);

        // Tombol Back
        btn_back = findViewById(R.id.btn_back_panjang);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_convert = findViewById(R.id.btn_convert_panjang);
        txt_input = findViewById(R.id.txt_input_panjang);
        tv_output = findViewById(R.id.tv_output_panjang);

        autoComplete1Txt = findViewById(R.id.autoComplete1_txt_panjang);
        autoComplete2Txt = findViewById(R.id.autoComplete2_txt_panjang);
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
            result = MMtoHM(KMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[2])) {
            result = MMtoDAM(KMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[3])) {
            result = MMtoM(KMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[4])) {
            result = MMtoDM(KMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[5])) {
            result = MMtoCM(KMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[6])) {
            result = KMtoMM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[1]) && option2.equals(items[0])) {
            result = MMtoKM(HMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[1])) {
            stringResult = stringInput;
        } else if (option1.equals(items[1]) && option2.equals(items[2])) {
            result = MMtoDAM(HMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[3])) {
            result = MMtoM(HMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[4])) {
            result = MMtoDM(HMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[5])) {
            result = MMtoCM(HMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[6])) {
            result = HMtoMM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[2]) && option2.equals(items[0])) {
            result = MMtoKM(DAMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[1])) {
            result = MMtoHM(DAMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[2])) {
            stringResult = stringInput;
        } else if (option1.equals(items[2]) && option2.equals(items[3])) {
            result = MMtoM(DAMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[4])) {
            result = MMtoDM(DAMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[5])) {
            result = MMtoCM(DAMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[6])) {
            result = DAMtoMM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[3]) && option2.equals(items[0])) {
            result = MMtoKM(MtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[1])) {
            result = MMtoHM(MtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[2])) {
            result = MMtoDAM(MtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[3])) {
            stringResult = stringInput;
        } else if (option1.equals(items[3]) && option2.equals(items[4])) {
            result = MMtoDM(MtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[5])) {
            result = MMtoCM(MtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[6])) {
            result = MtoMM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[4]) && option2.equals(items[0])) {
            result = MMtoKM(DMtoMM(input));
            stringResult = String.format(Locale.GERMANY,"%,f", result);
        } else if (option1.equals(items[4]) && option2.equals(items[1])) {
            result = MMtoHM(DMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[2])) {
            result = MMtoDAM(DMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[3])) {
            result = MMtoM(DMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[4])) {
            stringResult = stringInput;
        } else if (option1.equals(items[4]) && option2.equals(items[5])) {
            result = MMtoCM(DMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[6])) {
            result = DMtoMM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[5]) && option2.equals(items[0])) {
            result = MMtoKM(CMtoMM(input));
            stringResult = String.format(Locale.GERMANY,"%,f", result);
        } else if (option1.equals(items[5]) && option2.equals(items[1])) {
            result = MMtoHM(CMtoMM(input));
            stringResult = String.format(Locale.GERMANY,"%,f", result);
        } else if (option1.equals(items[5]) && option2.equals(items[2])) {
            result = MMtoDAM(CMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[3])) {
            result = MMtoM(CMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[4])) {
            result = MMtoDM(CMtoMM(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[5])) {
            stringResult = stringInput;
        } else if (option1.equals(items[5]) && option2.equals(items[6])) {
            result = CMtoMM(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[6]) && option2.equals(items[0])) {
            result = MMtoKM(input);
            stringResult = String.format(Locale.GERMANY,"%,f", result);
        } else if (option1.equals(items[6]) && option2.equals(items[1])) {
            result = MMtoHM(input);
            stringResult = String.format(Locale.GERMANY,"%,f", result);
        } else if (option1.equals(items[6]) && option2.equals(items[2])) {
            result = MMtoDAM(input);
            stringResult = String.format(Locale.GERMANY,"%,f", result);
        } else if (option1.equals(items[6]) && option2.equals(items[3])) {
            result = MMtoM(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[6]) && option2.equals(items[4])) {
            result = MMtoDM(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[6]) && option2.equals(items[5])) {
            result = MMtoCM(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[6]) && option2.equals(items[6])) {
            stringResult = stringInput;
        } else {
            stringResult = "comming soon";
        }

        return stringResult;
    }

    // all to MM
    private double KMtoMM(double KM) {
        return KM * 1000000;
    }
    private double HMtoMM(double HM) {
        return HM * 100000;
    }
    private double DAMtoMM(double DAM) {
        return DAM * 10000;
    }
    private double MtoMM(double M) {
        return M * 1000;
    }
    private double DMtoMM(double DM) {
        return DM * 100;
    }
    private double CMtoMM(double CM) {
        return CM * 10;
    }

    // MM to all
    private double MMtoKM(double MM) {
        return MM / 1000000;
    }
    private double MMtoHM(double MM) {
        return MM / 100000;
    }
    private double MMtoDAM(double MM) {
        return MM / 10000;
    }
    private double MMtoM(double MM) {
        return MM / 1000;
    }
    private double MMtoDM(double MM) {
        return MM / 100;
    }
    private double MMtoCM(double MM) {
        return MM / 10;
    }
}