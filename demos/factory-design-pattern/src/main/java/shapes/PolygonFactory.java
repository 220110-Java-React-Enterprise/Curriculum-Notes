package shapes;

import shapes.Polygon;

public class PolygonFactory {

    public static Polygon getPolygon(Integer sides, Double len) throws Exception {
        if(sides < 3) {
            throw new Exception("That's not a valid polygon!");
        }

        switch(sides) {
            case 3://equilateral triangle
                return new Triangle(len);
            case 4://square
                return new Square(len);
            case 5://pentagon
                return new Pentagon(len);
//            case 6://hexagon
//                break;
//            case 7://septagon
//                break;
//            case 8: //octagon
//                break;
//            case 9: //nonagon
//                break;
//            case 10: //decagon

        }
        return null;
    }
}
