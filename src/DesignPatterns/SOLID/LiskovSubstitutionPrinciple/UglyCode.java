package DesignPatterns.SOLID.LiskovSubstitutionPrinciple;
class Bird{
    public void fly(){
        System.out.println("Flying");
    }
}

class Ostrich extends Bird{
    @Override
    public void fly(){
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}

class Eagle extends Bird{
    @Override
    public void fly(){
        System.out.println("Eagle is flying high");
    }
}

class BirdWatcher{
    public void watchBird(Bird bird){
        bird.fly();
    }
}

class LiskovSubstitutionPrincipleUglyCode{
    public static void main(String[] args) {
        BirdWatcher watcher = new BirdWatcher();
        Bird eagle = new Eagle();
        Bird ostrich = new Ostrich();

        watcher.watchBird(eagle); // Works fine
        watcher.watchBird(ostrich); // Throws exception
    }
}

