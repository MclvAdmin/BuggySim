/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim.simobjects;

import buggysim.math.DoubleVector;

/**
 *
 * @author god
 */
public class MediaResistance {
    private static Medium vacuum;
    public MediaResistance(){
        
    }
    private DoubleVector getGForce(){
        return 
    }
    private DoubleVector getV1Force(ObjectGeometry g, Medium m, DynamicalState s){
       double k = m.getResistiveConstant();
       double area = g.getCrossSection();
       DoubleVector v = s.getVector(1);
       v.scalarMult(-1);
       v = v.getUnitVector();
       v.scalarMult(k*area*1/2);
       return v;
    }
}
