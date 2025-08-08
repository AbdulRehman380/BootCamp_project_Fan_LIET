package fans;

public enum FanSpeedS {
    OFF, LOW, MEDIUM, HIGH;

    public FanSpeedS increase() {
        return switch (this) {
            case OFF -> LOW;
            case LOW -> MEDIUM;
            case MEDIUM -> HIGH;
            case HIGH -> HIGH;
        };
    }

    public FanSpeedS decrease() {
        return switch (this) {
            case HIGH -> MEDIUM;
            case MEDIUM -> LOW;
            case LOW -> OFF;
            case OFF -> OFF;
        };
    }
}
