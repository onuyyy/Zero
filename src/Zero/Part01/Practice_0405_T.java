package Zero.Part01;

abstract  class GreenOrc {
    public final String SKIN_COLOR = "Green";
    public int health;
    public int attachDamage;
    public int defense;

    public abstract void setHealth();
    public abstract void setDamage();
    public abstract void setDefense();
}

interface  NPCSystem {
    public abstract void conversationSystem();
    public abstract void questionSystem();
}

interface UserSystem {
    public abstract void partySystem();
    public abstract void tradeSystem();
}

class OrcNPC1 extends GreenOrc implements NPCSystem{
    @Override
    public void setHealth() {
        this.health = 100;
    }

    @Override
    public void setDamage() {
        this.attachDamage = 10;
    }

    @Override
    public void setDefense() {
        this.defense = 5;
    }

    @Override
    public void conversationSystem() {
        System.out.println("안녕");
        System.out.println("요즘 새로운 소식 없나요?");
    }

    @Override
    public void questionSystem() {
        System.out.println("새로운 퀘스트");
        System.out.println("퀘스트 완료");
    }
}

class OrcUser1 extends GreenOrc implements UserSystem {
    @Override
    public void setHealth() {
        this.health = 200;
    }

    @Override
    public void setDamage() {
        this.attachDamage = 150;
    }

    @Override
    public void setDefense() {
        this.defense = 20;
    }

    @Override
    public void partySystem() {
        System.out.println("파티 초대");
        System.out.println("파티 수락");
    }

    @Override
    public void tradeSystem() {
        System.out.println("거래 신청");
        System.out.println("거래 완료");
    }
}

public class Practice_0405_T {
    public static void main(String[] args) {

    }
}
