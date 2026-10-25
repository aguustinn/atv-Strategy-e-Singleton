import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Pedido pedido = new Pedido(1, 2.0, 100.0, 200.0);
        CalculadoraDeFrete calculadora = new CalculadoraDeFrete();

        calculadora.setEstrategia(new FretePac());
        imprimir(calculadora, pedido);

        calculadora.setEstrategia(new FreteSedex());
        imprimir(calculadora, pedido);

        calculadora.setEstrategia(new RetiradaNaLoja());
        imprimir(calculadora, pedido);

        ConfiguracaoLoja config = ConfiguracaoLoja.getInstance();
        config.setTarifaPacPorKg(5.00);
        calculadora.setEstrategia(new FretePac());
        imprimir(calculadora, pedido);

        config.restaurarPadroes();

        System.out.println("Singleton ConfiguracaoLoja (mesma instância): "
                + (ConfiguracaoLoja.getInstance() == ConfiguracaoLoja.getInstance()));

        System.out.println("Histórico de auditoria:");
        for (String registro : AuditLog.getInstance().getRegistros()) {
            System.out.println(registro);
        }
    }

    private static void imprimir(CalculadoraDeFrete calculadora, Pedido pedido) {
        System.out.printf("Frete %s: R$ %.2f%n",
                "calculado", calculadora.calcular(pedido));
    }
}
