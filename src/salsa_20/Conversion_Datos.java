/*
 * clase que tiene las operaciones basicas para las conversiones de datos
 * Creada el 26 de marzo de 2015
 */
package salsa_20;

/**
 *
 * @author JLGC @monolinux
 * web junglacode.org
 */
public class Conversion_Datos {

    public String[] WordToBinary(String cadena) {
        String __words__[] = cadena.split(" ");//separacion por palabras
        String __arrayBinario__[] = new String[__words__.length];
        for (int x = 0; x < __words__.length; x++) {
            String __word__ = "";
            char[] __caracteres__ = __words__[x].toCharArray();
            for (int y = 0; y < __caracteres__.length; y++) {
                __word__ += Integer.toBinaryString(__caracteres__[y]);
            }
            __arrayBinario__[x] = __word__;
        }

        return __arrayBinario__;
    }//funcion que convierte el arreglo en binario

    public String[] WordtoHexadecimal(String cadena) {
        String __words__[] = cadena.split(" ");//separacion por palabras
        String __arrayHexadecimal__[] = new String[__words__.length];
        for (int x = 0; x < __words__.length; x++) {
            String __word__ = "";
            char[] __caracteres__ = __words__[x].toCharArray();
            for (int y = 0; y < __caracteres__.length; y++) {
                __word__ += Integer.toHexString(__caracteres__[y]);
            }
            // System.out.println(__word__);
            __arrayHexadecimal__[x] = __word__;
        }

        return __arrayHexadecimal__;
    }

    public void sumaHexadecimal(String dato_uno, String dato_dos /*hexadecimal*/) {
        Integer __size__ = 0, __recorrido__ = 0, __multiplicacion__ = 0, __valor__ = 0, __total__ = 0;
        String __sumatorio__ = "", __resultado__ = "";//el valor sumado del hexadecimal
        String array_uno[] = convertLettertoHex(dato_uno);//convirtiendo los datos en hexadecimal
        String array_dos[] = convertLettertoHex(dato_dos);//conviertiendo los datos en hexadecimal
        if (array_uno.length >= array_dos.length) {
            __size__ = dato_uno.length(); /*por que los arreglos empiezan de 0*/

        } else/*vamos a poner el tamaño mas grande del arreglo para evitar desbordamientos*/ {
            __size__ = dato_dos.length(); /*por que los arreglos empiezan de 0*/

        }
        for (int i = __size__ - 1; i >= 0; i--) {
            //System.out.println(array_uno[i] +"--"+array_dos[i]);
            __valor__ = (__recorrido__ + Integer.parseInt(array_uno[i]) + Integer.parseInt(array_dos[i]));//16 por que es hexadecimal
            // System.out.print("suma" + __valor__);
            __recorrido__ = (__valor__ / 16);
            //System.out.print("recorrido" + __recorrido__);
            __multiplicacion__ = __recorrido__ * 16;
            __total__ = (__valor__ - __multiplicacion__);
            //System.out.print("total" + findHextoDec(__total__) + "\n");
            __sumatorio__ += findHextoDec(__total__);
        }
        __sumatorio__ += findHextoDec(__recorrido__);//esto es si queda algun valor por recorrer
        //invirtiendo el resultado para que salga bien el resultado
        System.out.println(__sumatorio__);
        for (int i = __sumatorio__.length()-1; i >= 0; i--) {
            __resultado__ += __sumatorio__.charAt(i);
        }
        System.out.println(__resultado__);
    }

    protected String[] convertLettertoHex(String hexadecimal) {
        String __word__[] = new String[hexadecimal.length()];//palabra formateada
        for (int i = 0; i < hexadecimal.length(); i++) {
            __word__[i] = findHextoDec(hexadecimal.toUpperCase().charAt(i));//se fuerza ha ser mayusculas
        }//fin del primer ciclo
        return __word__;
    }//fin del funcion que trasforma el caracter a hexadecimal

    protected String findHextoDec(char character) {
        char __hexadecimal__[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        String __decimal__[] = {"10", "11", "12", "13", "14", "15"};
        String __valor__ = "";
        for (int i = 0; i < __hexadecimal__.length; i++) {
            if (character == __hexadecimal__[i]) {
                __valor__ = __decimal__[i];
                break;
            } else {
                __valor__ = "" + character;
            }
        }//fin del for
        return __valor__;
    }

    protected String findHextoDec(Integer numero) {
        char __hexadecimal__[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        Integer __decimal__[] = {10, 11, 12, 13, 14, 15};
        String __valor__ = "";
        for (int i = 0; i < __decimal__.length; i++) {
            if (numero == __decimal__[i]) {
                __valor__ = "" + __hexadecimal__[i];
                break;
            } else {
                __valor__ = "" + numero;
            }
        }//fin del for
        return __valor__;
    }
}//fin de la clase
