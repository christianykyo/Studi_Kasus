package com.example.studikasus;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //meyimpan data saat ganti ke landscape/potrait
    private static final String STATE_RESULT = "state_result";
    private EditText name, bornplace, borndate, address, number, hobby, hope;
    private Button submit;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pemanggilan data
        name = findViewById(R.id.name);
        bornplace = findViewById(R.id.bornplace);
        borndate = findViewById(R.id.borndate);
        address = findViewById(R.id.address);
        number = findViewById(R.id.number);
        hobby = findViewById(R.id.hobby);
        hope = findViewById(R.id.hope);
        submit = findViewById(R.id.submit);
        tvResult = findViewById(R.id.result);
        submit.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View v) {
        //penempatan data ke string baru
        if (v.getId() == R.id.submit) {
            String inputName = String.valueOf(name.getText());
            String inputBornplace = String.valueOf(bornplace.getText());
            String inputBorndate = String.valueOf(borndate.getText());
            String inputAddress = String.valueOf(address.getText());
            String inputNumber = String.valueOf(number.getText());
            String inputHobby = String.valueOf(hobby.getText());
            String inputHope = String.valueOf(hope.getText());

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            //untuk check string jika kosong
            if (TextUtils.isEmpty(inputName)) {
                isEmptyFields = true;
                name.setError("Kolom ini harus diisi.");
            }

            if (TextUtils.isEmpty(inputBornplace)) {
                isEmptyFields = true;
                bornplace.setError("Kolom ini harus diisi.");
            }

            if (TextUtils.isEmpty(inputBorndate)) {
                isEmptyFields = true;
                borndate.setError("Kolom ini harus diisi.");
            }
            if (TextUtils.isEmpty(inputAddress)) {
                isEmptyFields = true;
                address.setError("Kolom ini harus diisi.");
            }

            if (TextUtils.isEmpty(inputNumber)) {
                isEmptyFields = true;
                number.setError("Kolom ini harus diisi.");
            }

            if (TextUtils.isEmpty(inputHobby)) {
                isEmptyFields = true;
                hobby.setError("Kolom ini harus diisi.");
            }
            if (TextUtils.isEmpty(inputHope)) {
                isEmptyFields = true;
                hope.setError("Kolom ini harus diisi.");
            }


            //cek double jika kosong
            Double length = toDouble(inputNumber);
            if (length == null) {
                isInvalidDouble = true;
                number.setError("Kolom ini harus berupa nomer yang valid");
            }

            if (!isEmptyFields && !isInvalidDouble) {
                String value = "Nama: " + inputName + "\n" + "\n Tempat Lahir: " + inputBornplace + "\n" + "\n Tanggal Lahir: " + inputBorndate + "\n" + "\n Alamat: " + inputAddress + "\n" + "\n No. HP: " + inputNumber + "\n" + "\n Hobby: " + inputHobby + "\n" + "\n Keinginan: " + inputHope;
                tvResult.setText(value);
            }

        }
    }

    //untuk pengecekan double jika kosong
    private Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}