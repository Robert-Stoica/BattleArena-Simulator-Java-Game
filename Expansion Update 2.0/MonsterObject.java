public class MonsterObject {

  private String monsterName;
  private String monsterType;
  private int monsterLvl;

  /**
   * Monster constructor which will be the type of object stored form the file: the name, type and
   * level I also created setters and getters to access each property of the object and use it
   * accordingly
   */
  public MonsterObject(String name, String type, int level) {
    this.monsterName = name;
    this.monsterType = type;
    this.monsterLvl = level;
  }

  /** Gets monster name */
  public String getMonsterName() {
    return this.monsterName;
  }

  /** Gets monsters type */
  public String getMonsterType() {
    return this.monsterType;
  }

  /** Gets monster level */
  public int getMonsterLvl() {
    return this.monsterLvl;
  }
}
