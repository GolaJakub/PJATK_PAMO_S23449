package pl.edu.pjatk.PAMO_S23449;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class KcalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.kcal_activity);
        configureBackButton();
        EditText weightValue = findViewById(R.id.weight);
        EditText heightValue = findViewById(R.id.height);
        EditText ageValue = findViewById(R.id.age);
        Button calculateButton = findViewById(R.id.calculate);
        TextView kcalResult = findViewById(R.id.kcal);
        AutoCompleteTextView sex = findViewById(R.id.sex);
        TextInputLayout weightInputLayout = findViewById(R.id.weightInputLayout);
        TextInputLayout heightInputLayout = findViewById(R.id.heightInputLayout);
        TextInputLayout ageInputLayout = findViewById(R.id.ageInputLayout);
        TextInputLayout sexLayout = findViewById(R.id.sexLayout);
        final String[] selectedSex = {null};

        String[] type = new String[]{"Mężczyzna", "Kobieta"};
        ArrayAdapter<String> adapterType = new ArrayAdapter<>(
                KcalActivity.this,
                R.layout.custom_sex_view,
                type
        );

        sex.setAdapter(adapterType);

        sex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedSex[0] = parent.getItemAtPosition(position).toString();
            }
        });

        calculateButton.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(calculateButton.getWindowToken(), 0);

            if (weightValue.getText().toString().trim().isEmpty()) {
                weightInputLayout.setError("To pole jest wymagane");
                return;
            } else {
                weightInputLayout.setError(null);
            }

            if (heightValue.getText().toString().trim().isEmpty()) {
                heightInputLayout.setError("To pole jest wymagane");
                return;
            } else {
                heightInputLayout.setError(null);
            }

            if (ageValue.getText().toString().trim().isEmpty()) {
                ageInputLayout.setError("To pole jest wymagane");
                return;
            } else {
                ageInputLayout.setError(null);
            }

            if (selectedSex[0] == null) {
                sexLayout.setError("To pole jest wymagane");
                return;
            } else {
                sexLayout.setError(null);
            }

            float weight = Float.parseFloat(String.valueOf(weightValue.getText()));
            float height = Float.parseFloat(String.valueOf(heightValue.getText()));
            float age = Float.parseFloat(String.valueOf(ageValue.getText()));
            double kcal;

            switch (selectedSex[0]) {
                case "Mężczyzna":
                    kcal = (float) 66.473 + (13.752 * weight) + (5.003 * height) - (6.775 * age);
                    break;
                case "Kobieta":
                default:
                    kcal = (float) 655.1 + (9.564 * weight) + (1.85 * height) - (4.676 * age);
                    break;
            }
            kcalResult.setText(String.valueOf(kcal));
        });
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KcalActivity.this, HomeActivity.class));
            }
        });
    }
}
