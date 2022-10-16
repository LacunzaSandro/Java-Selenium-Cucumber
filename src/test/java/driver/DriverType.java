package driver;

public class DriverType {
    public static String getDriverType() {
        String driverName = System.getProperty("driverName");
        if (driverName == null) {
            return "CHROME";
        } else {
            return driverName;
        }
    }
}
