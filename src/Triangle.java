import java.util.HashSet;
import java.util.Set;

public class Triangle {
    //Координаты вершин треугольника
    private long coordinateAX;
    private long coordinateAY;

    private long coordinateBX;
    private long coordinateBY;

    private long coordinateCX;
    private long coordinateCY;

    //Длины сторон треугольника
    private double lengthAB;
    private double lengthBC;
    private double lengthCA;

    private double square;
    private boolean isIsosceles;

    public Triangle(long coordinateAX, long coordinateAY,
                    long coordinateBX, long coordinateBY, long coordinateCX, long coordinateCY) {
        this.coordinateAX = coordinateAX;
        this.coordinateAY = coordinateAY;
        this.coordinateBX = coordinateBX;
        this.coordinateBY = coordinateBY;
        this.coordinateCX = coordinateCX;
        this.coordinateCY = coordinateCY;
        lengthAB = length(coordinateAX, coordinateAY, coordinateBX, coordinateBY);
        lengthBC = length(coordinateBX, coordinateBY, coordinateCX, coordinateCY);
        lengthCA = length(coordinateCX, coordinateCY, coordinateAX, coordinateAY);

        //Проверка на треугольник
        if (!((lengthAB < lengthBC+lengthCA) && (lengthBC < lengthCA+lengthAB) && (lengthCA < lengthAB+lengthBC))){
            throw new RuntimeException();
        }

        // Проверка на равнобедренность/равносторонность
        Set<Double> tmp = new HashSet<>();
        tmp.add(lengthAB);
        tmp.add(lengthBC);
        tmp.add(lengthCA);
        if (tmp.size() < 3) {
            isIsosceles = true;
            square = square();
        }
    }

    public double getSquare() {
        return square;
    }

    public boolean isIsosceles() {
        return isIsosceles;
    }

    private double length(long x1, long y1, long x2, long y2){
        return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
    }

    private double square(){
        double p = (lengthAB + lengthBC + lengthCA)/2;
        return Math.sqrt(p*(p-lengthAB)*(p-lengthBC)*(p-lengthCA));
    }

    @Override
    public String toString() {
        return coordinateAX + " " + coordinateAY + " "
                + coordinateBX + " " + coordinateBY + " "
                + coordinateCX + " " + coordinateCY;
    }
}
