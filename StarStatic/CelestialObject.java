// package StarStatic;

public class CelestialObject {
    public  double x;
    public double y;
    public double z;
    public String name;
    public static final double KM_IN_ONE_AU = 150_000_000.0; 

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }
       public CelestialObject( String name, double x , double y , double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
     public void setName() {
        this.name = "Soleil";
    }

    public void setX() {
        this.x = 0.0;
    }

    public void setY() {
        this.y = 0.0;
    }

    public void setZ() {
        this.z = 0.0;
    }

    public String getName() {
        return this.name;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double deltaX = obj2.x - obj1.x;
        double deltaY = obj2.y - obj1.y;
        double deltaZ = obj2.z - obj1.z;

        double dis = Math.sqrt(
            Math.pow(deltaX, 2) + 
            Math.pow(deltaY, 2) +
            Math.pow(deltaZ, 2)
        );
        return dis;
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        double dis = getDistanceBetween(obj1, obj2);
        return dis * KM_IN_ONE_AU;
    }
}
