

import java.util.ArrayList;
import java.util.List;

//
public class Database {

    private static double rateUsEu = 1.2;
    private static double rateEuUs = 0.8;

    public static double getRateUsEu() {
        return rateUsEu;
    }

    public static void setRateUsEu(double rate) {
        rateUsEu = rate;
    }

    public static double getRateEuUs() {
        return rateEuUs;
    }

    public static void setRateEuUs(double rate) {
        rateEuUs = rate;
    }

}
