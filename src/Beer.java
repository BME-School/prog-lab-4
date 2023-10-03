import java.io.Serializable;

public class Beer implements Serializable {
    private String name, type;
    private Double strength;

    Beer(String n, String t, Double s){
        this.name = n;
        this.type = t;
        this.strength = s;
    }

    public String getName(){ return name; }
    public String getType(){ return type; }
    public Double getStrength(){ return strength; }

    public String toString() { return name + "#" +  type + "#" + strength; }
}
