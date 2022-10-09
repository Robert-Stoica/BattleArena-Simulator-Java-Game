public class CSStudent extends Student {

  /**
   * Constructor which initialises the character with its particular propriety values. It uses the
   * super method, declared in the character class to do this
   */
  public CSStudent(String name) {
    super(name, 7, 6, 6, 6, 4);
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, attacks along side with a friend a given enemy, each of them causing normal
   * damage If the condition is not met throws an exception
   */
  public void pairWorking(Character friend, Character enemy) throws Exception {
    if (this.currentKP == this.maxKP) {
      if (friend.getHP() > 0) {
        enemy.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
        enemy.decreaseHP((100 * friend.getAttack()) / (100 + enemy.getDefence()));
        System.out.println(
            this.getName()
                + "has used pairWorking with "
                + friend.getName()
                + " on "
                + enemy.getName());
      }
      if (enemy.getHP() <= 0) {
        this.increaseEP(4);
      }

      this.increaseEP(4);
      this.currentKP = 0;

    } else throw new Exception("not enough KP");
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, heals a friend the equivalent of his defense If the condition is not met
   * throws an exception
   */
  public void support(Character friend) throws Exception {
    if (this.currentKP == this.maxKP) {
      if (friend.getHP() > 0) {
        friend.increaseHP(this.getDefence());
        System.out.println(this.getName() + "has used support " + friend.getName());
      }
    } else throw new Exception("not enough Kps");
  }
}
