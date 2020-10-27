package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalCreation {
    private Scanner keyboard = new Scanner(System.in);
    Pet userPet;

    public int requestAnimalType() {
        int userNumber = 0;

        while (!(userNumber == 1 || userNumber == 2)) {
            System.out.println("What type of animal do you want to create?");
            System.out.println("1. Dog\n 2. Cat\n");
            String userChoice = keyboard.nextLine();
            userNumber = Integer.parseInt(userChoice);

            if (!(userNumber == 1 || userNumber == 2)) {
                System.out.println("You entered an invalid choice, Please enter again!");
            }
        }
        return userNumber;
    }

    public void getUserPet() {
        int petType = requestAnimalType();
        String petName;

        System.out.println("What do you want to name your pet?");
        petName = keyboard.nextLine();

        switch (petType) {
            case 1:
                boolean friendly;
                System.out.println("Is your dog friendly (yes/no)");
                String userChoice = keyboard.nextLine();
                if (userChoice.toLowerCase() == "yes") {
                    friendly = true;
                } else {
                    friendly = false;
                }
                userPet = new Dog(friendly, petName);
                break;
            case 2:
                int miceKilled = 0;
                System.out.println("How many mouse has your cat killed?");
                userChoice = keyboard.nextLine();
                miceKilled = Integer.parseInt(userChoice);

                userPet = new Cat(miceKilled, petName);
                break;
        }
        this.userPet = userPet;
    }

    public void addToList(ArrayList petList) {
        petList.add(userPet);
    }

}
