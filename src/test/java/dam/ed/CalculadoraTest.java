package dam.ed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
        assertEquals(16, miCalculadora.multiplica(4,4));
        assertEquals(-5, miCalculadora.multiplica(-5,1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(Calculadora.OperacionInvalidaException.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("Tests de sumas")
    void testsSuma() {
        assertEquals(4, miCalculadora.suma(1,3));
        assertEquals(-2, miCalculadora.suma(1,-3));
        assertEquals(2, miCalculadora.suma(-1,3));
        assertEquals(-4, miCalculadora.suma(-1,-3));
    }

    @Test
    @DisplayName("Tests de potencias")
    void testsPotencias() {
        assertEquals(8, miCalculadora.potencia(2,3));
        assertEquals(1, miCalculadora.potencia(5,0));
        assertEquals(0.01, miCalculadora.potencia(10,-2));
        assertEquals(20, miCalculadora.potencia(20,1));
    }

    @Test
    @DisplayName("Tests de restas")
    void testsResta() {
        assertEquals(-2, miCalculadora.resta(1,3));
        assertEquals(4, miCalculadora.resta(1,-3));
        assertEquals(-4, miCalculadora.resta(-1,3));
        assertEquals(2, miCalculadora.resta(-1,-3));
    }

    @Test
    @DisplayName("La raíz de 1 devuelve 1")
    void raizDeUno_devuelveUno() {
        assertEquals(1,miCalculadora.raiz(1));
    }

    @Test
    @DisplayName("La raíz de 0 devuelve 0")
    void raizDeCero_devuelveCero() {
        assertEquals(0,miCalculadora.raiz(0));
    }

    @Test
    @DisplayName("La raíz de 4 devuelve 2")
    void raizDeCuatro_devuelveDos() {
        assertEquals(2,miCalculadora.raiz(4));
    }

    @Test
    @DisplayName("La raíz de un número negativo lanza una excepción OperacionInvalidaException")
    void raizDeMenosUno_devuelveExcepcionOperacionInvalida() {
        Exception exception = assertThrows(Calculadora.OperacionInvalidaException.class, () -> {
            miCalculadora.raiz(-1);
        });
        assertEquals("El radicando no puede ser negativo", exception.getMessage());
    }
}