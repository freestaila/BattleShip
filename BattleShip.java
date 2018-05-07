import java.util.Random;
import java.util.Scanner;

public class BattleShip {
    public static Scanner input = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        hello();

        //wywolanie pierwszy raz czystej mapy
        char[][] ocean = new char[10][10];
        userMap(ocean);

        //USER SHIPS
        int userShips = 0;
        while (userShips <5) {
            //deploy ships
            System.out.print("Enter X coordinate for your ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your ship: ");
            int y = input.nextInt();
            if(x>=10 || y >= 10){
                System.out.println("Out of range your outside the map:<");
                continue;
            } else if(ocean[x][y]==0 && x>=0 && x<=9 && y>=0 && y<= 0) {
                ocean[x][y] = '@';
            }else if ( ocean[x][y] == '@'){
                while (ocean[x][y] == '@') {
                    System.out.println("You already have a ship here or your out of map. Please take the other coordinates:");
                    System.out.print("Enter X coordinate for your ship: ");
                    x = input.nextInt();
                    System.out.print("Enter Y coordinate for your ship: ");
                    y = input.nextInt();
                }
                ocean[x][y]= '@';
            }
            userShips++;
        }

        //PC SHIPSs
        int pcShips=0;
        while (pcShips <5) {
            int x = rand.nextInt(9) + 0;
            int y = rand.nextInt(9) + 0;
            if(ocean[x][y] == 0) {
                ocean[x][y] = '+';
            }else{
                while (ocean[x][y] == '@' || ocean[x][y] == '+') {
                    x = rand.nextInt(9) + 0;
                    y = rand.nextInt(9) + 0;
                }
                ocean[x][y] = '@';
            }
            pcShips++;
        }

        game(ocean);
    }



    //Greeting the player
    public static void hello() {
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Right, now, the sea is empty.");
    }

    //Showing the map
    public static void userMap(char[][] map) {
        //creating numbers on the grid
        System.out.println("   0123456789");
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println("|" + i);
        }
        System.out.println("   0123456789");
    }
    public static void game(char[][] map){
        int userShips = 5;
        int pcShips = 5;

        char[][] gameMap = new char[10][10];

        while (userShips>0 || pcShips >0)
        {
            System.out.println("Your turn");
            System.out.println("Input X:");
            int x = input.nextInt();
            System.out.println("Input Y:");
            int y = input.nextInt();
            if(map[x][y] == '@'){
                System.out.println("Nice try it was your ship prrrrrr");
                gameMap[x][y] = '-';
                userShips = userShips-1;
                userMap(gameMap);
            }else if(map[x][y] == '+')
            {
                System.out.println("Good job you hit enemy's ship");
                gameMap[x][y] = 'H';
                pcShips = pcShips-1;
                userMap(gameMap);

                System.out.println("Your turn");
                System.out.println("Input X:");
                x = input.nextInt();
                System.out.println("Input Y:");
                y = input.nextInt();
                continue;
            }else {
                System.out.println("ups nothing here keep trying");
                gameMap[x][y] = 'x';
                userMap(gameMap);
            }
            //PC TURN
            System.out.println("PC turn");
            x = rand.nextInt(9)+1;
            y = rand.nextInt(9)+1;
            if(map[x][y] == '+'){
                System.out.println("PC hit his own ship HA HA");
                gameMap[x][y] = '-';
                pcShips = pcShips-1;
                userMap(gameMap);
            }else if(map[x][y] == '+')
            {
                System.out.println("PC hit yours ship :<");
                gameMap[x][y] = '#';
                pcShips = pcShips-1;
                userMap(gameMap);
            }else {
                System.out.println("PC is blind and hit nothing :)");
                gameMap[x][y] = 'x';
                userMap(gameMap);
            }

            if(userShips==0){
                System.out.println("SORRY YOU LOST");
                System.out.println("BETTER LUCK NEXT TIME");
                userMap(gameMap);
            } else if(pcShips ==0){
                System.out.println("YOU WIN!!!!!!!!!!!");
                System.out.println("YOU WIN!!!!!!!!!!!");
                System.out.println("YOU WIN!!!!!!!!!!!");
                userMap(gameMap);
            }
        }
    }
  /* public static void check(char[][] checkmap){

    }*/
}



