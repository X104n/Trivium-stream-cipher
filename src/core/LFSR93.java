package core;

public class LFSR93 extends LFSR{

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
        startBit = bit;
        newStartBit = true;
        return bit;
    }

    @Override
    public void step() {
        super.step();
    }
}
