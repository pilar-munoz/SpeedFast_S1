public class PedidoComida extends Pedido {
    private int tiempoEstimadoEntrega;
    private String tipoEntrega;
    private int cantidadProductos;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm, int tiempoEstimadoEntrega, String tipoEntrega, int cantidadProductos) {
        super(idPedido, direccionEntrega, distanciaKm);
        this.tiempoEstimadoEntrega = tiempoEstimadoEntrega;
        this.tipoEntrega = tipoEntrega;
        this.cantidadProductos = cantidadProductos;
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

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    @Override
    public void asignarRepartidor() {
        setRepartidorAsignado("Repartidor en Moto");
        System.out.println("Repartidor asignado automáticamente: " + getRepartidorAsignado());
    }

    @Override
    public void calcularTiempoEntrega() {
        int tiempo = (int) (15 + 2 * getDistanciaKm());
        // factores que afentan su duración --- cantidad de productos > 4 == + 5 minutos
        int duracionAdicional = getCantidadProductos() > 4 ? 5 : 0;
        int duracionTotal = tiempo + duracionAdicional;
        System.out.println("La entrega se realizará en: " + duracionTotal + " minutos");
    }
}