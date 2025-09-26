// package StarOverride;
import java.util.Objects;
public class Star extends CelestialObject {
    private double magnitude = 0.0;

    public Star() {
        super();
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z); 
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; 
        
        Star star = (Star) obj;
        return Double.compare(star.magnitude, magnitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }
}