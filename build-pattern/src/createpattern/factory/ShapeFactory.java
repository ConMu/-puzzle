package createpattern.factory;

import createpattern.factory.impl.Circle;
import createpattern.factory.impl.Rectangle;
import createpattern.factory.impl.Square;
import createpattern.factory.inter.Shape;

/**
 * @author mucongcong
 * @date 2022/08/05 16:59
 * @since
 **/
public class ShapeFactory {

    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
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
