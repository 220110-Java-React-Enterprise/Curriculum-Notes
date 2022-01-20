import shapes.Polygon;
import shapes.PolygonFactory;

public class Main {
    public static void main(String ...args) throws Exception {
        Polygon myShape = PolygonFactory.getPolygon(5, 2.6);
        System.out.println("My shape: " + myShape.getShape());
    }
}
