package com.newmind.seobackstage.common.response;

public enum ResultStates {

    SUCCEEDED(0), FAILED(1);

    private int index;
    private String message;

    ResultStates(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
