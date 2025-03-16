package core;

/**
 * Methods that the LFSR needs for the Trivium stream cypher
 *
 * @author Stian Munkejord
 */
public interface ILFSR {

    /**
     * Getting the bit that XOR with bit a bit in the LFSR, and AND with the two second last bits.
     *
     * @return Bit that will be XORed to get the stream cypher
     */
    int endBit();

    /**
     * This gets the bit that is XORed with a bit in the current LFSR and the previous
     *
     * @param previous Gets the bit that was XORed with the previous LFSR
     * @return Bit that is pushed into the LFSR
     */
    int startBit(int previous);

    /**
     * Performs a step to further complicate the LFSR
     *
     */
    void step();
}
