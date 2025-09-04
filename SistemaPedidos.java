enum OrderStatus {
    NEW("Pedido creado"),
    PROCESSING("Pedido en proceso"),
    SHIPPED("Pedido enviado"),
    DELIVERED("Pedido entregado"),
    CANCELLED("Pedido cancelado");

    private String message;

    OrderStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

enum OrderPriority {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int level;

    OrderPriority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

enum PaymentMethod {
    CASH("Efectivo"),
    CARD("Tarjeta de crédito/débito"),
    TRANSFER("Transferencia bancaria");

    private String description;

    PaymentMethod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class Order {
    private int id;
    private String customer;
    private OrderStatus status;
    private OrderPriority priority;
    private PaymentMethod paymentMethod;

    public Order(int id, String customer, OrderStatus status, OrderPriority priority, PaymentMethod paymentMethod) {
        this.id = id;
        this.customer = customer;
        this.status = status;
        this.priority = priority;
        this.paymentMethod = paymentMethod;
    }

    public void showDetails() {
        System.out.println("Pedido #" + id);
        System.out.println("Cliente: " + customer);
        System.out.println("Estado: " + status + " → " + status.getMessage());
        System.out.println("Prioridad: " + priority + " (Nivel " + priority.getLevel() + ")");
        System.out.println("Método de pago: " + paymentMethod + " → " + paymentMethod.getDescription());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Order pedido1 = new Order(1, "Ana", OrderStatus.NEW, OrderPriority.HIGH, PaymentMethod.CARD);
        Order pedido2 = new Order(2, "Luis", OrderStatus.SHIPPED, OrderPriority.MEDIUM, PaymentMethod.CASH);
        Order pedido3 = new Order(3, "Marta", OrderStatus.DELIVERED, OrderPriority.LOW, PaymentMethod.TRANSFER);

        pedido1.showDetails();
        pedido2.showDetails();
        pedido3.showDetails();
    }
}
