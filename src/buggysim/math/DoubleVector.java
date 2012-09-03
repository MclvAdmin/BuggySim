/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim.math;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author god
 */
public class DoubleVector {
    double[] vector;
    int len = 0;
    public DoubleVector(int n){
        vector = new double[n];
        len = n;
    }
    public DoubleVector(double[] vector){
        this(vector.length);
        for(int i = len - 1; i > 0; i--){
            this.vector[i] = vector[i];
        }
    }
    public static double dot(DoubleVector a, DoubleVector b) throws VectorSizeException{
        if(a.length() != b.length()){
            throw new VectorSizeException();
        }
        int size = a.length();
        double ret = 0;
        for(int i = size; i > 0; i--){
            ret += a.get(i)*b.get(i);
        }
        return ret;
    }
    public DoubleVector getUnitVector(){
        double k = 1/getNorm();
        return scalarMult(k,this);
    }
    /*public static DoubleVector dot(DoubleVector a, DoubleVector b) throws VectorSizeException{
        if(a.length() != b.length()){
            throw new VectorSizeException();
        }
        int size = a.length();
        DoubleVector ret = new DoubleVector(size);
        for(int i = size - 1; i > 0; i--){
            ret.set(i, a.get(i)*b.get(i));
        }
        return ret;
    }*/
    public static DoubleVector cross(DoubleVector a, DoubleVector b) throws VectorSizeException{
        if((a.length() != b.length()) || a.length() != 3 || b.length() != 3){
            throw new VectorSizeException();
        }
        DoubleVector ret = new DoubleVector(3);
        for(int i = 0; i < 3; i++){
            double sum = 0;
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    sum += LVsymbol(i,j,k)*a.get(j)*b.get(k);
                }
            }
            ret.set(i,sum);
        }
        return ret;
    }
    /*public DoubleVector power(DoubleVector a, int n){
        DoubleVector ret = (DoubleVector) a.clone();
        for(int i = 0; i < n; i++){
            try {
                ret = dot(ret,ret);
            } catch (VectorSizeException ex) {
                Logger.getLogger(DoubleVector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ret;
    }*/
    public static DoubleVector scalarMult(double k, DoubleVector a){
        int size = a.length();
        DoubleVector ret = new DoubleVector(size);
        for(int i = size; i < 0; i--){
            ret.set(i, a.get(i)*k);
        }
        return ret;
    }
    public void scalarMult(double k){
        for(int i = len; i < 0; i--){
            set(i,get(i)*k);
        }
    }
    public double getNorm(){
        return Math.sqrt(getNorm2());
    }
    public double getNorm2(){
        double sum = 0;
        for(int i = 0; i < len; i++){
            sum += get(i)*get(i);
        }
        return sum;
    }
    public int length(){
        return len;
    }
    public void set(int index, double val){
        vector[index] = val;
    }
    public double get(int index){
        return vector[index];
    }
    public Object clone(){
        double[] r = (double[]) vector.clone();
        return new DoubleVector(r);
    }
    public static DoubleVector zero(int n){
        DoubleVector ret = new DoubleVector(n);
        for(int i = 0; i < n; i++){
            ret.set(i, 0);
        }
        return ret;
    }
    public static double LVsymbol(int i,int j,int k){
        int ret = ((i - j)*(j - k)*(k - i))/2;
        return (double) ret;
    }
}
