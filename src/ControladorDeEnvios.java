import java.util.ArrayList;

public class ControladorDeEnvios implements Rastreable {
    private ArrayList<Pedido> historialEntregas;

    public ControladorDeEnvios() {
        this.historialEntregas = new ArrayList<>();
    }

    public void registrarEntrega(Pedido pedido) {
        if (pedido.isDespachado()) {
            historialEntregas.add(pedido);
        }
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial de entregas realizadas:");
        if (historialEntregas.isEmpty()) {
            System.out.println("Aún no hay entregas despachadas.");
            return;
        }
        for (Pedido pedido : historialEntregas) {
            System.out.println("- ID: " + pedido.getIdPedido() + " | Repartidor: " + pedido.getRepartidorAsignado());
        }
    }
}