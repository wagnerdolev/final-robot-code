package frc.robot.Utils;

public class MathUtils {
    
    public static double trueModulu(double a, double b){
        return ((a % b + b) % b);
    }
}