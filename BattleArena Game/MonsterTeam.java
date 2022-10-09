public class MonsterTeam extends Team {
  private String name;

  public MonsterTeam(String name) {
    super(name);
    this.name = name;
  }

  void move(Character member, Team enemyTeam) throws Exception {
    // check if its a monster

    if (member instanceof Monster) {

      // Strategy 1: attack if monster has full hp or can lvl up (+4)

      if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {

        // target the enemy with most hp;

        Character enemy = enemyTeam.choseMemberMaxHP(enemyTeam); //  get enemy with highest hp
        ((Monster) member).strike(enemy);

      } // strategy 2: if monster HP is low attack highest lvl;
      else if (member.getHP() <= (member.getMaxHP() * .30)) {
        Character enemy = enemyTeam.choseMemberMaxLvl(enemyTeam); //  get enemy with highest lvl
        ((Monster) member).strike(enemy);

      } // strategy 3 if monster lvls up attack the enemy with most spd
      else if (member.getEP() == member.getTargetEP()) {
        Character enemy = enemyTeam.choseMemberMaxSpd(enemyTeam); //  get enemy with highest spd
        ((Monster) member).strike(enemy);
      } // strategy 4 : attack with a killing hit the enemy with lower hp than the atttack

    } else throw new Exception("Wrong move, not monster");
  }
}
