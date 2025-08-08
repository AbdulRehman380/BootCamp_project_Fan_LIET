package fans;

public class ElectricFan {
    private boolean isOn = false;
    private FanSpeedS speed;
    private String brandName;

    public ElectricFan() {
        this.speed = FanSpeedS.OFF;
    }

    public void switchOnTheFan() {
        isOn = true;
        speed = FanSpeedS.LOW;
        System.out.println("Starting the fan with speed: " + speed);
    }

    public void switchOffTheFan() {
        isOn = false;
        speed = FanSpeedS.OFF;
        System.out.println("Turning off the fan");
    }

    public boolean isSwitchedOn() {
        return isOn;
    }

    public void increaseSpeed() {
        if (!isOn) {
            System.out.println("Please switch on the fan");
        } else {
            speed = speed.increase();
        }
    }

    public void decreaseSpeed() {
        speed = speed.decrease();
    }

    public FanSpeedS getSpeed() {
        return speed;
    }

    public void setSpeed(FanSpeedS speed) {
        this.speed = speed;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "ElectricFan{" +
                "isOn=" + isOn +
                ", speed=" + speed +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
