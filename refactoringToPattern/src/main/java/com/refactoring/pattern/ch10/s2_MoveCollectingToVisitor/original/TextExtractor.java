package com.refactoring.pattern.ch10.s2_MoveCollectingToVisitor.original;


/**
 * Move Collecting To Visitor : 将聚集操作搬移到Visitor
 * 	概要
 * 		一个方法从不同的类中聚集信息
 * 		把聚集工作搬移到一个能够访问每个类以便聚集信息的Visitor
 * 	优点
 * 		调节多个算法，使其适用于不同的对象结构
 * 		访问相同或不同的继承结构中的类
 * 		调用不同类上的类型特定方法，无需类型转换
 * 	缺点
 * 		当可以使用通用接口把互不相同的类转变成相似的类时候，会增加代码复杂度
 * 		新的可访问的类需要接收新的方法，每个Visitor中需要实现新的新的访问方法
 * 		可能会破坏被访问类的封装性
 */
public class TextExtractor {
    private Parser parser;
    private boolean isPreTag;
    private boolean isScriptTag;
    private StringBuffer results;

    public String extractText() throws ParserException{
        Node node;
        isPreTag = false;
        isScriptTag = false;
        results = new StringBuffer();
        parser.flushScanners();
        parser.registerScanners();
        for (NodeIterator e=parser.elements();e.hasNext();){
            node = (Node) e.next();
            if(node instanceof StringNode){
                if(!isScriptTag){
                    StringNode stringNode = (StringNode) node;
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
            }else if(node instanceof LinkTag){
                LinkTag link = (LinkTag) node;
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
            }else if(node instanceof EndTag){
                EndTag endTag = (EndTag) node;
                String tagName=endTag.getName();
                if(tagName.equalsIgnoreCase("PRE")){
                    isPreTag =false;
                }else if(tagName.equalsIgnoreCase("SCRIPT")){
                    isScriptTag =false;
                }
            }else if(node instanceof Tag){
                Tag tag = (Tag) node;
                String tagName = tag.getName();
                if(tagName.equalsIgnoreCase("PRE")){
                    isPreTag = true;
                }else if(tagName.equalsIgnoreCase("SCRIPT")){
                    isScriptTag = true;
                }
            }
        }
        return results.toString();
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
