import java.io.Serializable;

public class Beer implements Serializable {
    private String name, style;
    private Double strength;

    Beer(String n, String t, Double s){
        this.name = n;
        this.style = t;
        this.strength = s;
    }

    public String getName(){ return name; }
    public String getStyle(){ return style; }
    public Double getStrength(){ return strength; }

    public String toString() { return name + "#" +  style + "#" + strength; }
}
