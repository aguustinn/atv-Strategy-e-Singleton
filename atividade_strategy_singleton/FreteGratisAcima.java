public final class FreteGratisAcima implements FreteStrategy {
    private final FreteStrategy estrategiaBase;

    public FreteGratisAcima(FreteStrategy estrategiaBase) {
        if (estrategiaBase == null) throw new IllegalArgumentException("A estratégia base é obrigatória.");
        this.estrategiaBase = estrategiaBase;
    }

    @Override public String getNome() { return estrategiaBase.getNome(); }

    @Override
    public double calcular(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("O pedido não pode ser nulo.");
        if (pedido.getValorItens() >= 300.00) return 0.0;
        return estrategiaBase.calcular(pedido);
    }
}
