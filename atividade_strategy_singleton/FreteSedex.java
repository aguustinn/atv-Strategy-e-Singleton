public final class FreteSedex implements FreteStrategy {
    @Override public String getNome() { return "SEDEX"; }

    @Override
    public double calcular(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("O pedido não pode ser nulo.");
        ConfiguracaoLoja config = ConfiguracaoLoja.getInstance();
        return pedido.getPesoKg() * config.getTarifaSedexPorKg()
             + pedido.getDistanciaKm() * config.getTarifaSedexPorKm()
             + config.getTaxaUrgenciaSedex();
    }
}
