public final class ConfiguracaoLoja {
    private static final double PAC_KG_PADRAO = 2.50;
    private static final double PAC_KM_PADRAO = 0.05;
    private static final double SEDEX_KG_PADRAO = 4.00;
    private static final double SEDEX_KM_PADRAO = 0.12;
    private static final double URGENCIA_PADRAO = 15.00;

    private double tarifaPacPorKg = PAC_KG_PADRAO;
    private double tarifaPacPorKm = PAC_KM_PADRAO;
    private double tarifaSedexPorKg = SEDEX_KG_PADRAO;
    private double tarifaSedexPorKm = SEDEX_KM_PADRAO;
    private double taxaUrgenciaSedex = URGENCIA_PADRAO;

    private ConfiguracaoLoja() {}

    private static class Holder {
        private static final ConfiguracaoLoja INSTANCE = new ConfiguracaoLoja();
    }

    public static ConfiguracaoLoja getInstance() { return Holder.INSTANCE; }

    public synchronized double getTarifaPacPorKg() { return tarifaPacPorKg; }
    public synchronized void setTarifaPacPorKg(double valor) { validarTarifa(valor); tarifaPacPorKg = valor; }
    public synchronized double getTarifaPacPorKm() { return tarifaPacPorKm; }
    public synchronized void setTarifaPacPorKm(double valor) { validarTarifa(valor); tarifaPacPorKm = valor; }
    public synchronized double getTarifaSedexPorKg() { return tarifaSedexPorKg; }
    public synchronized void setTarifaSedexPorKg(double valor) { validarTarifa(valor); tarifaSedexPorKg = valor; }
    public synchronized double getTarifaSedexPorKm() { return tarifaSedexPorKm; }
    public synchronized void setTarifaSedexPorKm(double valor) { validarTarifa(valor); tarifaSedexPorKm = valor; }
    public synchronized double getTaxaUrgenciaSedex() { return taxaUrgenciaSedex; }
    public synchronized void setTaxaUrgenciaSedex(double valor) { validarTarifa(valor); taxaUrgenciaSedex = valor; }

    public synchronized void restaurarPadroes() {
        tarifaPacPorKg = PAC_KG_PADRAO;
        tarifaPacPorKm = PAC_KM_PADRAO;
        tarifaSedexPorKg = SEDEX_KG_PADRAO;
        tarifaSedexPorKm = SEDEX_KM_PADRAO;
        taxaUrgenciaSedex = URGENCIA_PADRAO;
    }

    private static void validarTarifa(double valor) {
        if (!Double.isFinite(valor) || valor < 0) {
            throw new IllegalArgumentException("A tarifa deve ser um número finito não negativo.");
        }
    }
}
