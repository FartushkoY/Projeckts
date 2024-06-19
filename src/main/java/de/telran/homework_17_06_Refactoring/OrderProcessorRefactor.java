package de.telran.homework_17_06_Refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderProcessorRefactor {
    private List<Order> orders = new ArrayList<>();

    public void processOrder(String customerId, List<String> itemIds, String shippingMethod) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Customer not found");
            return;
        }
        ArrayList<Item> items = itemIds.stream().filter(itemId -> itemId != null)
                .map(itemId -> getItemById(itemId)).collect(Collectors.toCollection(ArrayList::new));

        if (items.isEmpty()) {
            System.out.println("No valid items found for order");
            return;
        }
        double totalAmount = items.stream().mapToDouble(Item::getPrice).sum();
        double shippingCost = getShippingCost(shippingMethod);
        orders.add(getOrder(customer, items, totalAmount, shippingCost, "Processing"));
    }


    public void cancelOrder(long orderId) {

        for (Order order : orders) {
            if (order.getId() == orderId && order != null) {
                orders.remove(order);
                System.out.println("Order canceled: " + orderId);
                break;
            } else {
                System.out.println("Order not found: " + orderId);
            }
        }
    }


    public void printOrderDetails(long orderId) {

        for (Order order : orders) {
            if (order.getId() == orderId && order != null) {
                System.out.println("Order Details: ");
                System.out.println("Customer: " + order.getCustomer().getName());
                System.out.println("Items: ");

                order.getItems().forEach(item -> System.out.println(" - " + item.getName() + ": $" + item.getPrice()));
                //  не уверена, есть ли смысл здесь печатать через стрим
//                for (Item item : order.getItems()) {
//                    System.out.println(" - " + item.getName() + ": $" + item.getPrice());
//                }
                System.out.println("Total Amount: $" + order.getTotalAmount());
                System.out.println("Shipping Cost: $" + order.getShippingCost());
                System.out.println("Status: " + order.getOrderStatus());
                break;
            }
            else {
                System.out.println("Order not found: " + orderId);
            }
        }
    }


    private Customer getCustomerById(String customerId) {
        // Simulated method to get customer by ID
        return new Customer(customerId, "Customer Name");
    }


    private Item getItemById(String itemId) {
        // Simulated method to get item by ID
        return new Item(itemId, "Item Name", Math.random() * 100);
    }


    public double getShippingCost(String shippingMethod) {
        double shippingCost = 0;
        if ("standard".equals(shippingMethod)) {
            shippingCost = 5.99;
        } else if ("express".equals(shippingMethod)) {
            shippingCost = 9.99;
        } else {
            System.out.println("Invalid shipping method");
        }
        return shippingCost;
    }


    public Order getOrder(Customer customer, ArrayList<Item> items, double totalAmount, double shippingCost, String status) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(items);
        order.setTotalAmount(totalAmount);
        order.setShippingCost(shippingCost);
        order.setOrderStatus(status);
        System.out.println("Order processed: " + order.getId());
        return order;
    }
}
