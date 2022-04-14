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
import android.widget.Toast;

import java.util.Locale;

public class BeratActivity extends AppCompatActivity {
    EditText txt_input, tv_output;
    Button btn_convert;
    ImageButton btn_back;

    String[] items = {"kg", "hg", "dag", "g", "dg", "cg", "mg"};
    AutoCompleteTextView autoComplete1Txt, autoComplete2Txt;
    ArrayAdapter<String> adapterItems;

    String option1, option2, stringInput, stringResult;
    double input, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berat);

        // Tombol Back
        btn_back = findViewById(R.id.btn_back_berat);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_convert = findViewById(R.id.btn_convert_berat);
        txt_input = findViewById(R.id.txt_input_berat);
        tv_output = findViewById(R.id.tv_output_berat);

        autoComplete1Txt = findViewById(R.id.autoComplete1_txt_berat);
        autoComplete2Txt = findViewById(R.id.autoComplete2_txt_berat);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoComplete1Txt.setAdapter(adapterItems);
        autoComplete2Txt.setAdapter(adapterItems);

        autoComplete1Txt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent1, View view, int position1, long id1) {
                option1 = parent1.getItemAtPosition(position1).toString();
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

                stringResult = opsiMenu(option1, option2, input);
                tv_output.setText(String.valueOf(stringResult));
            }
        });


    }

    // Jangan di buka
    private String opsiMenu(String option1, String option2, double input) {
        try {
            if (stringInput.trim().isEmpty()) {
                stringResult = "Kosong";
            }
            else if (option1.equals(items[0]) && option2.equals(items[0])){
                stringResult = stringInput;
            } else if (option1.equals(items[0]) && option2.equals(items[1])) {

                result = MGtoHG(KGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[0]) && option2.equals(items[2])) {
                result = MGtoDAG(KGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[0]) && option2.equals(items[3])) {
                result = MGtoG(KGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[0]) && option2.equals(items[4])) {
                result = MGtoDG(KGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[0]) && option2.equals(items[5])) {
                result = MGtoCG(KGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[0]) && option2.equals(items[6])) {
                result = KGtoMG(input);
                stringResult = String.valueOf(result);
            }
            else if (option1.equals(items[1]) && option2.equals(items[0])) {
                result = MGtoKG(HGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[1]) && option2.equals(items[1])) {
                stringResult = stringInput;
            } else if (option1.equals(items[1]) && option2.equals(items[2])) {
                result = MGtoDAG(HGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[1]) && option2.equals(items[3])) {
                result = MGtoG(HGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[1]) && option2.equals(items[4])) {
                result = MGtoDG(HGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[1]) && option2.equals(items[5])) {
                result = MGtoCG(HGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[1]) && option2.equals(items[6])) {
                result = HGtoMG(input);
                stringResult = String.valueOf(result);
            }
            else if (option1.equals(items[2]) && option2.equals(items[0])) {
                result = MGtoKG(DAGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[2]) && option2.equals(items[1])) {
                result = MGtoHG(DAGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[2]) && option2.equals(items[2])) {
                stringResult = stringInput;
            } else if (option1.equals(items[2]) && option2.equals(items[3])) {
                result = MGtoG(DAGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[2]) && option2.equals(items[4])) {
                result = MGtoDG(DAGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[2]) && option2.equals(items[5])) {
                result = MGtoCG(DAGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[2]) && option2.equals(items[6])) {
                result = DAGtoMG(input);
                stringResult = String.valueOf(result);
            }
            else if (option1.equals(items[3]) && option2.equals(items[0])) {
                result = MGtoKG(GtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[3]) && option2.equals(items[1])) {
                result = MGtoHG(GtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[3]) && option2.equals(items[2])) {
                result = MGtoDAG(GtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[3]) && option2.equals(items[3])) {
                stringResult = stringInput;
            } else if (option1.equals(items[3]) && option2.equals(items[4])) {
                result = MGtoDG(GtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[3]) && option2.equals(items[5])) {
                result = MGtoCG(GtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[3]) && option2.equals(items[6])) {
                result = GtoMG(input);
                stringResult = String.valueOf(result);
            }
            else if (option1.equals(items[4]) && option2.equals(items[0])) {
                result = MGtoKG(DGtoMG(input));
                stringResult = String.format(Locale.GERMANY,"%,f", result);
            } else if (option1.equals(items[4]) && option2.equals(items[1])) {
                result = MGtoHG(DGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[4]) && option2.equals(items[2])) {
                result = MGtoDAG(DGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[4]) && option2.equals(items[3])) {
                result = MGtoG(DGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[4]) && option2.equals(items[4])) {
                stringResult = stringInput;
            } else if (option1.equals(items[4]) && option2.equals(items[5])) {
                result = MGtoCG(DGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[4]) && option2.equals(items[6])) {
                result = DGtoMG(input);
                stringResult = String.valueOf(result);
            }
            else if (option1.equals(items[5]) && option2.equals(items[0])) {
                result = MGtoKG(CGtoMG(input));
                stringResult = String.format(Locale.GERMANY,"%,f", result);
            } else if (option1.equals(items[5]) && option2.equals(items[1])) {
                result = MGtoHG(CGtoMG(input));
                stringResult = String.format(Locale.GERMANY,"%,f", result);
            } else if (option1.equals(items[5]) && option2.equals(items[2])) {
                result = MGtoDAG(CGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[5]) && option2.equals(items[3])) {
                result = MGtoG(CGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[5]) && option2.equals(items[4])) {
                result = MGtoDG(CGtoMG(input));
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[5]) && option2.equals(items[5])) {
                stringResult = stringInput;
            } else if (option1.equals(items[5]) && option2.equals(items[6])) {
                result = CGtoMG(input);
                stringResult = String.valueOf(result);
            }
            else if (option1.equals(items[6]) && option2.equals(items[0])) {
                result = MGtoKG(input);
                stringResult = String.format(Locale.GERMANY,"%,f", result);
            } else if (option1.equals(items[6]) && option2.equals(items[1])) {
                result = MGtoHG(input);
                stringResult = String.format(Locale.GERMANY,"%,f", result);
            } else if (option1.equals(items[6]) && option2.equals(items[2])) {
                result = MGtoDAG(input);
                stringResult = String.format(Locale.GERMANY,"%,f", result);
            } else if (option1.equals(items[6]) && option2.equals(items[3])) {
                result = MGtoG(input);
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[6]) && option2.equals(items[4])) {
                result = MGtoDG(input);
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[6]) && option2.equals(items[5])) {
                result = MGtoCG(input);
                stringResult = String.valueOf(result);
            } else if (option1.equals(items[6]) && option2.equals(items[6])) {
                stringResult = stringInput;
            } else {
                stringResult = "comming soon";
            }
        } catch (Exception e) {
            stringResult = "Opsi belum dipilih";
        }

        return stringResult;
    }

    // all to MG
    private double KGtoMG(double KG) {
        return KG * 1000000;
    }
    private double HGtoMG(double HG) {
        return HG * 100000;
    }
    private double DAGtoMG(double DAG) {
        return DAG * 10000;
    }
    private double GtoMG(double G) {
        return G * 1000;
    }
    private double DGtoMG(double DG) {
        return DG * 100;
    }
    private double CGtoMG(double CG) {
        return CG * 10;
    }

    // MG to all
    private double MGtoKG(double MG) {
        return MG / 1000000;
    }
    private double MGtoHG(double MG) {
        return MG / 100000;
    }
    private double MGtoDAG(double MG) {
        return MG / 10000;
    }
    private double MGtoG(double MG) {
        return MG / 1000;
    }
    private double MGtoDG(double MG) {
        return MG / 100;
    }
    private double MGtoCG(double MG) {
        return MG / 10;
    }
}