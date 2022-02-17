package core;

public class Operations {

    public static int[] XOR(int[] v1, int[] v2) {
        int[] result = new int[v1.length];

        for (int i = 0; i < v1.length; i++) {
            int b = (v1[i] + v2[i]) % 2;
            result[i] = b;
        }
        return result;
    }

    public static int bitXOR(int v1, int v2) {
        int result;
        int b = (v1 + v2) % 2;
        result = b;
        return result;
    }

    public static int[] AND(int[] v1, int[] v2) {
        int[] result = new int[v1.length];

        for (int i = 0; i < v1.length; i++) {
            if (v1[i] == 1 && v2[i] == 1) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static int bitAND(int v1, int v2) {
        int result;
        if (v1 == 1 && v2 == 1) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

}
