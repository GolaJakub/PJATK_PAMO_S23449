package pl.edu.pjatk.PAMO_S23449;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class BmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bmi_activity);
        configureBackButton();
        EditText weightValue = findViewById(R.id.weight);
        EditText heightValue = findViewById(R.id.height);
        Button calculateButton = findViewById(R.id.calculate);
        TextView result = findViewById(R.id.result);
        TextInputLayout weightInputLayout = findViewById(R.id.weightInputLayout);
        TextInputLayout heightInputLayout = findViewById(R.id.heightInputLayout);

        calculateButton.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(calculateButton.getWindowToken(), 0);
            if (weightValue.getText().toString().trim().isEmpty()) {
                weightInputLayout.setError("To pole jest wymagane");
                return;
            }

            if (heightValue.getText().toString().trim().isEmpty()) {
                heightInputLayout.setError("To pole jest wymagane");
                return;
            }

            double weight = Float.parseFloat(String.valueOf(weightValue.getText()));
            double height = Float.parseFloat(String.valueOf(heightValue.getText())) / 100;
            double bmi = calculateBmi(weight, height);
            result.setText(String.valueOf(bmi));
        });
    }

    public double calculateBmi(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            return Double.NaN;
        }
        return weight / (height * height);
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BmiActivity.this, HomeActivity.class));
            }
        });
    }
}