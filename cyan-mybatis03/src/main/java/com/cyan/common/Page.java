package com.cyan.common;

import java.io.Serializable;

public class Page implements Serializable {

    private static final long serialVersionUID = -5833834941831028795L;

    private Integer size;
    private Integer number;

    public Page(){}

    public Page(Integer size, Integer number) {
        this.size = size;
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBegin(){
        return (number-1)*size;
    }

    public Integer getEnd(){
        return number*size;
    }
}
