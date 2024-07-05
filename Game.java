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

    //Creating label for ComputerChoice and Results
    JLabel computerChoice,result;
    int compute_Score=0,player_Score=0;
    //Creating Label for Displaying Score
    JLabel computeScore,playerScore;
    ImageIcon imageRock, imagePaper, imageScissors;
    public void setup(){
        imageRock = new ImageIcon(new ImageIcon("Images/rock.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        imagePaper = new ImageIcon(new ImageIcon("Images/paper.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        imageScissors = new ImageIcon(new ImageIcon("Images/scissor.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        //Creating Label
        computerChoice = new JLabel();
        computerChoice.setHorizontalTextPosition(JLabel.CENTER);
        computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
        computerChoice.setBounds(250,90,100,100);

        result  = new JLabel();
        result.setFont(new Font("Cambria",Font.BOLD,21));
        result.setBounds(250,450,100,100);

        JLabel score = new JLabel();
        score.setBounds(500,0,100,100);

        computeScore = new JLabel();
        computeScore.setText("Computer : 0");
        computeScore.setBounds(500,15,100,100);

        playerScore = new JLabel();
        playerScore.setText("Player : 0");
        playerScore.setBounds(500,30,100,100);

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

        //adding mouse listener events
        labelRock.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                calculate(labelRock.getText());
            }            
        });
        labelRock.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                calculate(labelPaper.getText());
            }            
        });
        labelScissors.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                calculate(labelScissors.getText());
            }            
        });

        //adding components in Frame
        add(labelRock);
        add(labelPaper);
        add(labelScissors);
        add(computerChoice);
        add(result);
        add(score);
        add(computeScore);
        add(playerScore);
        setLayout(null);
    }

    public void calculate(String player){
        String[] list = {"Rock","Paper","Scissor"};   
        int random = (int)((Math.random()*10)%3);
        String computer = list[random];
        
        //Displays Computer Choice on screen
        computerChoice.setText(computer);
        if(random==0){
            computerChoice.setIcon(imageRock);
        }
        else if(random==1){
            computerChoice.setIcon(imagePaper);
        }
        else{
            computerChoice.setIcon(imageScissors); 
        }

        //Logic
        String res="";
        if(player.equals(computer)){
            res = "Draw";
        }
        else if(player.equals("Rock")){
            if(computer.equals("paper")){
                res = "You Lose!";
                compute_Score++;
            }
            else{
                res = "You Win!";
                player_Score++;
            }
        }
        else if(player.equals("Paper")){
            if(computer.equals("Scissor")){
                res = "You Lose!";
                compute_Score++;
            }
            else{
                res = "You Win!";
                player_Score++;
            }
        }
        else{
            if(computer.equals("Rock")){
                res = "You Lose!";
                compute_Score++;
            }
            else{
                res = "You Win!";
                player_Score++;
            }
        }

        result.setText(res);
        playerScore.setText("Player : "+playerScore);
        computeScore.setText("Computer : "+computeScore);
    }
    public static void main(String[] args) {
        Game g = new Game();
        g.setTitle("ROCK PAPER SCISSOR");
        g.setBounds(200,200,1000,600);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.getContentPane().setBackground(Color.lightGray);
        g.setup();
        g.setResizable(true);
        g.setVisible(true);
    }
    
}