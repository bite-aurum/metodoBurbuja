import java.util.Arrays; // Importamos esta herramienta para imprimir el arreglo y no usar un ciclo for.

public class burbuja {

    // METODO BURBUJA CLASICO
    public static void ordenamientoBurbuja(int[] arreglo) {
        // Este primer for controla cuantas pasadas vamos a dar por el arreglo.
        for (int i = 0; i < arreglo.length - 1; i++) {

            // Este segundo for compara los numeros que estan pegados (vecinos).
            // Le restamos 'i' porque al final de cada pasada, el numero mas grande
            // ya se fue hasta el final, asi que no necesitamos volver a checarlo.
            for (int j = 0; j < arreglo.length - 1 - i; j++) {

                // Si el numero de la izquierda es mas grande que el de la derecha...
                if (arreglo[j] > arreglo[j + 1]) {
                    // los intercambiamos de lugar usando una variable temporal (temp)
                    // para no perder el valor en el proceso.
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    // METODO BURBUJA MEJORADO
    public static void ordenamientoBurbujaMejorado(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {

            // Creamos una "bandera" para saber si en esta pasada se movio algun numero.
            boolean huboIntercambio = false;

            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Hacemos el mismo intercambio de antes
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;

                    // Como si se movieron, levantamos la bandera
                    huboIntercambio = true;
                }
            }

            // Al terminar la pasada, checamos la bandera.
            // Si sigue en false, significa que el arreglo ya estaba ordenado
            // y nos salimos del ciclo con 'break' para no perder el tiempo dando vueltas innecesarias.
            if (!huboIntercambio) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 1. Probamos el burbuja normal
        int[] nums1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original:  " + Arrays.toString(nums1)); // Imprimimos como viene

        ordenamientoBurbuja(nums1); // Lo mandamos a ordenar
        System.out.println("Burbuja:   " + Arrays.toString(nums1)); // Imprimimos como quedo

        // 2. Probamos el burbuja mejorado
        int[] nums2 = {64, 34, 25, 12, 22, 11, 90}; // Otro arreglo igual para comparar

        ordenamientoBurbujaMejorado(nums2); // Lo mandamos a ordenar con el metodo listo
        System.out.println("Mejorado:  " + Arrays.toString(nums2)); // Imprimimos el resultado
    }
}