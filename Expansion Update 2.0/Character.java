import java.lang.Math;

public class Character {

  private Team team;
  private String name;
  private int baseHP;
  private int baseAtk;
  private int baseDef;
  private int baseSpd;
  private int level = 1;
  private int currentEP = 0;
  protected int currentHP;

  /**
   * Constructor which initialises the character with propriety values. It is used by other classes
   * which calls the super method. It is bound to a variety of setters and getters method for
   * accessing specific properties.
   */
  public Character(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
    this.name = name;
    this.baseHP = baseHP;
    this.baseAtk = baseAtk;
    this.baseDef = baseDef;
    this.baseSpd = baseSpd;
    currentHP = this.baseHP;
  }

  /** Method which gets the name of the character */
  public String getName() {
    return this.name;
  }


  /** Method which gets the max hp of the character based on given formula */
  public int getMaxHP() {
    int maxHp;
    maxHp = (int) Math.round(this.baseHP * Math.pow(level, 1.2));
    return maxHp;
  }

  /** Method which gets the attack of the character based on given formula */
  public int getAttack() {
    int atk;
    atk = (int) Math.round(this.baseAtk * Math.pow(level, 1.2));
    return atk;
  }

  /** Method which increases the base defence of an character in order to increase his defence */
  public void increaseBaseDef(){
    this.baseDef = baseDef + 1;
  }

  /** Method which gets the defence of the character based on given formula */
  public int getDefence() {
    int def;
    def = (int) Math.round(this.baseDef * Math.pow(level, 1.2));
    return def;
  }

  /** Method which increases the base speed of an character in order to increase his speed */
  public void increaseBaseSpd(){
    this.baseSpd = baseSpd + 1;
  }

  /** Method which gets the speed of the character based on given formula */
  public int getSpeed() {
    int spd;
    spd = (int) Math.round(this.baseSpd * Math.pow(level, 1.2));
    return spd;
  }

  /**
   * Method which gets the target EP, used for leveling up, of the character based on given formula
   */
  public int getTargetEP() {
    return (int) Math.round(10 * Math.pow(level, 1.5));
  }

  /** Method which gets the current HP of the character based on given formula */
  public int getHP() {
    return this.currentHP;
  }

  /** Method which gets the current EP of the character based on given formula */
  public int getEP() {
    return this.currentEP;
  }

  /**
   * Method which increases the hp of a character based on given amount The current HP cannot be
   * greater than the max, or else it set to its value
   */
  public void increaseHP(int amount) {
    currentHP += amount;
    if (currentHP >= getMaxHP()) {
      currentHP = getMaxHP();
    }
  }

  /**
   * Method which decreases the hp of a character based on given amount The current HP cannot be
   * smaller than the 0, or else it set 0
   */
  public void decreaseHP(int amount) {
    currentHP -= amount;
    if (currentHP < 0) {
      currentHP = 0;
    }
  }

  /**
   * Method which increases the EP of a character based on given amount If the character`s EP
   * surpasses its max EP enables it to level up, current hp takes the values of the max and current
   * EP becomes 0
   */
  public void increaseEP(int amount) {
    currentEP += amount;
    if (currentEP >= getTargetEP()) {
      level += 1;
      currentHP = getMaxHP();
      currentEP = 0;
    }
  }

  public void EPIsZero(){
    currentEP = 0;
  }

  /** Method which sets the level of a character */
  public void setLevel(int level) {
    this.level = level;
  }

  /** Method which gets the level of a character */
  public int getLevel() {
    return this.level;
  }

  /** Method which set the team of a character */
  public void setTeam(Team team) {
    this.team = team;
  }

  /** Method which gets the team of a character */
  public Team getTeam() {
    return this.team;
  }
}
