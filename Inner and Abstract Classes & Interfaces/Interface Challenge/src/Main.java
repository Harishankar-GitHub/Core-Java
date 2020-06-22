import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
    {
        Player jack = new Player("Jack", 10, 15);
        System.out.println(jack.toString());

        jack.setHitPoints(8);
        System.out.println(jack);
        jack.setWeapon("Gun");
        saveObject(jack);
//        loadObject(jack);
        System.out.println(jack);

        ISaveable monster = new Monster("Monster", 20, 40);
        System.out.println("Strength = " + ((Monster) monster).getStrength());
        // In the above line, we have used ISaveable reference. So monster.getStrength won't work.
        // So we use type casting - ((Monster) monster).getStrength()).
        // If we want to use methods specific to the class, we can use reference of that class.
        // Like Monster monster = new Monster("Monster", 20, 40);
        System.out.println(monster);
        saveObject(monster);
    }

    public static ArrayList<String> readValues() { // This method was already given in this challenge.
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave)
    {
        for(int i = 0; i < objectToSave.write().size(); i++)
        {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device.");
        }
    }

    public static void loadObject(ISaveable objectToLoad)
    {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
