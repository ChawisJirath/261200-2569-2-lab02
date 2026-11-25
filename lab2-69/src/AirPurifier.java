public class AirPurifier{
    private final String model;
    private final double roomVolume;
    private boolean on;
    private int fanSpeed;
    private double pm2_5;
    public enum Mode{MANUAL,AUTO,SLEEP}
    private Mode mode;
    public static final int MAX_FAN_SPEED=3;
    private static int totalPurifiers=0;
    public AirPurifier(String model,double roomVolume,double initialPm2_5){
        this.model=model;
        this.roomVolume=roomVolume;
        pm2_5=initialPm2_5;
        this.fanSpeed=0;
        this.on=false;
        this.mode=Mode.MANUAL;
        totalPurifiers++;
    }
    public void turnOn(){
        if(this.on) {
            return;
        }else{
            this.on=true;
            this.fanSpeed=1;
            applyAutoSpeed();
        }
    }
    public void turnOff(){
        if(!this.on) {
            return;
        }else{
            this.on=false;
            this.fanSpeed=0;
        }
    }
    public void setFanSpeed(int speed){
        if(speed<1 || speed>MAX_FAN_SPEED){
            System.out.println("speed must be between 1 and 3");
            return;
        }
        if(!this.on){
            System.out.println("Turn on before select speed");
            return;
        }
        this.fanSpeed=speed;
        this.mode=Mode.MANUAL;
    }
    public void setMode(Mode newMode){
        this.mode=newMode;
        if(newMode==Mode.SLEEP && this.on){
            this.fanSpeed=1;
        }else if(newMode==Mode.AUTO){
            applyAutoSpeed();
        }else{
            return;
        }
    }
    public void applyAutoSpeed(){
        if(!this.on || this.mode!=Mode.AUTO){
            return;
        }
        if(this.pm2_5<=12){
            this.fanSpeed=1;
        }else if(this.pm2_5<=35.4){
            this.fanSpeed=2;
        }else{
            this.fanSpeed=3;
        }
    }
    public void updateAirQuality(double newPm2_5){
        if(newPm2_5<0){
            System.out.println("newPm2_5 cannot be negative value.");
            return;
        }
        this.pm2_5=newPm2_5;
        if(this.on && this.mode==Mode.AUTO) {
            applyAutoSpeed();
        }
    }
    public static String airQualityCategory(double pm25){
        if(pm25<=12)return "Good";
        else if(pm25<=35.4)return "Moderate";
        else if(pm25<=55.4)return "Unhealthy for Sensitive Groups";
        else if(pm25<=150.4)return "Unhealthy";
        else if(pm25<=250.4)return "Very Unhealthy";
        else return "Hazardous";
    }
    public Mode getMode(){return this.mode;}
    public boolean isOn(){return this.on;}
    public int getFanSpeed(){return this.fanSpeed;}
    public double getPm25(){
        if(!this.on) return 0;
        return this.pm2_5;
    }
    public String getModel(){return this.model;}
    public double getRoomVolume(){return this.roomVolume;}
    public static int getTotalPurifiers(){return totalPurifiers;}


}