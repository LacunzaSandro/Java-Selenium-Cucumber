package utils;

public enum TimeOut {
    SECOND_5(5),
    SECOND_10(10),
    SECOND_20(20),
    SECOND_30(30),
    SECOND_40(40),
    SECOND_50(50);


    private final int value;

    TimeOut(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
