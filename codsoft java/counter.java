import java.awt.*;
import java.awt.event.*;
import java.io.*;

class counter extends WindowAdapter implements ActionListener {
    Frame f;
    MenuBar mb;
    Menu m1;
    TextArea ta;
    MenuItem open, countword;
    String filename, words;
    String[] arr;
    TextField tf;
    int total = 0;

    public counter() {
        f = new Frame();
        f.setSize(500, 500);
        f.setLocation(300, 50);
        f.setBackground(Color.green);
        mb = new MenuBar();
        m1 = new Menu("count");
        countword = new Menu("Count Words");
        countword.addActionListener(this);
        open = new Menu("Count From File");
        open.addActionListener(this);
        ta = new TextArea();
        ta.setBackground(Color.cyan);
        m1.add(countword);
        m1.add(open);
        mb.add(m1);

        f.add(ta);
        f.setMenuBar(mb);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.setVisible(false);
                f.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            ta.setText("");
            open();
        }
        if (e.getSource() == countword) {
            countword();
        }
    }

    private void countword() {
        Dialog d = new Dialog(f, "Word Counter");
        d.setSize(300, 130);
        d.setLocation(500, 100);
        d.setBackground(Color.orange);
        Panel gp = new Panel();

        gp.setLayout(new GridLayout(2, 0));
        Panel p = new Panel();
        p.setLayout(new GridLayout(0, 2));
        Panel p2 = new Panel();
        p2.setLayout(new GridBagLayout());
        Label l = new Label("Total Words Are");
        l.setForeground(Color.black);
        //
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;
        g.gridheight = 2;
        g.ipadx = 2;
        g.ipady = 4;
        Insets i = new Insets(0, 30, 0, 5);
        g.insets = i;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.CENTER;
        g.weightx = 1.0;
        g.weighty = 1.0;
        //
        p2.add(l, g);
        p.add(p2);
        Panel p3 = new Panel();
        p3.setLayout(new GridBagLayout());
        tf = new TextField("Press Count");

        tf.setForeground(Color.red);
        tf.setBackground(Color.lightGray);
        Insets i2 = new Insets(0, 0, 0, 5);
        g.insets = i2;
        p3.add(tf, g);
        p.add(p3);
        gp.add(p);
        Panel bt = new Panel();
        bt.setLayout(new GridBagLayout());
        Button b1 = new Button("Count");
        b1.setForeground(Color.magenta);
        b1.addActionListener((e) -> {
            if (ta.getText().equals("")) {
                total = 0;
            } else
                total = 1;
            String words = ta.getText();
            arr = words.split("\\s+");

            for (int j = 1; j < arr.length; j++) {
                total++;
            }
            tf.setText(Integer.toString(total));

        });
        Insets i3 = new Insets(0, 180, 0, 30);
        g.insets = i3;
        g.fill = GridBagConstraints.NONE;
        bt.add(b1, g);
        gp.add(bt);
        d.add(gp);

        d.setVisible(true);
        d.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);
                d.dispose();
            }
        });
    }

    private void open() {
        FileDialog fd = new FileDialog(f, "load", FileDialog.LOAD);
        fd.setBackground(Color.red);
        fd.setVisible(true);
        filename = fd.getDirectory() + fd.getFile();
        if (filename == null)
            return;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            String line = bf.readLine();
            while (line != null) {
                ta.setText(line);
                line = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filename + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filename + "'");
        }
    }

    public static void main(String args[]) {
        counter c = new counter();
    }

}

