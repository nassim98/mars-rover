import org.rover.model.Direction;
import org.rover.model.Rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please provide the input file.");
            return;
        }

        try {
            Scanner scanner = new Scanner(new File(args[0]));
            int plateauWidth = scanner.nextInt();
            int plateauHeight = scanner.nextInt();

            while (scanner.hasNext()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Direction direction = Direction.valueOf(scanner.next());
                Rover rover = new Rover(x, y, direction, plateauWidth, plateauHeight);

                String instructions = scanner.next();
                rover.processInstructions(instructions);

                System.out.println(rover.getPosition());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
        }
    }
}