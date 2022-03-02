package core;

public class Operations {

    public static int bitXOR(int b1, int b2) {
        int result;
        result = (b1 + b2) % 2;
        return result;
    }

    public static int bitAND(int b1, int b2) {
        int result;
        if (b1 == 1 && b2 == 1) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

}
