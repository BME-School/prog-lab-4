import java.util.Comparator;

class NameComparator implements Comparator<Beer> {
    public int compare(Beer a, Beer b) {
        return a.getName().compareTo(b.getName());
    }
}

class StyleComparator implements Comparator<Beer> {
    public int compare(Beer a, Beer b) {
        return a.getStyle().compareTo(b.getStyle());
    }
}

class StrengthComparator implements Comparator<Beer> {
    public int compare(Beer a, Beer b) {
        return a.getStrength().compareTo(b.getStrength());
    }
}