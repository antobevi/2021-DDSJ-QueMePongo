package domain;

import domain.constants.Categoria;
import domain.constants.Color;
import domain.constants.TipoDePrenda;

public class Prenda {
    private Categoria categoria;
    private String nombre;
    private Color colorPrincipal;
    private Color colorSecundario;
    private String material;
    private TipoDePrenda tipo;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(Color colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public TipoDePrenda getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePrenda tipo) {
        this.tipo = tipo;
    }

    public Prenda(Categoria categoria, String nombre, Color colorPrincipal, Color colorSecundario,
                  String material, TipoDePrenda tipo) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.tipo = tipo;
    }
}
