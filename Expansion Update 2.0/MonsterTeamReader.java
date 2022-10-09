import java.io.*;
import java.util.ArrayList;

public class MonsterTeamReader {

    BufferedReader reader;

    /**
     * Constructor for MonsterObject which creates a BufferedReader for the text file containing the monsters.
     */
    MonsterTeamReader(String fileName) {
        try {
            this.reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error accessing file monsters.txt");
            e.printStackTrace();
        }
    }

    /**
     * Method for retrieving the next line from the text file containing the questions.
     * @return The line retrieved if successful.
     */
    public String getLine() {
        String currentLine;

        try {
            if ((currentLine = reader.readLine()) != null) {
                return currentLine;
            }
        } catch (IOException e) {
            System.out.println("Error reading from file");
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Returns a boolean as to whether the file is ready to be accessed or not
     * @return True (file is ready to be accessed), False (file is not ready to be accessed)
     */
    public boolean isFileReady() {
        try {
            return reader.ready();
        } catch (IOException e) {
            System.out.println("Error accessing file");
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Gets every line from the file, splits it by the divider (:) and then creates a FlashCard object from it. These are added to an ArrayList of monsters and then returned.
     * @return ArrayList<MonsterObject> containing all the monsters contained in the file
     */
     ArrayList<MonsterObject> getMonsters() {
        ArrayList<MonsterObject> monsterCreate = new ArrayList<>();

            String[] detail = this.getLine().split(";");
            for (String text : detail){
                String level;
                String nameOfMember;
                String classType;
                    nameOfMember = text.split("\\(")[0];
                    classType = text.split("\\(")[1].split(",")[0];
                    level = text.split("\\(")[1].split(",")[1].split("\\)")[0];
                    int objectLvl = Integer.parseInt(level);
                    monsterCreate.add(new MonsterObject(nameOfMember, classType, objectLvl));
            }

        return monsterCreate;
    }


}