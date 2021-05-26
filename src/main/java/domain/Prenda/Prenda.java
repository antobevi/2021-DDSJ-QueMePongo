package domain.Prenda;

import java.util.Objects;

public class Prenda {
    private TipoDePrenda tipo;
    private Material material; // Contiene la tela y la trama
    private Color colorPrincipal;
    private Color colorSecundario; // Es opcional
    private Temperatura temperaturaAdecuada;

    public Temperatura getTemperaturaAdecuada() {
        return temperaturaAdecuada;
    }

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

    public Prenda(TipoDePrenda tipo, Material material, Color colorPrincipal, Color colorSecundario, Temperatura temperaturaAdecuada) {
        this.tipo = Objects.requireNonNull(tipo, "Falta ingresar el tipo de prenda!");
        this.material = Objects.requireNonNull(material, "Falta ingresar el material!");
        this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "Falta ingresar el color principal!");
        this.colorSecundario = colorSecundario;
        this.temperaturaAdecuada =
            Objects.requireNonNull(temperaturaAdecuada, "Falta ingresar la temperatura adecuada para usar la prenda!");
    }

}
