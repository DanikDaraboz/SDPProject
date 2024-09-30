public class Class {

    public double convert(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public void displayConversion(double celsius) {
        double fahrenheit = convert(celsius);
        System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.%n", celsius, fahrenheit);
    }

    public static void main(String[] args) {
        Class converter = new Class();
        double celsius = 25;
        converter.displayConversion(celsius);
    }
}









