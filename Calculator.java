import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class Calculator implements ActionListener{
    JButton[] allButtons=new JButton[25];
    JButton[] numberbuttons=new JButton[10];
    JButton[] functionalbuttons=new JButton[8];
    JButton[] scientificbuttons=new JButton[9];
    JButton acbutton=new JButton();
    JButton delButton=new JButton();
    JTextField text;
    JPanel pan;
    JFrame frame;

    double num1=0,num2=0,result=0;
    char operator;
    
    String[] funcString={"+","-","*","/",".","=","AC","DEL"};
    String[] sciString={"sin","cos","tan","log","e","π","√x","X!","x²"};

    Font newfont=new Font("Serif",Font.BOLD,25);
    Border border=BorderFactory.createEmptyBorder();

    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(435, 600);
        frame.setLayout(null);
        frame.setLocation(400,40);
        frame.getContentPane().setBackground(Color.BLACK);

        text=new JTextField("");
        text.setBounds(0, 0, 420, 60);
        text.setBackground(Color.darkGray);
        text.setBorder(border);
        text.setForeground(new Color(2,255,255));
        text.setFont(new Font("MV Boli",Font.PLAIN,40));
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setEditable(false);

        pan=new JPanel(new GridLayout(5,5,10,10));
        //pan.setBounds(50,100,300,300);
        pan.setBounds(10,80,400,400);
        pan.setBackground(Color.BLACK);

        for (int i=0;i<10;i++){                                             //creating number buttons
            numberbuttons[i]=new JButton(String.valueOf(i));
            numberbuttons[i].setForeground(Color.YELLOW);
            numberbuttons[i].setFocusable(false);
            numberbuttons[i].setFont(newfont);
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setBackground(new Color(000033));
        }

        for (int i=0;i<8;i++){                                            //creating functinal operative buttons
            functionalbuttons[i]=new JButton(funcString[i]);
            functionalbuttons[i].setForeground(Color.white);
            functionalbuttons[i].setFocusable(false);
            functionalbuttons[i].setFont(newfont);
            functionalbuttons[i].addActionListener(this);
            functionalbuttons[i].setBackground(new Color(000033));
        }

        for (int i=0;i<9;i++){                                            //creating scientific buttons
            scientificbuttons[i]=new JButton(sciString[i]);
            scientificbuttons[i].setForeground(new Color(0,255,255));
            scientificbuttons[i].setFocusable(false);
            scientificbuttons[i].setFont(newfont);
            scientificbuttons[i].addActionListener(this);
            scientificbuttons[i].setBackground(new Color(000033));
        }

        
        pan.add(scientificbuttons[0]); //1st row
        pan.add(scientificbuttons[1]);
        pan.add(scientificbuttons[2]);
        pan.add(scientificbuttons[3]);
        pan.add(scientificbuttons[4]);

        pan.add(scientificbuttons[5]); //2nd row
        pan.add(numberbuttons[7]);
        pan.add(numberbuttons[8]);
        pan.add(numberbuttons[9]);
        pan.add(functionalbuttons[0]);

        pan.add(scientificbuttons[6]); //3rd row
        pan.add(numberbuttons[4]);
        pan.add(numberbuttons[5]);
        pan.add(numberbuttons[6]);
        pan.add(functionalbuttons[1]);

        pan.add(scientificbuttons[7]);//4th row
        pan.add(numberbuttons[1]);
        pan.add(numberbuttons[2]);
        pan.add(numberbuttons[3]);
        pan.add(functionalbuttons[2]);

        pan.add(scientificbuttons[8]); //5th row
        pan.add(functionalbuttons[4]);
        pan.add(numberbuttons[0]);
        pan.add(functionalbuttons[5]);
        pan.add(functionalbuttons[3]);
        
        acbutton=functionalbuttons[6];
        delButton=functionalbuttons[7];
        acbutton.setBackground(Color.GREEN);
        delButton.setBackground(Color.red);
        acbutton.setForeground(Color.black);
        delButton.setForeground(Color.black);
        delButton.setBounds(80, 500, 100, 40);
        acbutton.setBounds(200, 500, 100, 40);
        

        frame.add(text);
        frame.add(pan);
        frame.add(delButton);
        frame.add(acbutton);

        frame.setVisible(true);

    }

    public static void main(String args[]){
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //for number buttons
        for(int i=0;i<10;i++){
            if(e.getSource()==numberbuttons[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }

        }
        //for delete and clear button
        if(e.getSource()==delButton){
            String string=text.getText();
            text.setText("");
            for (int i=0;i<string.length()-1;i++){
                text.setText(text.getText()+string.charAt(i));
                
            }

        }

        if(e.getSource()==acbutton){
            text.setText("");    
            }
        try{
        //for functional buttons      //funcString={"+","-","*","/",".","=","AC","DEL"};
        if(e.getSource()==functionalbuttons[0]){
            num1=Double.parseDouble(text.getText());
            operator='+';
            text.setText("");

        }
        if(e.getSource()==functionalbuttons[1]){
            num1=Double.parseDouble(text.getText());
            operator='-';
            text.setText("");

        }
        if(e.getSource()==functionalbuttons[2]){
            num1=Double.parseDouble(text.getText());
            operator='*';
            text.setText("");

        }
        if(e.getSource()==functionalbuttons[3]){
            num1=Double.parseDouble(text.getText());
            operator='/';
            text.setText("");

        }
        if(e.getSource()==functionalbuttons[4]){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()==functionalbuttons[5]){
            num2=Double.parseDouble(text.getText());
            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                default:
                    result=Double.parseDouble(text.getText());
                    break;
            }
            text.setText(String.valueOf(result));

        }
    }
        catch(Exception exp1){
            JOptionPane.showMessageDialog(frame, "SOMETHING GOING WRONG!!");
        }
        try{
        //for Scientific buttons  //sciString={"sin","cos","tan","log","e","π","√x","X!","x²"};
        
        if(e.getSource()==scientificbuttons[0]){
            num1=Double.parseDouble(text.getText());
            result=(num1 * 3.141592653589793238) / 180;
            text.setText(String.valueOf(String.format("%.2f",Math.sin(result))));

        }
        if(e.getSource()==scientificbuttons[1]){
            num1=Double.parseDouble(text.getText());
            result=(num1 * 3.141592653589793238) / 180;
            text.setText(String.valueOf(String.format("%.2f",Math.cos(result))));

        }
        if(e.getSource()==scientificbuttons[2]){
            num1=Double.parseDouble(text.getText());
            result=(num1 * 3.141592653589793238) / 180;
            text.setText(String.valueOf(String.format("%.2f",Math.tan(result))));

        }
        if(e.getSource()==scientificbuttons[3]){
            num1=Double.parseDouble(text.getText());
            text.setText(String.valueOf(String.format("%.2f",Math.log(num1))));
        }
        if(e.getSource()==scientificbuttons[4]){
            text.setText(String.valueOf(2.72));
        }
        if(e.getSource()==scientificbuttons[5]){
            text.setText(String.valueOf(3.14));
        }
        if(e.getSource()==scientificbuttons[6]){
            num1=Double.parseDouble(text.getText());
            text.setText(String.valueOf(String.format("%.2f",Math.sqrt(num1))));
        }
        if(e.getSource()==scientificbuttons[7]){
            num1=Double.parseDouble(text.getText());
            result=1;
            while(num1>=1){
                result=result*num1;
                num1--;

            }
            text.setText(String.valueOf(result));
        }

        if(e.getSource()==scientificbuttons[8]){
            num1=Double.parseDouble(text.getText());
            text.setText(String.valueOf(String.format("%.2f",Math.pow(num1,2))));
        }
    }
        catch(Exception exp2){
            JOptionPane.showMessageDialog(frame, "SOMETHING GOING WRONG!!");
        }

        }
       

    }
    
   