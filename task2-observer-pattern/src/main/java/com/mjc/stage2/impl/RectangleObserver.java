package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
        Rectangle rectangle = event.getSource();
        RectangleValues rectangleValues = rectangleWarehouse.get(rectangle.getId());

        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        double square = sideA * sideB;
        double perimeter = 2 * sideA + 2 * sideB;

        if (rectangleValues != null) {
            rectangleValues.setSquare(square);
            rectangleValues.setPerimeter(perimeter);
        } else {
            rectangleWarehouse.put(rectangle.getId(),new RectangleValues(square,perimeter));
        }

    }
    // Write your code here!
}
