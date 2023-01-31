package com.rough;


public class IdentifierRegistration {
    private long startNumber;
    private long endNumber;
    private String allocationCode;
    private int digits;

    public IdentifierRegistration(long startNumber, long endNumber, String allocationCode, int digits) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.allocationCode = allocationCode;
        this.digits = digits;
    }

    public long getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(long startNumber) {
        this.startNumber = startNumber;
    }

    public long getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(long endNumber) {
        this.endNumber = endNumber;
    }

    public String getAllocationCode() {
        return allocationCode;
    }

    public void setAllocationCode(String allocationCode) {
        this.allocationCode = allocationCode;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
