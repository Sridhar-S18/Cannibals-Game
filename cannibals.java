import java.util.Scanner;

public class MissionariesAndCannibals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String boatSide = "Right";
        int missionariesOnRight = 3, cannibalsOnRight = 3;
        int missionariesOnLeft = 0, cannibalsOnLeft = 0;
        
        System.out.println("M=" + missionariesOnLeft + " C=" + cannibalsOnLeft + " |-----B| " + "M=" + missionariesOnRight + " C=" + cannibalsOnRight);
        
        while (true) {
            System.out.print("No of missionaries or enter 10 to quit: ");
            int missionaries = scanner.nextInt();
            
            if (missionaries == 10) {
                System.out.println("You Quit. Game Over!");
                break;
            }
            
            System.out.print("No of cannibals: ");
            int cannibals = scanner.nextInt();
            
            if ((missionaries + cannibals) != 1 && (missionaries + cannibals) != 2) {
                System.out.println("Invalid Move");
                continue;
            }
            
            if (boatSide.equals("Right")) {
                if (missionariesOnRight < missionaries || cannibalsOnRight < cannibals) {
                    System.out.println("Invalid Move");
                    continue;
                }
                
                missionariesOnRight -= missionaries;
                cannibalsOnRight -= cannibals;
                missionariesOnLeft += missionaries;
                cannibalsOnLeft += cannibals;
                
                System.out.println("M=" + missionariesOnLeft + " C=" + cannibalsOnLeft + " |B-----| " + "M=" + missionariesOnRight + " C=" + cannibalsOnRight);
                
                boatSide = "Left";
            } else {
                if (missionariesOnLeft < missionaries || cannibalsOnLeft < cannibals) {
                    System.out.println("Invalid Move");
                    continue;
                }
                
                missionariesOnLeft -= missionaries;
                cannibalsOnLeft -= cannibals;
                missionariesOnRight += missionaries;
                cannibalsOnRight += cannibals;
                
                System.out.println("M=" + missionariesOnLeft + " C=" + cannibalsOnLeft + " |-----B| " + "M=" + missionariesOnRight + " C=" + cannibalsOnRight);
                
                boatSide = "Right";
            }
            
            if ((missionariesOnRight < cannibalsOnRight && missionariesOnRight > 0) ||
                (missionariesOnLeft < cannibalsOnLeft && missionariesOnLeft > 0)) {
                System.out.println("You Lose");
                break;
            }
            
            if (missionariesOnLeft == 3 && cannibalsOnLeft == 3) {
                System.out.println("You Win!");
                break;
            }
        }
        
        scanner.close();
    }
}
