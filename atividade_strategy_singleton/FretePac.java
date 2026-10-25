public final class FretePac implements FreteStrategy {
    @Override public String getNome() { return "PAC"; }

    @Override
    public double calcular(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("O pedido não pode ser nulo.");
        ConfiguracaoLoja config = ConfiguracaoLoja.getInstance();
        return pedido.getPesoKg() * config.getTarifaPacPorKg()
             + pedido.getDistanciaKm() * config.getTarifaPacPorKm();
    }
}
