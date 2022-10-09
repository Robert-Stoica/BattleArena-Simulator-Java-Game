public class ElecNanoTechStudent  extends Student{
    /**
     * Constructor which initialises the character with its particular propriety values. It also
     * defines the maximum KP and current KP points which are used for skills, a character starts with
     * 0 It uses the super method, declared in the character class to do this
     */
    public ElecNanoTechStudent(String name) {
        super(name, 6, 7, 5, 7, 5);
    }

  /**
   * It increases his and a friends EP by adding to their current EP half of their target EP to
   * reach the next level. It also heals them by half their defence and It decrease the enemies
   * current EP to 0;
   * @param friend
   * @param enemy
   */
  public void microAdvancement(Character friend, Character enemy) throws Exception {
    if (this.currentKP == this.maxKP) {
      int addedEpFriend = friend.getTargetEP() / 2;
      int addedEpCharacter = this.getTargetEP() / 2;
      int addedHpFriend = friend.getDefence() / 2;
      int addedHpCharacter = this.getDefence() / 2;
      this.increaseEP(addedEpCharacter);
      this.increaseHP(addedHpCharacter);
      friend.increaseHP(addedHpFriend);
      friend.increaseEP(addedEpFriend);
      System.out.println(this.getName() + " used MicroAdvancement on him and " + friend.getName() + ", they rejuvenated their hp and increased EP");
      enemy.EPIsZero();
      System.out.println(
          this.getName() + " used MicroAdvancement on " + enemy.getName() + ", his EP is 0");
      this.increaseEP(4);
      this.currentKP = 0;
    }else throw new Exception("not enough KPS");

  }

}
