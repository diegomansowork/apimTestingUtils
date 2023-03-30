package com.dmanso.apimTestingUtils.model;

public class Response {
    private int size;
    private String responseData;

    public Response() {};

    public Response(int size, String responseData) {
        this.size = size;
        this.responseData = responseData;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "Response [size=" + size + ", responseData=" + responseData + " ]";
    }
}
