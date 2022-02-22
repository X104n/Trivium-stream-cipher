package core;

public abstract class LFSR implements ILFSR {

    int[] content;
    int startBit;
    boolean newStartBit;


    /**
     * As the code is now, we actually don't need this abstract class.
     * But would like to figure out how to use this class inn all the LFSR's to run the same step command.
     */
    @Override
    public void step() {
        if (!this.newStartBit) {
            throw new IllegalArgumentException("This isn't a new start bit");
        }

        for (int i = content.length - 1; i >= 1; i--) {
            content[i] = content[i - 1];
        }
        content[0] = startBit;
        this.newStartBit = false;
    }
}
