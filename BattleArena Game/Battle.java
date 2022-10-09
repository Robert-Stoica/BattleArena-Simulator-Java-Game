
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Battle {
  private Team team1;
  private Team team2;
  private ArrayList<Character> characters;

  /** Constructor which takes to characters and initialises them */
  public Battle(Team team1, Team team2) {
    this.team1 = team1;
    this.team2 = team2;
  }

  /**
   * Method which takes two arrays of characters obtained form their teams and combines them in one
   * single array Sorts the array by comparing each members based on their speeds, after the array
   * is reversed, making it in descending order
   *
   * @return the sorted array of characters.
   */
  public ArrayList<Character> compareTOBoth() {

    characters = new ArrayList<>();
    characters.addAll(this.team1.members);
    characters.addAll(this.team2.members);

    characters.sort(
        new Comparator<Character>() {
          public int compare(Character c1, Character c2) {
            if (c1.getSpeed() > c2.getSpeed()) {
              return -1;
            } else if (c1.getHP() < c2.getHP()) {
              return 1;
            } else {
              return 0;
            }
          }
        });

    Collections.reverse(Collections.singletonList(characters));
    return characters;
  }

  /** Method which verifies if a the members of a team are alive */
  public int alive(Team team) {
    int i = 5;
    for (Character c : team.getMembers()) if (c.getHP() <= 0) i--;
    return i;
  }

  /**
   * Method which creates a report of each player stats, such as hp and level at the current
   * instance
   */
  private void report(Team teamA, Team teamB) {
    System.out.println("-------------- REPORT -------------- \n");
    System.out.println("Stats Members of the team: " + team1.getName() + "\n");
    for (Character member : team1.getMembers()) {
      System.out.println(
          member.getName() + ", hp[" + member.getHP() + "], lvl[" + member.getLevel() + "]");
    }

    System.out.println("\nStats Members of the team: " + team2.getName() + "\n");
    for (Character member : team2.getMembers()) {
      System.out.println(
          member.getName() + ", hp[" + member.getHP() + "], lvl[" + member.getLevel() + "]");
    }
    System.out.println("\n");
  }

  /**
   * Method which defines the fight between teams. It respects the specs guidelines Loops through
   * the sorted speed array of the team characters and it establishes which one of them will attack
   * first in descending order At the end of each round, the teams are checked if they are still
   * alive or not, based on that it prints the wining team otherwise it continues Once every round
   * has ended if the teams are still alive it declares a draw and stops the program.
   */
  public Team fight() {
    System.out.println(
        "\n" + this.team1.getName() + " will battle against " + this.team2.getName() + "!\n");
    try {

      for (int i = 1; i <= 30; i++) {
        Thread.sleep(500);

        System.out.println("---------------- Round " + i + " ------------------");

        for (Character c : compareTOBoth()) {
          Team team = c.getTeam();
          if (team == team1) {
            team1.move(c, team2);
          } else if (team == team2) {
            team2.move(c, team1);
          }
        }

        if (alive(team1) == 0) {
          report(team1, team2);
          System.out.println("---------------- RESULT ------------------");
          System.out.println("Monster " + this.team2.getName() + " has won");
          System.out.println("------------------------------------------");
          return team1;
        } else if (alive(team2) == 0) {
          report(team1, team2);
          System.out.println("---------------- RESULT ------------------");
          System.out.println("            "+this.team1.getName() + " has won");
          System.out.println("------------------------------------------");
          return team2;
        } else continue;
      }

    } catch (InterruptedException e) {
      System.out.println("error");
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (alive(team2) != 0 && alive(team1) != 0) {
      report(team1, team2);
      System.out.println("---------------- RESULT ------------------");
      System.out.println("        Draw ! " + team1.getName() + " and " + team2.getName());
      System.out.println("------------------------------------------");
    }
    return null;
  }
}
