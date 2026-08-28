public class PedidoEncomienda extends Pedido {
    private int tiempoEstimadoEntrega;
    private String tipoEntrega;
    private boolean urgenciaEntrega;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm, int tiempoEstimadoEntrega, String tipoEntrega, boolean urgenciaEntrega) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
        this.tipoEntrega = tipoEntrega;
        this.urgenciaEntrega = urgenciaEntrega;
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

    public boolean isUrgenciaEntrega() {
        return urgenciaEntrega;
    }

    public void setUrgenciaEntrega(boolean urgenciaEntrega) {
        this.urgenciaEntrega = urgenciaEntrega;
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Repartidor en Camioneta");
        System.out.println("Repartidor asignado automáticamente: " + getRepartidorAsignado());
    }

    @Override
    public void calcularTiempoEntrega() {
        int tiempo = 20 +(int) (1.5 * getDistanciaKm());
        // factores que afentan su duración --- urgencia en la entrega ? -30% : 0
        int rebajaEntregaUrgente = (int) (tiempo * 0.3);
        int duracionTotal = urgenciaEntrega ? (tiempo - rebajaEntregaUrgente) : tiempo;
        System.out.println("La entrega se realizará en: " + duracionTotal + " minutos");
    }

}