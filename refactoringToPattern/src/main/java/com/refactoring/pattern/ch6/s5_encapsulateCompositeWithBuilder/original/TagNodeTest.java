package com.refactoring.pattern.ch6.s5_encapsulateCompositeWithBuilder.original;

/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class TagNodeTest {
    public void testParents() {
        TagNode root = new TagNode("root");
        assertNull(root.getParent());

        TagNode childNode = new TagNode("child");
        root.add(childNode);
        assertEquals(root, childNode.getParent());
        assertEquals("root", childNode.getParent().getName());
    }

    private void assertEquals(TagNode expect, TagNode actual) {
    }

    private void assertEquals(String expect, String actual) {
    }

    private void assertNull(TagNode parent) {
    }
}
