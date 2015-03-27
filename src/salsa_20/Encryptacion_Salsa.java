/*
 * clase que contiene todas las funciones necesarias para la encryptacion de la salsa20
 * Creada el 26 de marzo de 2015
 */
package salsa_20;

import salsa_20.Conversion_Datos;

/**
 *
 * @author JLGC @monolinux
 * web junglacode.org
 */
public class Encryptacion_Salsa extends Conversion_Datos {

    Conversion_Datos __conversor__ = new Conversion_Datos();
    private String __FuncionY[] = null;

    public Encryptacion_Salsa(String contenido, Integer tipo) {/*tipo de conversion*/

        switch (tipo) {
            case 1:/*Binario*/

                __FuncionY = __conversor__.WordToBinary(contenido);
                break;
            case 2: /*Hexadecimal*/

                __FuncionY = __conversor__.WordtoHexadecimal(contenido);
                break;
            default:
                System.out.println("Esta texto no puede ser convertido ya que debe especificar un tipo");
        }//fin del switch
    } //constructor 

    public void getQuarterround() {
        System.out.println(__conversor__.sumaHexadecimal(__FuncionY[0],__FuncionY[1]));
        System.out.println(__conversor__.convertHexBin(__conversor__.sumaHexadecimal(__FuncionY[0],__FuncionY[1])));
    }//fin de la funcion
}//fin de la clase
