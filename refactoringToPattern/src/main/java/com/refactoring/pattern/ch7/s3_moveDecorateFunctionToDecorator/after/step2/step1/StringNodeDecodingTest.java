package com.refactoring.pattern.ch7.s3_moveDecorateFunctionToDecorator.after.step2.step1;


/**
 * @author zhangyu201
 * @date 2021/8/6
 */
public class StringNodeDecodingTest {

    public void testDecodingAmpersand(){
        String ENCODED_WORKSHOP_TITLE="The Testing &amp; Refactoring Workshop";
        String DECODED_WORKSHOP_TITLE="The Testing & Refactoring Workshop";
        assertEquals("ampersand in string",DECODED_WORKSHOP_TITLE,parseToObtainDecodedResult(ENCODED_WORKSHOP_TITLE));
    }

    private String parseToObtainDecodedResult(String stringToDecode) {
        StringBuffer decodedContent = new StringBuffer();
        Parser parser =  createParser(stringToDecode);
        NodeIterator nodes = parser.elements();
        while (nodes.hasNext()){
            Node node = (Node) nodes.next();
            if(node instanceof StringNode){
                StringNode stringNode = (StringNode) node;
                decodedContent.append(Translate.decode(stringNode.toString()));
            }
            if(node instanceof Tag){
                decodedContent.append(node.toHtml());
            }
        }
        return decodedContent.toString();
    }

    private Parser createParser(String stringToDecode) {
        return null;
    }

    private void assertEquals(String ampersand_in_string, String DECODED_WORKSHOP_TITLE, String s) {
    }
}
