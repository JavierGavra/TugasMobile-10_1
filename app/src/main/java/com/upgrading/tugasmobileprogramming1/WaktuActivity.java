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

public class WaktuActivity extends AppCompatActivity {
    EditText txt_input, tv_output;
    Button btn_convert;
    ImageButton btn_back;

    String[] items = {"Detik", "Menit", "Jam", "Hari", "Minggu", "Tahun"};
    AutoCompleteTextView autoComplete1Txt, autoComplete2Txt;
    ArrayAdapter<String> adapterItems;

    String option1, option2, stringInput, stringResult;
    double input, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waktu);

        // Tombol Back
        btn_back = findViewById(R.id.btn_back_waktu);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_convert = findViewById(R.id.btn_convert_waktu);
        txt_input = findViewById(R.id.txt_input_waktu);
        tv_output = findViewById(R.id.tv_output_waktu);

        autoComplete1Txt = findViewById(R.id.autoComplete1_txt_waktu);
        autoComplete2Txt = findViewById(R.id.autoComplete2_txt_waktu);
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

    // Don't open it
    private String ifElseMenu(String option1, String option2, double input) {
        if (stringInput.trim().isEmpty()) {
            stringResult = "Kosong";
            return stringResult;
        }
        else if (option1.equals(items[0]) && option2.equals(items[0])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[0]) && option2.equals(items[1])) {
            result = detikToMenit(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[2])) {
            result = detikToJam(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[3])) {
            result = detikToHari(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[4])) {
            result = detikToMinggu(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[0]) && option2.equals(items[5])) {
            result = detikToTahun(input);
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[1]) && option2.equals(items[0])) {
            result = menitToDetik(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[1])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[1]) && option2.equals(items[2])) {
            result = detikToJam(menitToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[3])) {
            result = detikToHari(menitToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[4])) {
            result = detikToMinggu(menitToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[1]) && option2.equals(items[5])) {
            result = detikToTahun(menitToDetik(input));
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[2]) && option2.equals(items[0])) {
            result = jamToDetik(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[1])) {
            result = detikToMenit(jamToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[2])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[2]) && option2.equals(items[3])) {
            result = detikToHari(jamToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[4])) {
            result = detikToMinggu(jamToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[2]) && option2.equals(items[5])) {
            result = detikToTahun(jamToDetik(input));
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[3]) && option2.equals(items[0])) {
            result = hariToDetik(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[1])) {
            result = detikToMenit(hariToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[2])) {
            result = detikToJam(hariToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[3])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[3]) && option2.equals(items[4])) {
            result = detikToMinggu(hariToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[3]) && option2.equals(items[5])) {
            result = detikToTahun(hariToDetik(input));
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[4]) && option2.equals(items[0])) {
            result = mingguToDetik(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[1])) {
            result = detikToMenit(mingguToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[2])) {
            result = detikToJam(mingguToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[3])) {
            result = detikToHari(mingguToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[4]) && option2.equals(items[4])) {
            stringResult = stringInput;
            return stringResult;
        } else if (option1.equals(items[4]) && option2.equals(items[5])) {
            result = detikToTahun(mingguToDetik(input));
            stringResult = String.valueOf(result);
        }
        else if (option1.equals(items[5]) && option2.equals(items[0])) {
            result = tahunToDetik(input);
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[1])) {
            result = detikToMenit(tahunToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[2])) {
            result = detikToJam(tahunToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[3])) {
            result = detikToHari(tahunToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[4])) {
            result = detikToMinggu(tahunToDetik(input));
            stringResult = String.valueOf(result);
        } else if (option1.equals(items[5]) && option2.equals(items[5])) {
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

    // all to Detik
    private Double tahunToDetik(double tahun) {
        return (((tahun*365)*24)*60)*60;
    }
    private Double mingguToDetik(double minggu) {
        return (((minggu*7)*24)*60)*60;
    }
    private Double hariToDetik(double hari) {
        return ((hari*24)*60)*60;
    }
    private Double jamToDetik(double jam) {
        return (jam*60)*60;
    }
    private Double menitToDetik(double menit) {
        return menit*60;
    }

    // Detik to all
    private Double detikToMenit(double detik) {
        return detik/60;
    }
    private Double detikToJam(double detik) {
        return (detik/60)/60;
    }
    private Double detikToHari(double detik) {
        return ((detik/60)/60)/24;
    }
    private Double detikToMinggu(double detik) {
        return (((detik/7)/24)/60)/60;
    }
    private Double detikToTahun(double detik) {
        return (((detik/365)/24)/60)/60;
    }
}