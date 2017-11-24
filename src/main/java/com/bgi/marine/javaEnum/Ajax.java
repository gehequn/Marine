package com.bgi.marine.javaEnum;

public enum Ajax {
    WELCOME_RECORD("/Welcome/record");

    private String url;

    Ajax(String url){
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
