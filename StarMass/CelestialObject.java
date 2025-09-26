import java.util.Objects;

public class CelestialObject {
    private double x = 0.0;
    private double y = 0.0;
    private double z = 0.0;
    private String name = "Soleil";
    private int mass = 0;
    
    public static final double KM_IN_ONE_AU = 150000000.0;

    public CelestialObject() {
    }

    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double deltaX = obj2.getX() - obj1.getX();
        double deltaY = obj2.getY() - obj1.getY();
        double deltaZ = obj2.getZ() - obj1.getZ();
        
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        double distanceInAU = getDistanceBetween(obj1, obj2);
        return distanceInAU * KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        CelestialObject that = (CelestialObject) obj;
        return Double.compare(that.x, x) == 0 &&
               Double.compare(that.y, y) == 0 &&
               Double.compare(that.z, z) == 0 &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }
}