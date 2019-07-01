/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Bryan
 */
public class Adjective implements Serializable {

    private String quantity;
    private String quality;
    private String size;
    private String shape;
    private String color;

//    public Adjective(String quantity, String quality, String size, String shape, String color) {
//        setQuantity(quantity);
//        setQuality(quality);
//        setSize(size);
//        setShape(shape);
//        setColor(color);
//    }
    public Adjective() {
        // Empty contructor
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "";
    }
}
