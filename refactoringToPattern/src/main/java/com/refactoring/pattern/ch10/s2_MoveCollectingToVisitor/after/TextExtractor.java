package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.after;


/**
 * @author zhangyu201
 * @date 2021/8/12
 */
public class TextExtractor implements NodeVisitor {
    private Parser parser;
    private boolean isPreTag;
    private boolean isScriptTag;
    private StringBuffer results;

    public String extractText() throws ParserException {
        Node node;
        isPreTag = false;
        isScriptTag = false;
        results = new StringBuffer();
        parser.flushScanners();
        parser.registerScanners();
        for (NodeIterator e = parser.elements(); e.hasNext();){
            node = (Node) e.next();
            node.accept(this);
        }
        return results.toString();
    }

    @Override
    public void visitTag(Tag tag) {
        String tagName = tag.getName();
        if(tagName.equalsIgnoreCase("PRE")){
            isPreTag = true;
        }else if(tagName.equalsIgnoreCase("SCRIPT")){
            isScriptTag = true;
        }
    }

    @Override
    public void visitEndTag(EndTag endTag) {
        String tagName=endTag.getName();
        if(tagName.equalsIgnoreCase("PRE")){
            isPreTag =false;
        }else if(tagName.equalsIgnoreCase("SCRIPT")){
            isScriptTag =false;
        }
    }

    @Override
    public void visitLink(LinkTag link) {
        if(isPreTag){
            results.append(link.getLinkText());
        }else {
            collapse(results,Translate.decode(link.getLinkText()));
        }
        if(getLinks()){
            results.append("<");
            results.append(link.getLink());
            results.append(">");
        }
    }

    @Override
    public void visitStringNode(StringNode stringNode) {
        if(!isScriptTag){
            if(isPreTag){
                results.append(stringNode.getText());
            }else {
                String text = Translate.decode(stringNode.getText());
                if(getReplaceNonBreakingSpace()){
                   text = text.replace('\u00a0',' ');
                }
                if(getCollapse()){
                    collapse(results,text);
                }else {
                    results.append(text);
                }
            }
        }
    }

    private boolean getLinks() {
        return false;
    }

    private void collapse(StringBuffer results, String text) {

    }

    private boolean getCollapse() {
        return false;
    }

    private boolean getReplaceNonBreakingSpace() {
        return false;
    }
}
