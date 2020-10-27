package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner keyboard = new Scanner(System.in);
    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");

    public static void main(String[] args) {
        ArrayList<Talkable> zoo = new ArrayList<>();
        AnimalCreation animalCreation = new AnimalCreation();

        // Lines to Replace Begin Here
        zoo.add(new Dog(true, "Bean"));
        zoo.add(new Cat(9, "Charlie"));
        zoo.add(new Teacher(44, "Stacy Read"));

        animalCreation.getUserPet();
        animalCreation.addToList(zoo);
        // End Lines to Replace

        for (Talkable thing : zoo) {
            printOut(thing);
        }
        outFile.fileClose();
        inFile.fileRead();
        inFile.fileClose();

        FileInput indata = new FileInput("animals.txt");
        String line;
        while ((line = indata.fileReadLine()) != null) {
            System.out.println(line);
        }
    }

    public static void printOut(Talkable p) {
        System.out.println(p.getName() + " says=" + p.talk());
        outFile.fileWrite(p.getName() + " | " + p.talk());
    }


}
