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
      Character enemyAtk = enemyTeam.choseFriendMaxAtk();
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
          } // ElecNanoTechStudent
        } else if (member instanceof ElecNanoTechStudent) {
          // strategy[1] : attack if depleted hp or can lvl up (+4), else heal teammates:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] give health and attack the characters with most atk
            ((ElecNanoTechStudent) member).microAdvancement(friend, enemyAtk);
            // use normal student attack to weaken the opponent
          } else{
            ((Student) member).javaProgramming(enemyLvl);
          }
          // ElecSysSecureStudent
        } else if (member instanceof ElecSysSecureStudent) {
          // strategy[1] : attack if depleted hp or can lvl up (+4), else heal teammates:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] attack the enemy with most health
            ((ElecSysSecureStudent) member).breakingSystemSecurity(enemyHP);

          } else if (member.getHP() <= member.getMaxHP() * .4 && member.getHP() > 0) {
            // use skill to regain hp if its really depleted, under 40%
            ((ElecSysSecureStudent) member).cryptograpicAdvantage();
          } else if (member.getHP() > member.getMaxHP() * .4
              && member.getHP() != member.getMaxHP()) {
            // strategy[4] use self study to lvl up and get additional boosts if life is above 40%
            // but not max
            ((Student) member).selfStudy();
          }
          // ElecPhotonicsStudent
        } else if (member instanceof ElecPhotonicsStudent) {
          // strategy[1] : use attack if full hp, else increase speed :
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            ((ElecPhotonicsStudent)member).PhotonsAttack(enemySpd);
		// strategy[2] use skill to increase speed
          }else {
            ((ElecPhotonicsStudent)member).FiberReach();
          }
          // ELecWirelessComStudent
        } else if (member instanceof ELecWirelessComStudent) {
          // strategy[1] : use attack if full hp or about to lvl up(+4), else increase memebers
          // defence:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] attack all members of the enemy team
            ((ELecWirelessComStudent) member).WirelessMindControl(enemyTeam);
          } else { // increase teammates defence
            ((ELecWirelessComStudent) member).ElectroMagneticField();
          }
        } else if (member instanceof ElecAIStudent) {
          // strategy[1] : attack if full hp or can lvl up (+4), else allow member to lvl up:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] attack the enemy with most HP;
            ((ElecAIStudent) member).autonomousAttack(enemyHP);
          } else { // heals the user
            ((ElecAIStudent) member).dataGathering();
          }
          // ElecCSStudent
        } else if (member instanceof ElecCSStudent) {
          // strategy[1] : attack if full hp or can lvl up (+4), else heal:
          if (member.getHP() == member.getMaxHP() || (member.getTargetEP() - member.getEP() <= 4)) {
            // strategy[2] attack enemy with highest spd
            ((ElecCSStudent) member).SystematicAttack(enemySpd);
          } else { // heal member using self study
            ((ElecCSStudent) member).selfStudy();
          }
        }
      } else { // launch normal attack on enemy team with highest lvl
        ((Student) member).javaProgramming(enemyLvl);
      }
    }
  }
}
