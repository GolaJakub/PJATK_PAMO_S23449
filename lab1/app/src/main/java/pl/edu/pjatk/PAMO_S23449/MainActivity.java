package pl.edu.pjatk.PAMO_S23449;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText weightValue = findViewById(R.id.weight);
        EditText heightValue = findViewById(R.id.height);
        Button calculateButton = findViewById(R.id.calculate);
        TextView result = findViewById(R.id.result);

        calculateButton.setOnClickListener(v -> {
            float weight = Float.parseFloat(String.valueOf(weightValue.getText()));
            float height = Float.parseFloat(String.valueOf(heightValue.getText())) / 100;
            float bmi = weight / (height * height);
            result.setText(String.valueOf(bmi));
        });
    }
}