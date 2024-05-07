package dam.ed;

/**
 * Clase Calculadora
 */
 public class Calculadora {
    /**
     * Suma dos números A y B
     * @param a Sumando A
     * @param b Sumando B
     * @return Resultado de la suma
     */
    double suma(double a, double b) {
        return a + b;
    }

    /**
     * Resta dos números
     * @param minuendo Número del que restar
     * @param sustraendo Cantidad a restar
     * @return Resultado de la resta
     */
    double resta(double minuendo, double sustraendo) {
        return minuendo - sustraendo;
    }

     /**
      * Multiplica dos números y devuelve el resultado
      * @param a multiplicando 1
      * @param b multiplicando 2
      * @return resultado de la multiplicación
      */
    double multiplica(double a, double b) {
        return a * b;
    }

    /**
     *
     * @param dividendo Número que dividir
     * @param divisor   Número por el que dividir
     * @return  Resultado de la división
     * @throws OperacionInvalidaException Lanza excepción si el divisor es 0
     */
    double divide(double dividendo, double divisor) throws OperacionInvalidaException {
        if (divisor == 0) {
            throw new OperacionInvalidaException("El divisor es 0");
        }
        // Esto es un comentario
        return dividendo / divisor;
    }

    /**
     * Calcula la enésima potencia de un número
     * @param base Número a elevar
     * @param exponente Potencia a la que elevar
     * @return Resultado de elevar la base al exponente indicado
     */
    double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Excepción cuando se realiza una operación inválida
     */
    public class OperacionInvalidaException extends RuntimeException {
        public OperacionInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Calcula la raíz cuadrada de un número
     * @param radicando Número del que calcular la raíz
     * @return Resultado de la operación
     */
    double raiz(double radicando) {
        if (radicando < 0) {
            throw new OperacionInvalidaException("El radicando no puede ser negativo");
        }
        return Math.sqrt(radicando);
    }
}
