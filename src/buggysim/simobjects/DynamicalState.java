/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim.simobjects;

import buggysim.math.DoubleVector;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author god
 */
public class DynamicalState {
    private ArrayList<Double> x = new ArrayList<>(0); //Indexed derivatives where the 0th derivative is the x position
    private ArrayList<Double> y = new ArrayList<>(0);
    private ArrayList<Double> z = new ArrayList<>(0);
    private ArrayList<ArrayList<Double>> data = new ArrayList<>(0);
    public boolean[] updates = {false,false,false};
    public DynamicalState(int degree){ //Zeroes the 
        data.add(x);
        data.add(y);
        data.add(z);
    }
    public DoubleVector getVector(int degree){
        double[] ret = new double[3];
        for(int i = 0; i < 3; i++){
            if(data.get(i).get(degree) == null){
                throw new NullPointerException();
            }
            ret[i] = data.get(i).get(degree); 
        }
        return new DoubleVector(ret);
    }
    public void updateX(double val, int deg){
        if(deg < x.size()){
            x.set(deg, val);
        }
        else if(deg == x.size()){
            x.add(val);
        }
        else if(deg > x.size()){
            for(int i = x.size() - 1; i < deg; i++){
                x.add(null);
            }
            x.add(val);
        }
    }
    private void update(int index, Double[] vals){
        ArrayList<Double> thisData = data.get(index);
        thisData.clear();
        thisData.addAll(Arrays.asList(vals));
        updates[index] = true;
    }
    public void updateX(Double[] x){
        update(0,x);
    }
    public void updateY(Double[] y){
        update(1,y);
    }
    public void updateZ(Double[] z){
        update(2,z);
    }
    public boolean newData(){
        return updates[0] || updates[1] || updates[2];
    }
    public boolean hasPosition(){
        return (data.get(0).size() > 0) && (data.get(1).size() > 0) && (data.get(2).size() > 0) && (data.get(0).get(0) != null) && (data.get(1).get(0) != null) && (data.get(2).get(0) != null);
    }
    private Double[] getSingle(int index){
        ArrayList<Double> thisData = data.get(index);
        Double[] ret = new Double[thisData.size()];
        thisData.toArray(ret);
        updates[index] = false;
        return ret;
    }
    public Double[] getX(){
        return getSingle(0);
    }
    public Double[] getY(){
        return getSingle(1);
    }
    public Double[] getZ(){
        return getSingle(2);
    }
    public Double[][] getState(){
        int minDegree = Math.min(Math.min(x.size(),y.size()),z.size());
        Double[][] ret = new Double[3][minDegree];
        for(int i = 0; i < minDegree; i++){
            ret[0][i] = x.get(i);
            ret[1][i] = y.get(i);
            ret[2][i] = z.get(i);
        }
        updates[0] = false;
        updates[1] = false;
        updates[2] = false;
        return ret;
    } //@TODO consecutive non-null state method
    /*public double[][] getConsecNonNullState(){ 
        int[] abc = new int[3];
        for(int i = 0; i < 3; i++){
            
        }
        double[][] ret = new double[abc.length][]
    }*/
}
