package domain;

public class ValidacionCategoria implements Validacion {

    public boolean esValido(Prenda prenda) {
        // El tipo debe estar acorde a la categoria
        return prenda.getCategoria().getTiposPermitidos()
                .contains(prenda.getTipo());
    }
    @Override
    public void validar(Prenda prenda) {
        if(prenda.getCategoria() == null) {
            throw new FaltaAtributo("Falta ingresar la categoría!");
        } else if(!this.esValido(prenda)) {
            throw new NoCoincideTipoConCategoria("El tipo de prenda no pertenece a esta categoria");
        }
    }
}
