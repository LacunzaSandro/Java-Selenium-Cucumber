package utils;

public enum Constants {
    CONFIG_FILE("global.properties");

    private final String value;

    Constants(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
