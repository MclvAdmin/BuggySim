/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buggysim.simobjects;

/**
 *
 * @author god
 */
public class DynamicalProperties {
    private COM cm;
    private MediaResistance mr;
    private CollisionModel colM;
    private ObjectGeometry g;
    public DynamicalProperties(COM cm,CollisionModel colM,MediaResistance mr,ObjectGeometry g){
        this.cm = cm;
        this.mr = mr;
        this.colM = colM;
        this.g = g;
    }
}
