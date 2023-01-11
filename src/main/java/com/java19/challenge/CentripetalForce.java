package com.java19.challenge;

public class CentripetalForce {

    /**
     *
     * @param radius
     * @param period
     * @return
     */
    private static double calcPathVelocity(double radius, double period ){
        return (2 * Math.PI * radius)/period;
    }

    /**
     *
     * @param pathVel
     * @param radius
     * @return
     */
    private static double calcCentripetalAcceleration(double pathVel,double radius){
        return (pathVel * pathVel)/radius;
    }

    public static double centripetalForce(double mass, double acc){
        return mass * acc;
    }

    public static void main(String[] args) {
        double velocity = calcPathVelocity(10,10);
        double acc = calcCentripetalAcceleration(velocity,10);
        double result = centripetalForce(0.2,acc);
        System.out.println(result);
    }
}
