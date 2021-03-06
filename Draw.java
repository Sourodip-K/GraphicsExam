import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class Draw extends Canvas {


    public void paint(Graphics graphics) {

        // Asking the user for inputs
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rectangle's upper left corner: ");
        int x1 = Integer.parseInt(sc.nextLine());
        int y1 = Integer.parseInt(sc.nextLine());

        System.out.println("Enter Rectangle's lower right corner: ");
        int x2 = Integer.parseInt(sc.nextLine());
        int y2 = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the starting point of the line: ");
        int line_x1 = Integer.parseInt(sc.nextLine());
        int line_y1 = Integer.parseInt(sc.nextLine());

        System.out.println("Enter line end point");
        int line_x2 = Integer.parseInt(sc.nextLine());
        int line_y2 = Integer.parseInt(sc.nextLine());

        int height = y2 - y1;
        int width = x2 - x1;
        
        //Translation
        System.out.println("Enter translation factor in x direction:");
        int translation_x=sc.nextInt();
        System.out.println("Enter translation factor in y direction:");
        int translation_y=sc.nextInt();
        
        graphics.setColor(Color.BLACK);
        //Rectangle is drawn after translation
        graphics.drawRect(x1+translation_x, y1+translation_y, width, height);

        // Before entering the rectangle
        float m = (line_y2 - line_y1)/(line_x2 - line_x1);
        int c = line_y1 - (int)(line_x1 * m);
        int x_dash = (int)((y1 - c)/m);
        graphics.setColor(Color.green);
        graphics.drawLine(line_x1,line_y1,x_dash,y1);

        // Inside the rectangle
        int x_double_dash = (int)((y2 - c)/m);

        graphics.setColor(Color.RED);
        graphics.drawLine(x_dash,y1,x_double_dash,y2);

        // After exiting the rectangle
        graphics.setColor(Color.green);
        graphics.drawLine(x_double_dash,y2, line_x2, line_y2);
   
    }

    public static void main(String[] args) {

    	Draw m = new Draw();
        JFrame frame = new JFrame();
        frame.add(m);
        frame.setSize(700,700);
        frame.setVisible(true);

    }

}
