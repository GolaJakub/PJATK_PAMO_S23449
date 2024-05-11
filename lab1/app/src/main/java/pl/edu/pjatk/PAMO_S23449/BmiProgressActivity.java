package pl.edu.pjatk.PAMO_S23449;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class BmiProgressActivity extends AppCompatActivity {

    private LineChart mBmiChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_progress);

        mBmiChart = findViewById(R.id.bmi_chart);

        // Set chart properties
        Description description = new Description();
        description.setText("BMI Changes Over Time");
        mBmiChart.setDescription(description);
        mBmiChart.setNoDataText("No data available");
        mBmiChart.setDrawGridBackground(false);
        mBmiChart.setDrawBorders(false);
        mBmiChart.setHighlightPerDragEnabled(false);
        mBmiChart.setHighlightPerTapEnabled(false);
        mBmiChart.setDragEnabled(false);
        mBmiChart.setScaleEnabled(false);
        mBmiChart.setPinchZoom(false);

        // Add data to the chart
        addBmiData();
    }

    private void addBmiData() {
        // Add mock BMI data to the chart
        List<Entry> bmiEntries = new ArrayList<>();
        bmiEntries.add(new Entry(1f, 25f));
        bmiEntries.add(new Entry(2f, 24f));
        bmiEntries.add(new Entry(3f, 26f));
        bmiEntries.add(new Entry(4f, 23f));
        bmiEntries.add(new Entry(5f, 27f));

        LineDataSet bmiDataSet = new LineDataSet(bmiEntries, "BMI");
        bmiDataSet.setColor(Color.BLUE);
        bmiDataSet.setDrawCircles(false);
        bmiDataSet.setDrawValues(false);

        LineData data = new LineData(bmiDataSet);
        mBmiChart.setData(data);
        mBmiChart.invalidate();
    }
}