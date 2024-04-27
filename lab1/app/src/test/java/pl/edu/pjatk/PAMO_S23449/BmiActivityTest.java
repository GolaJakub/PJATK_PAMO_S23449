package pl.edu.pjatk.PAMO_S23449;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest= Config.NONE)
public class BmiActivityTest {

    private BmiActivity bmiActivity;

    @Before
    public void setup() {
     bmiActivity = new BmiActivity();
    }

    @Test
    public void testCalculateBmi() {
        double weight = 70.0;
        double height = 1.75;
        double bmi = bmiActivity.calculateBmi(weight, height);
        assertEquals(22.22, bmi, 1.1);
    }

    @Test
    public void testCalculateBmiWithZeroHeight() {
        double weight = 70.0;
        double height = 0.0;
        double bmi = bmiActivity.calculateBmi(weight, height);
        assertEquals(Double.NaN, bmi, 0.01);
    }

    @Test
    public void testCalculateBmiWithNegativeWeight() {

        double weight = -70.0;
        double height = 1.75;
        double bmi = bmiActivity.calculateBmi(weight, height);
        assertEquals(Double.NaN, bmi, 0.01);
    }

    @Test
    public void testCalculateBmiWithNegativeHeight() {
        double weight = 70.0;
        double height = -1.75;
        double bmi = bmiActivity.calculateBmi(weight, height);
        assertEquals(Double.NaN, bmi, 0.01);
    }
}
