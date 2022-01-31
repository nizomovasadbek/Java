package oqimlar;
public class Oqimlar implements Runnable {
    private int uhlashDavvomiyligi;
    
    public Oqimlar(int uhlashDavomiyligi){
        this.uhlashDavvomiyligi = uhlashDavomiyligi;
    }
    
    @Override
    public void run(){
        String oqimNomi = Thread.currentThread().getName();
        for(int sanoq = 1; sanoq <= 5; sanoq++){
            System.out.format("%sdan %d-habar\n", oqimNomi, sanoq);
        try {
            Thread.sleep(uhlashDavvomiyligi);
        } catch (InterruptedException e) {
            System.out.println("Bizga halal berishdi.");
            System.exit(1);
        }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread oqim1 = new Thread(new Oqimlar(20), "1-oqim");
        Thread oqim2 = new Thread(new Oqimlar(10), "2-oqim");
        oqim1.start();
        oqim1.join();
        oqim2.start();
    }
}