package com.refactoring.pattern.ch6.s5_encapsulateCompositeWithBuilder.original;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class TagBuilderTest {
    //假设是Junit Test
    public void testBuildOneNode(){
        String expectedXML = "<flavors/>";
        String actualXML = new TagBuilder("flavors").toXml();
        assertXmlEquals(expectedXML,actualXML);

    }

    public void testBuildOneChild(){
        String expectedXML = "<flavors>" +
                "<flavor/>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        String actualXML = builder.toXml();
        assertXmlEquals(expectedXML,actualXML);
    }
    public void testBuildChildrenOfChildren(){
        String expectedXML = "<flavors>" +
                "<flavor>" +
                "<requirements>" +
                "<requirement/>" +
                "</requirements>" +
                "</flavor>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");
        String actualXML = builder.toXml();
        assertXmlEquals(expectedXML,actualXML);
    }
    public void testBuildSibling(){
        String expectedXML = "<flavors>" +
                "<flavor1/>" +
                "<flavor2/>" +
                "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");
        String actualXML = builder.toXml();
        assertXmlEquals(expectedXML,actualXML);
    }


    private void assertXmlEquals(String expectedXML, String actualXML) {
    }
}
