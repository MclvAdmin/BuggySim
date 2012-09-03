/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim.simobjects;

/**
 *
 * @author god
 */
public class COM {
    private static final COM ZERO = new COM(0,0,0);
    private double x;
    private double y;
    private double z;
    private double X = 1;
    private double Y = 1;
    private double Z = 1;
    private boolean normalized;
    public COM(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public COM(double x, double y, double z, double X, double Y, double Z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        this.normalized = true;
    }
    public boolean getNormalized(){
        return normalized;
    }
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getz(){
        return z;
    }
    public double getX(){
        return X;
    }
    public double getY(){
        return Y;
    }
    public double getZ(){
        return Z;
    }
    public static COM getZero(){
        return (COM) ZERO.clone();
    }
    @Override
    public Object clone(){
        if(normalized){
            return new COM(getx(),gety(),getz(),getX(),getY(),getZ());
        }
        else{
            return new COM(getx(),gety(),getz());
        }
    }
}
