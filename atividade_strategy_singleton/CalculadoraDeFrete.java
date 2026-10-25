import java.util.Locale;

public final class CalculadoraDeFrete {
    private FreteStrategy estrategia;

    public CalculadoraDeFrete() {}
    public CalculadoraDeFrete(FreteStrategy estrategia) { this.estrategia = estrategia; }

    public void setEstrategia(FreteStrategy estrategia) {
        if (estrategia == null) throw new IllegalArgumentException("A estratégia não pode ser nula.");
        this.estrategia = estrategia;
    }

    public double calcular(Pedido pedido) {
        if (estrategia == null) throw new IllegalStateException("Nenhuma estratégia de frete foi definida.");
        if (pedido == null) throw new IllegalArgumentException("O pedido não pode ser nulo.");

        double valor = estrategia.calcular(pedido);
        if (!Double.isFinite(valor) || valor < 0) {
            throw new IllegalStateException("A estratégia retornou um valor de frete inválido.");
        }
        String registro = String.format(Locale.US, "pedido=%d estrategia=%s frete=%.2f",
                pedido.getId(), estrategia.getNome(), valor);
        AuditLog.getInstance().registrar(registro);
        return valor;
    }
}
