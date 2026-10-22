public class TrapecioCompuesto {

    // Define aquí la función matemática que deseas evaluar (Ejemplo: f(x) = x^2)
    public static double funcion(double x) {
        return x * x;
    }

    // Calcula el tamaño del intervalo de paso h
    public static double calcularH(double a, double b, int n) {
        return (b - a) / n;
    }

    // Implementación del método del Trapecio para el análisis comparativo
    public static double integrarConTolerancia(double a, double b, double tolerancia) {
        int n = 2;
        double h = calcularH(a, b, n);
        double integralAnterior = (funcion(a) + funcion(b)) / 2.0;

        for (int k = 1; k < n; k++) {
            integralAnterior += funcion(a + k * h);
        }
        integralAnterior *= h;

        double errorAbsoluto = 999.0;

        while (errorAbsoluto > tolerancia) {
            n *= 2;
            h = calcularH(a, b, n);
            double sumaInterior = 0.0;
            for (int k = 1; k < n; k++) {
                sumaInterior += funcion(a + k * h);
            }
            double integralNueva = (h / 2.0) * (funcion(a) + 2 * sumaInterior + funcion(b));
            errorAbsoluto = Math.abs(integralNueva - integralAnterior);
            integralAnterior = integralNueva;
        }

        System.out.println("[Trapecio] Convergencia alcanzada con n = " + n + " subintervalos.");
        return integralAnterior;
    }
}
