public class Lab02 {
    public static void main(String[] args) {
        System.out.println("=== 1. Object Construction & Initial State Verification ===");
        System.out.println("Initial total purifiers: " + AirPurifier.getTotalPurifiers());

        AirPurifier purifier1 = new AirPurifier("Xiaomi Air Purifier 4", 45.0, 65.5);
        System.out.println("Model: " + purifier1.getModel());
        System.out.println("Room Volume: " + purifier1.getRoomVolume() + " cu.m.");
        System.out.println("Is On: " + purifier1.isOn());
        System.out.println("Fan Speed: " + purifier1.getFanSpeed());
        System.out.println("Current Mode: " + purifier1.getMode());
        System.out.println("PM2.5 Level: " + purifier1.getPm25());
        System.out.println("Total Purifiers: " + AirPurifier.getTotalPurifiers());

        System.out.println("\n=== 2. Operations While Turned Off (Error Handling) ===");
        purifier1.setFanSpeed(2);
        purifier1.turnOff();

        System.out.println("\n=== 3. Turning On & Manual Fan Speed Control ===");
        purifier1.turnOn();
        System.out.println("After turnOn -> isOn: " + purifier1.isOn() + ", fanSpeed: " + purifier1.getFanSpeed());

        purifier1.setFanSpeed(0);
        purifier1.setFanSpeed(4);
        purifier1.setFanSpeed(2);
        System.out.println("Set fan speed to 2 -> fanSpeed: " + purifier1.getFanSpeed() + ", mode: " + purifier1.getMode());

        System.out.println("\n=== 4. Mode Switching (SLEEP and AUTO) ===");
        purifier1.setMode(AirPurifier.Mode.SLEEP);
        System.out.println("SLEEP mode -> mode: " + purifier1.getMode() + ", fanSpeed: " + purifier1.getFanSpeed());

        purifier1.setMode(AirPurifier.Mode.AUTO);
        System.out.println("AUTO mode (PM2.5 = 65.5) -> mode: " + purifier1.getMode() + ", fanSpeed: " + purifier1.getFanSpeed());

        System.out.println("\n=== 5. Updating Air Quality & Automatic Fan Adjustment ===");
        purifier1.updateAirQuality(-5.0);

        purifier1.updateAirQuality(25.0);
        System.out.println("Updated PM2.5 = " + purifier1.getPm25() + " -> fanSpeed: " + purifier1.getFanSpeed());

        purifier1.updateAirQuality(10.0);
        System.out.println("Updated PM2.5 = " + purifier1.getPm25() + " -> fanSpeed: " + purifier1.getFanSpeed());

        System.out.println("\n=== 6. Air Quality Category Evaluation ===");
        double[] testPmValues = {10.0, 25.0, 45.0, 100.0, 200.0, 300.0};
        for (double pm : testPmValues) {
            System.out.println("PM2.5 = " + pm + " -> " + AirPurifier.airQualityCategory(pm));
        }

        System.out.println("\n=== 7. Second Object Independence & Power Off ===");
        AirPurifier purifier2 = new AirPurifier("Dyson Purifier Cool", 60.0, 15.0);
        System.out.println("Created second purifier (" + purifier2.getModel() + ")");
        System.out.println("Total Purifiers in system: " + AirPurifier.getTotalPurifiers());

        purifier1.turnOff();
        System.out.println("Turned off purifier1 -> isOn: " + purifier1.isOn() + ", fanSpeed: " + purifier1.getFanSpeed());
        System.out.println("purifier2 state (independent) -> isOn: " + purifier2.isOn() + ", PM2.5: " + purifier2.getPm25());
    }

}