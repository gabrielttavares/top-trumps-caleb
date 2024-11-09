import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Characters {
    private List<Character> characters;

    public Characters() {
        this.characters = new ArrayList<>();
    }

    public void loadCharacterFromDatabase(Connection connection) {
        String query = "SELECT * FROM characters";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int strength = resultSet.getInt("strength");
                int wisdom = resultSet.getInt("wisdom");
                double faithLevel = resultSet.getDouble("faith_level");
                float humility = resultSet.getFloat("humility");
                String specialAbility = resultSet.getString("special_ability");
                String tribe = resultSet.getString("tribe");
                boolean isLeader = resultSet.getBoolean("is_leader");

                Character character = new Character(name, strength, wisdom, faithLevel, humility, specialAbility, tribe, isLeader);
                characters.add(character);
            }
            System.out.println("Characters loaded from the database!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayAllCharacters() {
        for (Character character : characters) {
            System.out.println(character);
        }
    }
}

//    public void findCharacterByName(String name) {
//        for (Character character : characters) {
//            if (character.getName().equalsIgnoreCase(name)) {
//                System.out.println(character);
//                return;
//            }
//        }
//        System.out.println("Character not found.");
//    }
