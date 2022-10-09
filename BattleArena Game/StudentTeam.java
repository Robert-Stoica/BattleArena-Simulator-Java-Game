public class StudentTeam extends Team {
  private String teamName;

  public StudentTeam(String teamName) {
    super(teamName);
    this.teamName = teamName;
  }

  void move(Character member, Team enemyTeam) throws Exception {
    if (!(member instanceof Student)) {
      throw new Exception("Wrong class, move again");
    } else {

      // declare enemies based on specific properties to be chosen for fight
      Character enemyHP = enemyTeam.choseMemberMaxHP(enemyTeam);
      Character friend = member.getTeam().choseFriendMaxAtk();
      Character enemySpd = enemyTeam.choseMemberMaxSpd(enemyTeam);
      Character enemyLvl = enemyTeam.choseMemberMaxLvl(enemyTeam);

      if (((Student) member).getCurrentKP() == ((Student) member).getMaxKP()) {
        // AI student
        if (member instanceof AIStudent) {
          // strategy[1] : attack if full hp or can lvl up (+4), else heal:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] attack the enemy with most HP;
            ((AIStudent) member).machineLearning(enemyHP);
          } else { // heals the user
            ((AIStudent) member).naturalLanguageProcessing();
          }
          // CSS student
        } else if (member instanceof CSStudent) {

          // strategy[1] :attack if friend has full hp or can lvl up (+4), else heal friend:
          if (friend.getHP() == friend.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {

            // chose the friend with the most dmg(highest atk) to help you attack an enemy
            ((CSStudent) member).pairWorking(friend, enemyTeam.choseMemberMaxHP(enemyTeam));
          } else { // heals friend
            ((CSStudent) member).support(friend);
          }
          // Cyber student
        } else if (member instanceof CyberStudent) {

          // strategy[1] : attack if full hp or can lvl up (+4), else heal:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {

            // dmg all the members of the enemy team
            ((CyberStudent) member).cyberAttack(enemyTeam);

          } else { // self studies to regenerate stats and increase lvl
            ((CyberStudent) member).selfStudy();
          }
          // SES student
        } else if (member instanceof SEStudent) {

          // strategy[1] : attack if full hp or can lvl up (+4), else heal teammates:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] attack the enemy with most spd;
            ((SEStudent) member).groupWork(enemySpd);
          } else { // use skill to heal allies
            ((SEStudent) member).groupDiscussion();
          }
        }
      } else { // launch normal attack on enemy team with highest lvl
        ((Student) member).javaProgramming(enemyLvl);
      }
    }
  }
}
