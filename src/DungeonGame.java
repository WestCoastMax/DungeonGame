import java.util.Random;
import java.util.Scanner;
public class DungeonGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        String[] classes = {"Magician", "Swordsmen", "Archer"};
        String[] enemies = {"Assasin", "Undead", "Ogre"};

        int playerHealth = 100;
        int enemyHealth = 100;
        int playerAttackDamage = 100;
        int enemyAttackDamage = 100;
        boolean gameRunning = true;
        System.out.print("Welcome to the dungeon!(press y to play) ");
        String play = console.next();
        while (play.equals("y")) {
            introduction(classes, enemies, console);
            game(console, rand, enemies, playerAttackDamage, enemyAttackDamage, playerHealth, enemyHealth, gameRunning);
            System.out.print("Wanna play again?(press y for Yes, n for No) ");
            play = console.next();
        }
        System.out.println("Thanks for playing!");
    }

    public static void introduction(String[] classes, String[] enemies, Scanner console) {
        System.out.println("-----------------------------------");
        System.out.print("Choose your class: " + classes[0] + " " + classes[1] + " " + classes[2] + " ");
        String choice = console.next();
        while (!choice.equals(classes[0]) && !choice.equals(classes[1]) && !choice.equals(classes[2])) {
            System.out.print("Try again! Choose your class: " + classes[0] + " " + classes[1] + " " + classes[2] + " ");
            choice = console.next();
        }
    }


    public static void game(Scanner console, Random rand, String[] enemies, int enemyHealth, int playerHealth, int playerAttackDamage, int enemyAttackDamage, boolean gameRunning) {
        System.out.println("Congratulations! You’ve successfully made it this far into the dungeon!");
        String enemy = enemies[rand.nextInt(enemies.length)];
        while (gameRunning) {
            System.out.println("What terrible luck! You’ve come across an " + enemy + "!");
            System.out.println("What will you do?!");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Run!");
            String option = console.next();
            boolean playing = true;
            while (!option.equals("1") && !option.equals("2")) {
                System.out.println("\t1. Attack");
                System.out.println("\t2. Run!");
                option = console.next();
            }
            while (option.equals("2")) {
                System.out.println("You’ve decided to run away like a coward and have been attacked!");
                int playerD = rand.nextInt(playerAttackDamage);
                playerHealth -= playerD;
                System.out.println("Your HP is now " + playerHealth + ". Deserting is not an option you must see this to the end :)");
                if (playerHealth <= 0) {
                    gameRunning = false;

                    break;
                }
                System.out.println("\t1. Attack");
                System.out.println("\t2. Run!");
                option = console.next();


            }            while ((enemyHealth > 0 && playerHealth > 0)) {
                int enemyDamage = rand.nextInt(enemyAttackDamage);
                enemyHealth -= enemyDamage;
                if (enemyDamage == 99) {
                    System.out.println("You’ve just defeated the " + enemy + "! Congrats!");
                    break;
                }
                if (enemyHealth > 0) {
                    System.out.println("You have chosen to attack." + enemy + "'s HP is " + enemyHealth);
                } else {
                    break;
                }
                int playerDamage = rand.nextInt(playerAttackDamage);
                playerHealth -= playerDamage;
                if (playerDamage == 99) {
                    System.out.println("You’ve been defeated. Better luck next time!");
                    break;
                }
                if (playerHealth > 0) {
                    System.out.println("You have angered the " + enemy + "! He attacks back! Your HP is now " + playerHealth);
                } else {
                    break;
                }
                if (playerHealth > 0 && enemyHealth > 0) {
                    System.out.println("What will you do?!");
                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Run!");
                    option = console.next();
                    while (!option.equals("1") && !option.equals("2")) {
                        System.out.println("\t1. Attack");
                        System.out.println("\t2. Run!");
                        option = console.next();
                    }
                    while (option.equals("2")) {
                        System.out.println("You’ve decided to run away like a coward and have been attacked!");
                        int playerD = rand.nextInt(playerAttackDamage);
                        playerHealth -= playerD;
                        System.out.println("Your HP is now " + playerHealth + ". Deserting is not an option you must see this to the end :)");
                        if (playerHealth <= 0) {
                            gameRunning = false;

                            break;
                        }
                        System.out.println("\t1. Attack");
                        System.out.println("\t2. Run!");
                        option = console.next();


                    }
                }
            }
             if (playerHealth <= 0) {
                System.out.println("You have died. Better luck next time!");
                break;
            } else {
                System.out.println(("You've defeated the " + enemy + "! Congratulations! "));
                break;
            }
        }
    }
}
