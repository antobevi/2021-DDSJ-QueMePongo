package domain;

import domain.constants.Color;
import domain.constants.Material;

import java.util.Objects;

public class Prenda {
    private TipoDePrenda tipo;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Material material;

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Material getMaterial() {
        return material;
    }

    public TipoDePrenda getTipo() {
        return tipo;
    }

    public Prenda(TipoDePrenda tipo, Color colorPrincipal, Color colorSecundario,
                  Material material) {
        // Realizo las validaciones aca por Fail Fast (no constuye prendas invalidas).
        this.tipo = Objects.requireNonNull(tipo, "Falta ingresar el tipo de prenda!");
        this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "Falta ingresar el color principal!");
        // TODO: ¿Deberia haber otro constructor sin el color secundario?
        this.colorSecundario = colorSecundario; // Es opcional y puede setearse despues.
        this.material = Objects.requireNonNull(material, "Falta ingresar el material de la prenda!");
    }
}
