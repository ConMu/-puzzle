package basething.constructor;

public class Son extends Father {
    public Son() {
    }

    public Son(int value) {
        super(value);
    }

    public int getValue() {
        return super.value;
    }
}
