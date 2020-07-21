# 


####题1：
有两个单向链表（链表长度分别为m，n），这两个单向链表有可能在某个元素合并，
如下图所示的这样，也可能不合并。现在给定两个链表的头指针，在不修改链表的情况
下，如何快速地判断这两个链表是否合并？如果合并，找到合并的元素，也就是图中的 
x 元素。
请用（伪）代码描述算法，并给出时间复杂度和空间复杂度。
 解题：时间复杂度：O(m+n),空间复杂度O(m+n)
 
   public static Integer findMergeNode(Node nodeOne, Node nodeTwo) {
        Node node2 = nodeTwo;
        Node node1 = nodeOne;
        Stack<Node> nodeStack1 = new Stack<>(), nodeStack2 = new Stack<>();
        while (node2 != null || node1 != null) {
            if (node1 != null) {
                nodeStack1.push(node1);
                node1 = node1.next;
            }
            if (node2 != null) {
                nodeStack2.push(node2);
                node2 = node2.next;
            }
        }
        Node resultNode = null;
        while (nodeStack1 != null && nodeStack2 != null) {
            Node nodeTemp1 = nodeStack1.pop();
            Node nodeTemp2 = nodeStack2.pop();
            if (!nodeTemp1.data.equals(nodeTemp2.data)) {
                break;
            }
            resultNode = nodeTemp1;
        }
        if (resultNode == null) {
            return null;
        }
        return resultNode.data;
    }
	
