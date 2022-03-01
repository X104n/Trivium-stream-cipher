package core;

public abstract class LFSR implements ILFSR {


    /**
     * As the code is now, we actually don't need this abstract class.
     * But would like to figure out how to use this class inn all the LFSR's to run the same step command.
     */

    public void step(int[] content, int startBit, boolean newStartBit) {
        System.out.println(newStartBit);
        if (!newStartBit) {
            throw new IllegalArgumentException("This isn't a new start bit");
        }

        for (int i = content.length - 1; i >= 1; i--) {
            content[i] = content[i - 1];
        }
        content[0] = startBit;
        newStartBit = false;
    }
}
