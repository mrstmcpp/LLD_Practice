package org.mrstm.ThreadCommunication;

public class StateResource {
    private int count;
    private boolean hasCount;

    public StateResource(boolean hasCount){
        this.count = 10;
        this.hasCount = hasCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasCount() {
        return hasCount;
    }

    public void setHasCount(boolean hasCount) {
        this.hasCount = hasCount;
    }
}
