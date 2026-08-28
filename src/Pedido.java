public abstract class Pedido implements Despachable, Cancelable {
    private String idPedido;
    private String direccionEntrega;
    private double distanciaKm;
    private String repartidorAsignado;
    private boolean despachado;
    private boolean cancelado;

    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
        this.repartidorAsignado = "Sin asignar";
        this.despachado = false;
        this.cancelado = false;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }

    public void setRepartidorAsignado(String repartidorAsignado) {
        this.repartidorAsignado = repartidorAsignado;
    }

    public boolean isDespachado() {
        return despachado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void mostrarResumen() {
        System.out.println("ID: " + idPedido + "\n"
                + "Direccion: " + direccionEntrega + "\n"
                + "Distancia: " + distanciaKm + " kms" + "\n"
                + "Repartidor: " + repartidorAsignado);
    }

    // sobrecarga --- asignación manual del repartidor, común para todas las subclases
    public void asignarRepartidor(String nombre) {
        this.repartidorAsignado = nombre;
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }

    // sobrescritura --- para asignación automática
    public abstract void asignarRepartidor();

    public abstract void calcularTiempoEntrega();

    @Override
    public void despachar() {
        if (cancelado) {
            System.out.println("No se puede despachar el pedido " + idPedido + ", ya fue cancelado.");
            return;
        }
        despachado = true;
        System.out.println("Pedido " + idPedido + " despachado con " + repartidorAsignado + ".");
    }

    @Override
    public void cancelar() {
        if (despachado) {
            System.out.println("No se puede cancelar el pedido " + idPedido + ", ya fue despachado.");
            return;
        }
        cancelado = true;
        System.out.println("Pedido " + idPedido + " cancelado.");
    }
}