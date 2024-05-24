package Aplicacao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void calculaMedia() {
        Main m = new Main();
        double resultadoMedia = m.calculaMedia(7, 7, 7);
        assertEquals(7.0, resultadoMedia);
    }

    @Test
    void recalculaMedia() {
        Main m = new Main();
        double resultadoMedia = m.recalculaMedia(0, 8, 7, 7, 5);
        assertEquals(7.0, resultadoMedia, 0.5);
    }

    @Test
    void testaIntervaloNota() {
        Main m = new Main();
        boolean resultadoIntervalo = m.testaIntervaloNota(0, 10, 8);
        assertEquals(false, resultadoIntervalo);
    }
}