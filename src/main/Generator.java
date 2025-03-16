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

    public static int[] customKeyMaker(int[] key) {
        int[] result = new int[84];
        for (int i = 0; i < 80; i++) {
            result[i] = key[i];
        }
        return result;
    }

    public static int[] customIVMaker(int[] iv) {
        int[] result = new int[93];
        for (int i = 0; i < 80; i++) {
            result[i] = iv[i];
        }
        return result;
    }

}
