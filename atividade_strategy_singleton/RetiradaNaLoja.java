public final class RetiradaNaLoja implements FreteStrategy {
    @Override public String getNome() { return "RETIRADA"; }

    @Override
    public double calcular(Pedido pedido) {
        if (pedido == null) throw new IllegalArgumentException("O pedido não pode ser nulo.");
        return 0.0;
    }
}
