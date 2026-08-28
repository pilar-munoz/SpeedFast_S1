public class PedidoExpress extends Pedido {
    private int tiempoEstimadoEntrega;
    private String tipoEntrega;
    private boolean entregaPrioritaria;

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm, int tiempoEstimadoEntrega, String tipoEntrega, boolean entregaPrioritaria) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
        this.tipoEntrega = tipoEntrega;
        this.entregaPrioritaria = entregaPrioritaria;
    }

    public int getTiempoEstimadoEntrega() {
        return tiempoEstimadoEntrega;
    }

    public void setTiempoEstimadoEntrega(int tiempoEstimadoEntrega) {
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public boolean isEntregaPrioritaria() {
        return entregaPrioritaria;
    }

    public void setEntregaPrioritaria(boolean entregaPrioritaria) {
        this.entregaPrioritaria = entregaPrioritaria;
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Repartidor Motorizado Express");
        System.out.println("Repartidor asignado automáticamente: " + getRepartidorAsignado());
    }

    @Override
    public void calcularTiempoEntrega() {
        int tiempoExtra = getDistanciaKm() > 5 ? 5 : 0;
        int tiempo = tiempoExtra + 10;
        // factores que afentan su duración --- entrega prioritaria ? -20% : 0
        int rebajaEntregaPrioritaria = (int) (tiempo * 0.2);
        int duracionTotal = entregaPrioritaria ? (tiempo - rebajaEntregaPrioritaria): tiempo;
        System.out.println("La entrega se realizará en: " + duracionTotal + " minutos");
    }

}