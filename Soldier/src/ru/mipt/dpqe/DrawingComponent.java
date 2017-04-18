package ru.mipt.dpqe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class DrawingComponent extends JPanel {
    private ArrayList<Soldier> soldiers = Up7.soldiers;


    @Override
    protected void paintComponent(Graphics gh) {
        Graphics2D drp = (Graphics2D)gh;
        int i = 0;

        drp.drawOval(360, 360, 40, 40);

        while (i < soldiers.size()) {
            drawSolder(drp, soldiers.get(i), i);
            i++;
        }
    }

    private void drawSolder(Graphics2D drp, Soldier solder, int i) {
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

        drp.fillOval(soldiers.get(i).getX(), soldiers.get(i).getY(), 20, 20);
        if (solder.percentOfHp() > 0.75) {
            drp.setColor(Color.green);
        } else if (solder.percentOfHp() > 0.25) {
            drp.setColor(Color.yellow);
        } else {
            drp.setColor(Color.red);
        }
        drp.fillRect(soldiers.get(i).getX()-5, soldiers.get(i).getY()-10, (int)(30 * soldiers.get(i).percentOfHp()),5);
        drp.drawRect(soldiers.get(i).getX()-5, soldiers.get(i).getY()-10, 30,5);

    }

}
