import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

class Game extends JFrame{
    ImageIcon imageRock, imagePaper, imageScissors;
    public void setup(){
        imageRock = new ImageIcon(new ImageIcon("Images/rock.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        imagePaper = new ImageIcon(new ImageIcon("Images/paper.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        imageScissors = new ImageIcon(new ImageIcon("Images/scissor.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        //Creating Label
        JLabel labelRock = new JLabel();
        labelRock.setText("Rock");
        labelRock.setIcon(imageRock);
        labelRock.setHorizontalTextPosition(JLabel.CENTER);
        labelRock.setVerticalTextPosition(JLabel.BOTTOM);
        labelRock.setBounds(150,300,100,100);

        JLabel labelPaper = new JLabel();
        labelPaper.setText("Paper");
        labelPaper.setIcon(imagePaper);
        labelPaper.setHorizontalTextPosition(JLabel.CENTER);
        labelPaper.setVerticalTextPosition(JLabel.BOTTOM);
        labelPaper.setBounds(250,300,100,100);

        JLabel labelScissors = new JLabel();
        labelScissors.setText("Scissors");
        labelScissors.setIcon(imageScissors);
        labelScissors.setHorizontalTextPosition(JLabel.CENTER);
        labelScissors.setVerticalTextPosition(JLabel.BOTTOM);
        labelScissors.setBounds(350,300,100,100);

        //adding components in Frame
        add(labelRock);
        add(labelPaper);
        add(labelScissors);
        setLayout(null);
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.setTitle("ROCK PAPER SCISSOR");
        g.setBounds(200,200,600,600);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.getContentPane().setBackground(Color.lightGray);
        g.setup();
        g.setResizable(true);
        g.setVisible(true);
    }
    
}