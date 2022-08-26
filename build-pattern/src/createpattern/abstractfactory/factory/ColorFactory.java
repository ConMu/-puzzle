package createpattern.abstractfactory.factory;

import createpattern.abstractfactory.AbstractFactory;
import createpattern.abstractfactory.impl.Blue;
import createpattern.abstractfactory.impl.Green;
import createpattern.abstractfactory.impl.Red;
import createpattern.abstractfactory.inter.Color;
import createpattern.abstractfactory.inter.Shape;

/**
 * @author mucongcong
 * @date 2022/08/05 17:30
 * @since
 **/
public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
