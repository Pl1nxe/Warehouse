package ru.vsu.services.adapters;

import ru.vsu.repository.HandlerOfOrders;
import ru.vsu.repository.Stored;
import ru.vsu.services.builders.OrderFromCLIBuilder;

import java.util.Scanner;

public class OrdersCLIAdapter implements Adapter {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public void add() {
        ru.vsu.order.Order order = OrderFromCLIBuilder.createOrder();
        HandlerOfOrders.getInstance().add(order);

//        db.executeSelect("INSERT INTO existing_order (ref_num, customer_itn) VALUES (" +
//                order.getReferenceNumber() + ", " + order.getCustomer().getITN() + ");");
//        db.executeSelect("INSERT INTO ordered_item (")
    }

    @Override
    public void removeByID() {
        System.out.print("Enter number of order: ");
        Integer num = scn.nextInt();
        HandlerOfOrders.getInstance().removeByID(num);

//        db.executeSelect("DELETE FROM existing_order WHERE ref_num=" + num + ";");
//        db.executeSelect("DELETE FROM ordered_item WHERE order_number=" + num + ";");
    }

    @Override
    public void viewList() {
        System.out.println("Existing orders:");
        for (Stored order : HandlerOfOrders.getInstance().getAll()) {
            System.out.println(order.toString());
        }
    }

//    public void viewDataBase() throws SQLException {
//        List<Customer> applicantsDb = new ArrayList<>();
//        ResultSet rs = db.executeSelect("SELECT * FROM order");
//        while (rs.next()) {
//            final Customer applicant = new Customer(
//                    rs.getInt("itn"),
//                    rs.getString("address")
//            );
//            applicantsDb.add(applicant);
//        }
//        System.out.println("DatBase orders:");
//        for (Stored customer : applicantsDb) {
//            System.out.println(customer.toString());
//        }
//    }


}
