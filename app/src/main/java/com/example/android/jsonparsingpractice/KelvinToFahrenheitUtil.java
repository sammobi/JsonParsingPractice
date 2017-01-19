package com.example.android.jsonparsingpractice;

import java.text.DecimalFormat;

/**
 * Created by sandeep on 1/18/2017.
 */

public class KelvinToFahrenheitUtil {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return ((fahrenheit * 9 / 5) - 459.67);
    }

    public class roundTwoDecimals {

        public double roundTwoDecimals(double d) {

            DecimalFormat twoDForm = new DecimalFormat("#.##");
            return Double.valueOf(twoDForm.format(d));
        }
    }
}
