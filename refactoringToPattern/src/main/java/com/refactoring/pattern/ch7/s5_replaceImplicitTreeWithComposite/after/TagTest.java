package com.refactoring.pattern.ch7.s5_replaceImplicitTreeWithComposite.after;

/**
 * @author zhangyu201
 * @date 2021/8/10
 */
public class TagTest {
    private static final String SAMPLE_PRICE="8.95";

    public void testSimpleTagWithOneAttributeAndValue(){
        TagNode priceTag = new TagNode("price");
        priceTag.addAttribute("currency","USD");
        priceTag.addValue(SAMPLE_PRICE);
        String expected = "<price currency=" +
                "'" +
                "USD" +
                ">" +
                SAMPLE_PRICE+
                "</price>";
        assertEquals("price xml",expected,priceTag.toString());
    }
    public void testCompositeTagOneChild(){
        TagNode productTag = new TagNode("product");
        productTag.add(new TagNode("price"));
        String expected= "<product>" +
                "<price>" +
                "</price>" +
                "</product>";
        assertEquals("price xml",expected,productTag.toString());
    }
    public void testAddingChildrenAndGrandChildren(){
        String expected= "<orders>" +
                "<order>" +
                "<product>" +
                "</product>" +
                "</order>"+
                "</orders>";
        TagNode ordersTag= new TagNode("orders");
        TagNode orderTag = new TagNode("order");
        TagNode productTag = new TagNode("product");
        ordersTag.add(orderTag);
        orderTag.add(productTag);
        assertEquals("orders xml",expected,ordersTag.toString());
    }

    private void assertEquals(String price_xml, String expected, String toString) {

    }
}
