/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package salsa_20;
import salsa_20.Encryptacion_Salsa;
/**
 *
 * @author junglacode
 */
public class Main extends Conversion_Datos{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Encryptacion_Salsa encryptar = new Encryptacion_Salsa("carlos jarlos",2);
       encryptar.getQuarterround();
    }
    
}
