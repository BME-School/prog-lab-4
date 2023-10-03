import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Beer> beers = new ArrayList<Beer>();
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] result = line.split(" ");

            if ("exit".equals(result[0])) {
                System.exit(0);
            }
            else if ("add".equals(result[0])) {
                add(result);
            }
            else if ("list".equals(result[0])) {
                list(result);
            }
            else if ("save".equals(result[0])) {
                save(result);
            }
            else if ("load".equals(result[0])) {
                load(result);
            }
        }
    }

    public static void add(String[] args){
        if(args.length != 4) {
            System.out.println("Hibás bemenet: add [name] [type] [strength]");
            return;
        }
        try {
            double strength = Double.parseDouble(args[3]);
            beers.add(new Beer(args[1], args[2], strength));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void list(String[] args){
        for (Beer beer : beers) {
            System.out.println(beer.toString());
        }
    }

    public static void load(String[] args){
        if(args.length != 2) {
            System.out.println("Hibás bemenet: load [filename]");
            return;
        }

        try (FileInputStream fileIn = new FileInputStream(args[1]);
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            beers = (ArrayList<Beer>) in.readObject();
            System.out.println("Sörök betöltve");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Hiba a betöltés közben: " + e);
        }
    }

    public static void save(String[] args) {
        if (args.length != 2) {
            System.out.println("Hibás bemenet: save [filename]");
            return;
        }

        try (FileOutputStream fileOut = new FileOutputStream(args[1]);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(beers);
            System.out.println("Sörök elmentve");
        } catch (IOException e) {
            System.out.println("Hiba a mentés közben: " + e);
        }
    }
}