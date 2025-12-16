package textos;

public class Utils {

    /**
     * Cuenta cuantas veces aparecen las palabras en el texto, listado de palabras que forman el texto y cuantas veces aparecen cada una de ellas
     * 
     * @param texto    Texto en el que buscar las palabras
     * @param palabras Palabras a buscar
     * @return Número de apariciones de las palabras
     */
    public static int resumenTexto(String texto) {

        String[] palabras = textoAArray(texto);
        int[] contador = new int[palabras.length];
        for (int i = 0; i < palabras.length; i++) {
            for (int j = 0; j < palabras.length; j++) {
                if (palabras[i].equals(palabras[j])) {
                    contador[i]++;
                    
                }
            }            
            System.out.printf("%s (%d)\n", palabras[i], contador[i]);
        }

        return 0;
    }

    /**
     * Devolver el texto con las palabras desordenadas
     * 
     * @param texto Texto sin desordenar
     * @return Texto con las palabras desordenadas
     */
    public static String desordenaPalabras(String texto) {
        String[] palabras = textoAArray(texto);
        String[] desordenadas = new String[palabras.length];
        for (int i = (int) Math.random() * palabras.length; i < palabras.length; i++) {
            desordenadas[i] = palabras[i];
        }
        return arrayATexto(desordenadas);
    }

    /**
     * Devolver el texto con las palabras invertidas
     * 
     * @param texto Texto sin invertir
     * @return Texto con las palabras invertidas
     */

    public static String invertirPalabras(String texto) {
        String[] palabras = textoAArray(texto);
        String[] invertidas = invertirArray(palabras);
        for (int i = 0; i < palabras.length; i++) {
            invertidas[i] = palabras[palabras.length - i - 1];
        }
        return arrayATexto(invertidas);
    }

    /**
     * recibir un array y devolverlo al reves
     * 
     * @param palabras Array de Strings con las palabras
     * @return Array de Strings con las palabras invertidas
     */
    public static String[] invertirArray(String[] palabras) {
        String[] invertidas = new String[palabras.length];
        for (int i = 0; i < palabras.length; i++) {
            invertidas[i] = palabras[palabras.length - i - 1];
        }
        return invertidas;
    }

    /**
     * Devolver un texto con las palabras separadas solo por un espacio entre ellas
     * 
     * @param texto Texto con las palabras separadas
     * @return Texto con las palabras separadas por espacios
     */
    public static String reduceEspacios(String texto) {
        String[] palabras = textoAArray(texto);
        return arrayATexto(palabras);
    }

    /**
     * Obtener una palabra del texto
     * 
     * @param texto    Texto del que extraer la palabra
     * @param posicion Posición de la palabra en el texto
     * @return Palabra extraída
     */
    public static String obtenerPalabra(String texto, int posicion) {
        String[] palabras = textoAArray(texto);
        return palabras[posicion];
    }

    /**
     * Cuenta las palabras del texto
     * 
     * @param texto Texto a contar
     * @return Número de palabras
     */
    public static int cuentaPalabras(String texto) {
        String[] palabras = textoAArray(texto);
        return palabras.length;
    }

    /**
     * Recibir un array y convertirlo en un texto con las palabras separadas por
     * espacios
     * 
     * @param palabras Array de Strings con las palabras
     * @return Texto con las palabras separadas por espacios
     */
    public static String arrayATexto(String[] palabras) {
        String texto = "";
        for (int i = 0; i < palabras.length; i++) {
            texto += palabras[i] + " ";
        }
        return texto;
    }

    /**
     * Separa las palabras del texto en un array de Strings, de forma que cada
     * String contenga una palabra del texto
     * Se debe considerar que el texto puede contener espacios en blanco
     * 
     * @param texto Texto a separar
     * @return Array de Strings con las palabras
     */
    public static String[] textoAArray(String texto) {

        int contador = cuentaDiferencia(texto);

        String[] palabras = new String[contador];

        int indice = 0;
        String palabra = "";

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c != ' ' && c != ',' && c != '.') {
                palabra += c;
            } else {
                if (!palabra.equals("")) {
                    palabras[indice] = palabra;
                    indice++;
                    palabra = "";
                }
            }
        }

        if (!palabra.equals("")) {
            palabras[indice] = palabra;
        }

        return palabras;
    }

    /**
     * Contar los caracteres que tienen diferentes a las palabras
     * 
     * @param texto Texto a contar
     * @return Número de caracteres diferentes a las palabras
     */
    public static int cuentaDiferencia(String texto) {
        int contador = 0;
        boolean dentroPalabra = false;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (c != ' ' && c != ',' && c != '.') {
                if (!dentroPalabra) {
                    contador++;
                    dentroPalabra = true;
                }
            } else {
                dentroPalabra = false;
            }
        }
        return contador;
    }

}
