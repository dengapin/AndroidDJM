/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajes;

/**
 *
 * @author jonathan
 */
public class Bomba {
    private int x,y;
    private int id=9;
    
    public Bomba(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    public int getId(){
        return this.id;
    }
}
