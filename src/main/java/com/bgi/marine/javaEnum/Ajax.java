package com.bgi.marine.javaEnum;

public enum Ajax {
    Welcome_Record("/Welcome/record"),
    Organization_GetTree("/Organization/getTree");

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
