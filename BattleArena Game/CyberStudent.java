public class CyberStudent extends Student {

  /**
   * Constructor which initialises the character with its particular propriety values. It uses the
   * super method, declared in the character class to do this
   */
  public CyberStudent(String name) {
    super(name, 7, 7, 5, 6, 6);
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, attacks all the characters of the enemy team causing to each of them normal
   * damage If the condition is not met throws an exception
   */
  public void cyberAttack(Team enemyTeam) throws Exception {
    if (this.currentKP == this.maxKP) {
      for (Character enemy : enemyTeam.getMembers()) {
        if (enemy.getHP() > 0) {
          int cyberAttack;
          cyberAttack = (100 * getAttack()) / (100 + enemy.getDefence());
          enemy.decreaseHP(cyberAttack);
          System.out.println(this.getName() + " has used pairWorking on " + enemy.getName());
        }
        if (enemy.getHP() <= 0) {
          this.increaseEP(4);
        }
      }
      increaseEP(4);
      this.currentKP = 0;
    } else throw new Exception("not enough KPS");
  }
}
