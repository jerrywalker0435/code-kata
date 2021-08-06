package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2.step2;


/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class StringNodeDecodingTest {

    public void testDecodingAmpersand(){
        String ENCODED_WORKSHOP_TITLE="The Testing &amp; Refactoring Workshop";
        String DECODED_WORKSHOP_TITLE="The Testing & Refactoring Workshop";
        StringBuffer decodedContent = new StringBuffer();
        Parser parser = Parser.createParser(ENCODED_WORKSHOP_TITLE);
        parser.setNodeDecoding(true);
        NodeIterator<Node> nodes = parser.elements();
        while (nodes.hasNext()){
            decodedContent.append(nodes.next().toPlainTextString());
        }
        assertEquals("decoded Content",DECODED_WORKSHOP_TITLE,decodedContent.toString());
    }


    private void assertEquals(String ampersand_in_string, String DECODED_WORKSHOP_TITLE, String s) {
    }
}
