package builder;

class Computer {
    private double cpuPrice;
    private double ramPrice;
    private double ssdPrice;

    public static class Builder {
        private double cpuPrice;
        private double ramPrice;
        private double ssdPrice;

        public Builder setCPUPrice(double value) {
            this.cpuPrice = value;
            return this;
        }

        public Builder setRAMPrice(double value) {
            this.ramPrice = value;
            return this;
        }

        public Builder setSSDPrice(double value) {
            this.ssdPrice = value;
            return this;
        }

        public Computer build() {
            Computer computer = new Computer();
            computer.cpuPrice = this.cpuPrice;
            computer.ramPrice = this.ramPrice;
            computer.ssdPrice = this.ssdPrice;
            return computer;
        }
    }

    public void displayTotalPrice() {
        System.out.println("The CPU is: " + this.cpuPrice);
        System.out.println("The RAM is: " + this.ramPrice);
        System.out.println("The SSD is: " + this.ssdPrice);
        System.out.println("The total price is " + (this.cpuPrice + this.ramPrice + this.ssdPrice));
    }
}

public class Main {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPUPrice(400)
                .setRAMPrice(400)
                .setSSDPrice(400)
                .build();
        gamingPC.displayTotalPrice();
    }
}
