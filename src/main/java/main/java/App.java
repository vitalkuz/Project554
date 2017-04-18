package main.java;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class DrawingComponent extends JPanel {
    private ArrayList<Solder> solders = Up7.solders;


    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        int i = 0;

        while (i < solders.size()) {
            drawSolder(drp, solders.get(i), i);
            i++;
        }
    }

    private void drawSolder(Graphics2D drp, Solder solder, int i) {
        switch (solder.getTeam()) {
            case 0:
                drp.setColor(Color.red);
                break;
            case 1:
                drp.setColor(Color.blue);
                break;
            case 2:
                drp.setColor(Color.green);
                break;
            case 3:
                drp.setColor(Color.yellow);
                break;
            default:
                drp.setColor(Color.black);
        }

        drp.fillOval(solders.get(i).getX(), solders.get(i).getY(), 20, 20);
    }

}

class Up7 extends JFrame {
    public static ArrayList<Solder> solders = new ArrayList<>();
    private Integer width = 800;
    private Integer height = 800;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Up7() {
        super("Карта");
        JPanel jcp = new JPanel(new BorderLayout());
        setContentPane(jcp);
        jcp.add(new DrawingComponent(), BorderLayout.CENTER);
        jcp.setBackground(Color.gray);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) throws InterruptedException {
        boolean flagNotCaptured = true;
        Up7 field = new Up7();
        field.setVisible(true);
        solders.add(new Solder(field, 200, 100, 0));
        solders.add(new Solder(field, 200, 200, 1));
        int i = 0;
        while (i < 11) {
            TimeUnit.SECONDS.sleep(1);
            solders.get(1).move(200, 100 + i*10);
            i++;
        }
    }
}

class Solder {
    private Integer x;
    private Integer y;
    private Integer hp;
    private Up7 field;
    private Integer team;

    public Solder(Up7 field, int x, int y, int team) {
        super();
        this.field = field;
        this.x = x;
        this.y = y;
        this.team = team;
        field.repaint();
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        field.repaint();
    }

    public int getTeam() {
        return team;
    }

    public int getX() {
       return x;
    }

    public int getY() {
        return y;
    }
}



