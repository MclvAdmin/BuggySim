/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim.simobjects;

/**
 *
 * @author god
 */
public class Medium {
    double k; //Density
    public Medium(double k){
        this.k = k;
    }
    public double getResistiveConstant(){
        return k;
    }
}
