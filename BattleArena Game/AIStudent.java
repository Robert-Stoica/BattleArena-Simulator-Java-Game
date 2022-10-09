public class AIStudent extends Student {

  /**
   * Constructor which initialises the character with its particular propriety values. It uses the
   * super method, declared in the character class to do this
   */
  public AIStudent(String name) {
    super(name, 6, 7, 7, 5, 3);
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, attack an enemy giving it double damage If the condition is not met throws
   * an exception
   */
  public void machineLearning(Character enemy) throws Exception {
    if (this.currentKP == this.maxKP) {
      enemy.decreaseHP(2 * (100 * this.getAttack()) / (100 + enemy.getDefence()));
      System.out.println(this.getName() + " has used machineLearning " + enemy.getName());
      this.increaseEP(4);
      this.currentKP = 0;
      if (enemy.getHP() == 0) {
        this.increaseEP(4);
      }
    } else {
      throw new Exception("Not enough KP points");
    }
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, heals the user If the condition is not met throws an exception
   */
  public void naturalLanguageProcessing() throws Exception {
    if (this.currentKP == this.maxKP) {
      this.increaseHP(this.getDefence());
      System.out.println(this.getName() + "has used naturalLanguageProcessing");
    } else throw new Exception("Not enough KP points");
  }
}
