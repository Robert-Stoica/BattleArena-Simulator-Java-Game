public class SEStudent extends Student {

  /**
   * Constructor which initialises the character with its particular propriety values. It uses the
   * super method, declared in the character class to do this
   */
  public SEStudent(String name) {
    super(name, 8, 5, 8, 4, 10);
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, each member of the users team attacks a given enemy, each of them causing
   * normal damage If the condition is not met throws an exception
   */
  public void groupWork(Character enemy) throws Exception {
    if (this.currentKP == this.maxKP) {
      for (Character character : this.getTeam().getMembers()) {
        if (character.getHP() > 0) {
          int groupDamage;
          groupDamage = (100 * character.getAttack()) / (100 + enemy.getDefence());
          enemy.decreaseHP(groupDamage);
          System.out.println(this.getName() + "has used Groupwork on " + enemy.getName());
        }
      }

      if (enemy.getHP() <= 0) {
        this.increaseEP(4);
      }

      this.increaseEP(4);
      this.currentKP = 0;
    } else throw new Exception("not enough KPs");
  }

  /**
   * Method which defines the student attack, it respects the specs guidelines. If it has the
   * required KP points, the user heals each alive member of the team with the equivalent of half
   * its defence If the condition is not met throws an exception
   */
  public void groupDiscussion() throws Exception {
    if (this.currentKP == this.maxKP) {
      for (Character member : this.getTeam().getMembers()) {
        if (member.getHP() > 0) {
          int heal;
          heal = this.getDefence() / 2;
          member.increaseHP(heal);
          System.out.println(this.getName() + "has used groupDiscussion on " + member.getName());
        }
      }
      this.increaseEP(4);
      this.currentKP = 0;
    } else throw new Exception("not enough KPS");
  }
}
