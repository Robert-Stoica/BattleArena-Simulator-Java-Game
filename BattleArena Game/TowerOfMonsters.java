import java.util.ArrayList;

public class TowerOfMonsters {

  private static MonsterTeamReader monsterReader;
  private static ArrayList<MonsterObject> monsters;
  private int teamNumber;

  /**
   * Main method which will run the battle, initialises the file name, the monster team, the guild
   * team. It also establishes when the fight will end for 2 different cases, when guild is dead(
   * players alive are 0) and when both teams are in a draw;
   */
  public static void main(String[] args) {
    String fileName = args[0];
    TowerOfMonsters tower = new TowerOfMonsters(fileName);
    Battle battle;
    Guild guild = new Guild();

    System.out.println("------------------------------------------------");
    System.out.println("              Welcome to the Arena!             ");
    System.out.println("------------------------------------------------");

    while (monsterReader.isFileReady()) {
      monsters = monsterReader.getMonsters();
      Team MonsterTeam = tower.getTeam();
      Team studentTeam = guild.getTeam(MonsterTeam);
      battle = new Battle(studentTeam, MonsterTeam);
      battle.fight();
      if (guild.isAlive(guild) == 0) {
        System.out.println("monsters won");
        break;
      } else if (guild.isAlive(guild) != 0 && battle.alive(MonsterTeam) != 0) break;
      System.out.println("\n-----------Next level reached-------------");
    }
  }

  /**
   * Constructor for initialising the reader and from which file to read as well as the team numbers
   * which will be later used in the process of naming the each monster teams
   */
  TowerOfMonsters(String fileName) {
    monsterReader = new MonsterTeamReader(fileName);
    this.teamNumber = 1;
  }

  /**
   * Method for setting up the teams of monster by populating them with Monster objects, distributed
   * accordingly, and for naming each team
   *
   * @return the monster team for the arena battle.
   */
  public Team getTeam() {

    String teamName = "Team" + teamNumber;
    MonsterTeam newTeam = new MonsterTeam(teamName);

    for (MonsterObject monster : monsters) {

      if (monster.getMonsterType().equals("Minion")) {
        Minion tempMinion = new Minion(monster.getMonsterName());
        tempMinion.setLevel(monster.getMonsterLvl());
        newTeam.addMember(tempMinion);
        tempMinion.setTeam(newTeam);

      } else {
        Boss tempBoss = new Boss(monster.getMonsterName());
        tempBoss.setLevel(monster.getMonsterLvl());
        newTeam.addMember(tempBoss);
        tempBoss.setTeam(newTeam);
      }

      if (newTeam.members.size() == 5) {
        teamNumber++;
      }
    }

    return newTeam;
  }
}
