package main;

public class Generator {

    public static int[] testKeyMaker() {
        int[] result = new int[80];
        for (int i = 0; i < 80; i++) {
            result[i] = 1;
        }
        return result;
    }

    public static int[] testIVMaker() {
        int[] result = new int[80];
        for (int i = 0; i < 80; i++) {
            result[i] = 0;
        }
        return result;
    }

    public static int[] mandatoryKeyMaker() {
        int[] result = new int[80];
        for (int i = 0; i < 80; i++) {
            if (i % 2 == 0) result[i] = 1;
        }
        return result;
    }

    public static int[] mandatoryIVMaker() {
        int[] result = new int[80];
        for (int i = 0; i < 80; i++) {
            if ((i - 1) % 2 == 0) result[i] = 1;
        }
        return result;
    }

}
