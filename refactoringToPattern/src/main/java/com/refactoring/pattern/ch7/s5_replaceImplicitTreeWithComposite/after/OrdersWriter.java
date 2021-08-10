package com.refactoring.pattern.ch7.s5_replaceImplicitTreeWithComposite.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }


    private void writeOrderTo(StringBuffer xml) {
//        xml.append("<orders>");
        TagNode ordersTag = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderTag= new TagNode("order");
            orderTag.addAttribute("id",order.getOrderId());
            writeProductsTo(ordersTag,order);
            ordersTag.add(ordersTag);
//            xml.append("<oder");
//            xml.append(" id='");
//            xml.append(order.getOrderId());
//            xml.append("'>");
//            writeProductsTo(xml,order);
//            xml.append("</order>");
        }
        xml.append(ordersTag.toString());
    }

    private void writeProductsTo(TagNode orderTag, Order order) {
        for (int i = 0; i < order.getProductCount(); i++) {
            Product product = order.getProduct(i);
            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id",product.getId());
            productTag.addAttribute("color",colorFor(product));
            if(product.getSize()!=ProductSize.NOT_APPLICABLE){
                productTag.addAttribute("size",sizeFor(product));
            }
            writePriceTo(productTag,product);
            productTag.addValue(product.getName());
            orderTag.add(productTag);
//            xml.append("<product");
//            xml.append(" id='");
//            xml.append(product.getId());
//            xml.append("'");
//            xml.append(" color='");
//            xml.append(colorFor(product));
//            xml.append("'");
//            if(product.getSize()!= ProductSize.NOT_APPLICABLE){
//                xml.append(" size='");
//                xml.append(sizeFor(product));
//                xml.append("'");
//            }
//            xml.append(">");
//            writePriceTo(xml,product);
//            xml.append(product.getName());
//            xml.append("</product>");

        }
    }

    private void writePriceTo(TagNode productTag, Product product) {
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency",currencyFor(product));
        priceTag.addValue(priceFor(product));
        productTag.add(priceTag);
//        xml.append("<price");
//        xml.append(" currency='");
//        xml.append(currencyFor(product));
//        xml.append("'>");
//        xml.append(product.getPrice());
//        xml.append("</price>");
    }

    private String priceFor(Product product) {
        return null;
    }

    private String currencyFor(Product product) {
        return null;
    }

    private String sizeFor(Product product) {
        return null;
    }

    private String colorFor(Product product) {
        return null;
    }
}
