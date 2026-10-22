public class Main {
    public static void main(String[] args) {
        double limiteInferior = 0.0; // a
        double limiteSuperior = 2.0; // b
        double tolerancia = 1e-6;    // 0.000001

        System.out.println("--- INICIANDO ANÁLISIS COMPARATIVO ---");
        System.out.println("Evaluando integral en el intervalo [" + limiteInferior + ", " + limiteSuperior + "]\n");

        // Ejecución Trapecio
        double resultadoTrapecio = TrapecioCompuesto.integrarConTolerancia(limiteInferior, limiteSuperior, tolerancia);
        System.out.println("Resultado Trapecio Compuesto: " + resultadoTrapecio + "\n");

        // Ejecución Simpson
        double resultadoSimpson = SimpsonCompuesto.integrarConTolerancia(limiteInferior, limiteSuperior, tolerancia);
        System.out.println("Resultado Simpson 1/3 Compuesto: " + resultadoSimpson + "\n");
    }
}
