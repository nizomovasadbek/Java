package vaqt;
public class VaqtOrnatish {
    private int soat;
    private int daqiqa;
    private int soniya;
    
    public void vaqtOrnat(int soatArg, int daqiqaArg, int soniyaArg){
        soat = (soatArg<0 || soatArg>24)?0:soatArg;
        daqiqa = (daqiqaArg>0 || daqiqaArg<60)?daqiqaArg:0;
        soniya = (soniyaArg<0 || soniyaArg>60)?0:soniyaArg;
    }
    
    public String vaqtKorsat24(){
        return String.format("%02d:%02d:%02d", soat, daqiqa, soniya);
    }
    
    public String vaqtKorsat12(){
        return String.format("%02d:%02d:%02d %s", (soat>11)?soat%12:soat, daqiqa, soniya, (soat>11)?" p.m":" a.m");
    }
}