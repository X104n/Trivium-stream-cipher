package core;

public class LFSR84 extends LFSR {

    protected int[] content;
    protected int startBit;
    protected boolean newStartBit;

    public LFSR84(int[] content){
        if (!(content.length == 84)) {
            throw new IllegalArgumentException();
        }
        this.content = content;
        this.startBit = 0;
        this.newStartBit = false;

    }

    @Override
    public int endBit() {
        int and8283 = Operations.bitAND(content[81], content[82]);
        int xor69AND = Operations.bitXOR(content[68], and8283);
        int result = Operations.bitXOR(content[83], xor69AND);
        return result;
    }

    @Override
    public int startBit(int previous) {
        int bit = Operations.bitXOR(content[77], previous);
        startBit = bit;
        newStartBit = true;
        return bit;
    }

    @Override
    public void step() {
        super.step();
    }
}
