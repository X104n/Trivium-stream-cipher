package core;

public abstract class LFSR implements ILFSR {

    int[] content;
    int startBit;
    boolean newStartBit;

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
