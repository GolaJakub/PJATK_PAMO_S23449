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

        calculateButton.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(calculateButton.getWindowToken(), 0);

            float weight = Float.parseFloat(String.valueOf(weightValue.getText()));
            float height = Float.parseFloat(String.valueOf(heightValue.getText())) / 100;
            float bmi = weight / (height * height);
            result.setText(String.valueOf(bmi));
        });
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