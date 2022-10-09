public class Student extends Character {
  protected int maxKP;
  protected int currentKP;

  /**
   * Constructor which initialises the character with its particular propriety values. It also
   * defines the maximum KP and current KP points which are used for skills, a character starts with
   * 0 It uses the super method, declared in the character class to do this
   */
  public Student(String name, int baseHP, int baseAtk, int baseDef, int baseSpd, int maxKP) {
    super(name, baseHP, baseAtk, baseDef, baseSpd);
    this.maxKP = maxKP;
    this.currentKP = 0;
  }

  /** Increases the current KP points by a given amount. */
  public void increaseKP(int amount) {
    currentKP += amount;
    if (currentKP > maxKP) currentKP = maxKP;
  }

  /** gets the current KP points */
  public int getCurrentKP() {
    return this.currentKP;
  }

  /** gets the maximum KP points */
  public int getMaxKP() {
    return this.maxKP;
  }

  /**
   * Method which defines the student general attack, it respects the specs guidelines. attacks a
   * given enemy causing normal damage
   */
  public void javaProgramming(Character enemy) {
    this.increaseEP(3);
    this.increaseKP(1);
    enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
    System.out.println(this.getName() + " has used javaProgramming on " + enemy.getName());
    enemy.increaseEP(2);
    if (enemy instanceof Student) {
      ((Student) enemy).increaseKP(2);
    }
    if (enemy.getHP() == 0) {
      this.increaseEP(4);
    }
  }

  /** Increases the amount of the current HP, EP and KP by a fixed value */
  public void selfStudy() {
    this.increaseHP(2);
    this.increaseEP(6);
    this.increaseKP(2);
  }
}
