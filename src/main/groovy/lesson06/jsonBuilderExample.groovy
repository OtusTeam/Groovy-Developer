//package lesson06
//
//class Node {
//    String value
//    boolean isRoot
//    boolean isArray
//
//    def String toString() {
//        value
//    }
//}
//
//class JsonBuilder extends BuilderSupport {
//    StringBuilder out = new StringBuilder("{\n")
//
//    @Override
//    protected void setParent(Object parent, Object child) {
//
//    }
//
//    @Override
//    protected Object createNode(Object name) {
//        return createNode(name, null, null)
//    }
//
//    @Override
//    protected Object createNode(Object name, Object value) {
//        return null
//    }
//
//    @Override
//    protected Object createNode(Object name, Map attributes) {
//        return null
//    }
//
//    @Override
//    protected Object createNode(Object name, Map attributes, Object value) {
//        def node = new Node()
//        if (!current) {
//            node.isRoot = true
//        }
//        else {
//            if (value!=null && attributes != null)  {
//
//            }
//            else if (value!=null) {
//                out << """
//"$name": "$value",\n
//                """
//            } else {
//                node.isArray = true
//                out << << """
//"$name": [\n
//                """
//            }
//        }
//        node.value = name
//        return node
//    }
//
//    @Override
//    protected void nodeCompleted(Node parent, Node node) {
//        if (node.isArray) {
//            out.deleteCharAt(out.lastIndexOf(','))
//            out << "],\n"
//        }
//        if (node.isRoot) {
//            out.deleteCharAt(out.lastIndexOf(','))
//            out << "}\n"
//        }
//    }
//}
