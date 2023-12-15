import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        String unit = scanner.next();

        double convertedTemperature;

        if (unit.equalsIgnoreCase("C")) {
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println("Converted temperature in Fahrenheit: " + convertedTemperature + "°F");
        } else if (unit.equalsIgnoreCase("F")) {
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println("Converted temperature in Celsius: " + convertedTemperature + "°C");
        } else {
            System.out.println("Invalid unit of measurement. Please enter C or F.");
        }

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}