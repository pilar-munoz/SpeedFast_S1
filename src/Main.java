public class Main {
    public static void main(String[] args) {
        PedidoComida pedido1 = new PedidoComida("A3545", "Calle Ejemplo #123", 2, 20, "Comida", 5);
        PedidoEncomienda pedido2 = new PedidoEncomienda("B3458", "Calle Test #541", 1, 10, "Encomienda", true);
        PedidoExpress pedido3 = new PedidoExpress("C3534", "Calle Demo #454", 3, 30, "Express", true);

        Pedido [] pedidos = {pedido1, pedido2, pedido3};

        // asignación automática repartidor, sobrescritura y cálculo tiempo
        for (Pedido pedido : pedidos) {
            pedido.asignarRepartidor();
            pedido.calcularTiempoEntrega();
            pedido.mostrarResumen();
            System.out.println("=".repeat(20));
        }

        // asignación manual de repartidor (sobrecarga)
        pedido2.asignarRepartidor("Juana Test");
        System.out.println("=".repeat(20));

        // despacho de pedidos
        pedido1.despachar();
        pedido3.despachar();
        System.out.println("=".repeat(20));

        // cancelación de un pedido
        pedido2.cancelar();
        System.out.println("=".repeat(20));

        // historial de entregas realizadas
        ControladorDeEnvios controlador = new ControladorDeEnvios();
        for (Pedido pedido : pedidos) {
            controlador.registrarEntrega(pedido);
        }
        controlador.verHistorial();
    }
}