package core;

public class LFSR111 implements ILFSR {

    protected int[] content;
    protected int startBit;
    protected boolean newStartBit;

    public LFSR111(int[] content) {
        if (!(content.length == 111)) {
            throw new IllegalArgumentException();
        }
        this.content = content;
        this.startBit = 0;
        this.newStartBit = false;
    }

    @Override
    public int endBit() {
        int and8283 = Operations.bitAND(content[109], content[108]);
        int xor69AND = Operations.bitXOR(content[65], and8283);
        int result = Operations.bitXOR(content[110], xor69AND);
        return result;
    }

    @Override
    public int startBit(int previous) {
        int bit = Operations.bitXOR(content[86], previous);
        this.startBit = bit;
        this.newStartBit = true;
        return bit;
    }

    @Override
    public void step() {
        if (!this.newStartBit) {
            throw new IllegalArgumentException("This isn't a new start bit");
        }

        for(int i = content.length - 1; i >= 1; i--) {
            content[i] = content[i - 1];
        }
        content[0] = startBit;
        this.newStartBit = false;
    }
}
