package ru.mipt.dpqe;

/**
 * Created by Виталий on 17.04.2017.
 */
public class Soldier {
    private Integer x;
    private Integer y;
    public weapon gun;
    private Up7 field;
    private Integer team;
    public double skill = 1.0;
    public Integer hp; //private
    public final Integer fullHp = hp; //private
    public boolean Dead = false;


    public void isDead(){
        if (hp < 0) {
            Dead = true;
        }
    }

    public void Wound(int a, int b){//у солдата с индексом b отнимается a хп
        Up7.soldiers.get(b).hp = Up7.soldiers.get(b).hp - a;
    }

    public void RaiseSkill(int a){
        skill = skill + 1.0;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getTeam() {
        return team;
    }

    int getHp() {
        return hp;
    }

    double percentOfHp() {
        return (double)this.hp/this.fullHp;
    }

    public int findtarget(int a){ //ищет цель у солдата с индексом а в массиве
        int i, k; //k - расстояние от выбранного солдата до солдатов в массиве
        for (i = 0; i < Up7.soldiers.size(); i++) {
            k = (int)(Math.sqrt(Math.pow(Up7.soldiers.get(i).getX() - Up7.soldiers.get(a).getX(), 2) + Math.pow(Up7.soldiers.get(i).getY() - Up7.soldiers.get(a).getY(), 2)));
            if(k < Up7.soldiers.get(i).gun.distance){
                return i; //возвращает номер первого солдата попавшего в дистанцию стрельбы
            }
        }
        return -1; //ошибка если не нашлось цели
    }

    public void shoot(int a, int b){//стреляет из а в b
        double v;
        v = Math.atan(skill/2) * 2 / 3.141592654;
        if (Math.random() < v) {
            Up7.soldiers.get(b).Wound(Up7.soldiers.get(a).gun.damage, b);
        }
        RaiseSkill(a); //после выстрела у стрелка поднялся скил.
    }
}
