package pl.edu.pjatk.PAMO_S23449;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_activity);
        configureBmiButton();
        configureKcalButton();
        configureRecipiesButton();
        configureBmiChartButton();
    }

    private void configureBmiButton() {
        Button bmiButton = (Button) findViewById(R.id.bmiCalculatorButton);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BmiActivity.class));
            }
        });
    }

    private void configureKcalButton() {
        Button kcalButton = (Button) findViewById(R.id.dailyKcalButton);
        kcalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, KcalActivity.class));
            }
        });
    }

    private void configureRecipiesButton() {
        Button recipiesButton = (Button) findViewById(R.id.recommendedRecipiesButton);
        recipiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RecipiesActivity.class));
            }
        });
    }

    private void configureBmiChartButton() {
        Button recipiesButton = (Button) findViewById(R.id.bmiChartButton);
        recipiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BmiProgressActivity.class));
            }
        });
    }

}
