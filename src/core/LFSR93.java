package core;

public class LFSR93 implements ILFSR{

    protected int[] content;
    protected int startBit;
    protected boolean newStartBit;

    public LFSR93(int[] content) {
        if (!(content.length == 93)) {
            throw new IllegalArgumentException();
        }
        this.content = content;
        this.startBit = 0;
        this.newStartBit = false;
    }


    @Override
    public int endBit() {
        int and9192 = Operations.bitAND(content[90], content[91]);
        int xor66AND = Operations.bitXOR(content[65], and9192);
        int result = Operations.bitXOR(content[92], xor66AND);
        return result;
    }

    @Override
    public int startBit(int previous) {
        int bit = Operations.bitXOR(content[68], previous);
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
