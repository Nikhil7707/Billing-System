package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterinfo extends JFrame implements ActionListener {
    Choice meterLocCho,meterTypCho,phaseCodeCho,billTypCho;
    JButton submit;
    String meternumber;
    meterinfo(String meternumber){
        this.meternumber=meternumber;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meterNumberText = new JLabel(meternumber);
        meterNumberText.setBounds(180,80,150,20);
        panel.add(meterNumberText);

        JLabel meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("Oustside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        JLabel meterTyp = new JLabel("Meter Type");
        meterTyp.setBounds(50,160,100,20);
        panel.add(meterTyp);

        meterTypCho = new Choice();
        meterTypCho.add("Electric");
        meterTypCho.add("Solar");
        meterTypCho.add("Smart");
        meterTypCho.setBounds(180,160,150,20);
        panel.add(meterTypCho);

        meterTypCho.setBounds(180,160,150,20);
        panel.add(meterTypCho);

        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("011");
        phaseCodeCho.add("012");
        phaseCodeCho.add("013");
        phaseCodeCho.add("014");
        phaseCodeCho.add("015");
        phaseCodeCho.add("016");
        phaseCodeCho.add("017");
        phaseCodeCho.add("018");
        phaseCodeCho.add("019");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        JLabel billTyp = new JLabel("Bill Type");
        billTyp.setBounds(50,240,100,20);
        panel.add(billTyp);

        billTypCho = new Choice();
        billTypCho.add("Residental");
        billTypCho.add("Commercial");
        billTypCho.setBounds(180,240,150,20);
        panel.add(billTypCho);

        JLabel day = new JLabel("30 Days");
        day.setBounds(50,280,150,20);
        panel.add(day);

        JLabel note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        JLabel note1 = new JLabel("Bill is calculated for for 30 days only");
        note1.setBounds(50,340,300,20);
        panel.add(note1);

        submit = new JButton("Submit");
        submit.setBounds(220,390,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);


        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        add(imgLabel,"East");


        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            String smeterNum =meternumber;
            String smeterLoc = meterLocCho.getSelectedItem();
            String smeterTyp = meterTypCho.getSelectedItem();
            String sphaseCode = phaseCodeCho.getSelectedItem();
            String sbillTyp = billTypCho.getSelectedItem();
            String sdays ="30";

            String query_meterinfo = "insert into meter_info values('"+smeterNum+"','"+smeterLoc+"','"+smeterTyp+"','"+sphaseCode+"','"+sbillTyp+"','"+sdays+"')";
            try{
                database c = new database();
                c.statement.executeUpdate(query_meterinfo);

                JOptionPane.showMessageDialog(null,"Meter information saved successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new meterinfo("");
    }
}
