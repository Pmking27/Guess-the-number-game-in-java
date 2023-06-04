import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        int width = 150;
        int height = 30;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("SansSerif", Font.BOLD, 10));

        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("GUESS THE NUMBER", 5, 20);

        for (int y = 0; y < height; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < width; x++) {

                sb.append(image.getRGB(x, y) == -16777216 ? " " : "|");

            }

            if (sb.toString().trim().isEmpty()) {
                continue;
            }

            System.out.println(sb);
        }

        int random_number = (int)(Math.random()*100);
       int guess = 0;
       while(true){
           Scanner sc = new Scanner(System.in);
           if (guess==0)
                System.out.print("If you want to stop the game please Enter the -1 \nGuess the number between 1 to 100: ");
           else
               System.out.print("\nGuess the number between 1 to 100: ");
           int guess_number = sc.nextInt();
           guess++;
           if(guess_number==random_number){
               System.out.println("You win");
               System.out.print("Total Guess is : ");
               System.out.println(guess);
               break;
           } else if (guess_number == -1) {
               System.out.print("Number is :");
               System.out.println(random_number);
               break;
           } else if (guess_number>random_number){
               System.out.println("Lower Number Please!!!\n");
           }
           else {
               System.out.println("Higher Number Please!!!\n");
           }
       }
    }
}