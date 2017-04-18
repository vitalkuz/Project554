package main.java;

class Solder {
    private Integer x;
    private Integer y;
    private Integer hp;
    private Up7 field;
    private Integer team;

    Solder(Up7 field, int x, int y, int team) {
        super();
        this.field = field;
        this.x = x;
        this.y = y;
        this.team = team;
        field.repaint();
    }

    void move(int x, int y) {
        this.x = x;
        this.y = y;
        field.repaint();
    }

    int getTeam() {
        return team;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}



