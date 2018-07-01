package brainfuck;

import brainfuck.utils.Assert;

public class Memory {

    private final byte[] buffer;
    private int pointer;

    public Memory(int size) {
        Assert.isTrue(size > 0, "size should be > 0");
        this.buffer = new byte[size];
    }

    public void putValue(byte value) {
        this.buffer[pointer] = value;
    }

    public byte getValue() {
        return this.buffer[pointer];
    }

    public void incrementPointer() {
        pointer++;
    }

    public void decrementPointer() {
        pointer--;
    }
}
