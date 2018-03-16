package javase02.innerclasses;

public class AtomicBoat {
    class AtomicBoatEngine{
        private boolean isRunning = false;
        private AtomicBoatEngine(){}

        void start(){
            this.isRunning = true;
        }
        void stop(){
            this.isRunning = false;
        }
    }

    private AtomicBoatEngine engine;

    public AtomicBoat(){
        engine = new AtomicBoatEngine();
    }

    public void run(){
        engine.start();
    }

    public static void main(String[] args) {
        AtomicBoat boat = new AtomicBoat();
        boat.run();
    }
}