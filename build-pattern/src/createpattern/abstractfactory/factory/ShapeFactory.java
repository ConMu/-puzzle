package createpattern.abstractfactory.factory;

import createpattern.abstractfactory.AbstractFactory;
import createpattern.abstractfactory.impl.Circle;
import createpattern.abstractfactory.impl.Rectangle;
import createpattern.abstractfactory.impl.Square;
import createpattern.abstractfactory.inter.Color;
import createpattern.abstractfactory.inter.Shape;

/**
 * @author mucongcong
 * @date 2022/08/05 17:28
 * @since
 **/
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
