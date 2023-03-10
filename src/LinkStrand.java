public class LinkStrand implements IDnaStrand {
    private class Node {
        String info;
        Node next;

        Node (String s) {
            info = s;
        }

        Node(String s, Node n) {
            info = s;
            next = n;
        }
    }

    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;    
    private Node myCurrent;
    private int myLocalIndex;

    public LinkStrand() {
        this("");
    }
    
    public LinkStrand (String s) {
        initialize(s);
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        myIndex = 0;
        myCurrent = myFirst;
        myLocalIndex = 0;
        mySize = source.length();
        myFirst = new Node(source, null);
        myAppends = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
       return new LinkStrand(source); 
    }

    @Override
    public IDnaStrand append(String dna) {
        if (myFirst.next == null) {
            myFirst.next = new Node(dna, null);
            myLast = myFirst.next;
        }
        else {
            myLast.next = new Node(dna, null);
            myLast = myLast.next;
        }

        mySize += dna.length();
        myAppends += 1;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
    
    Node current = this.myFirst;
    StringBuilder first = new StringBuilder(current.info);
    first.reverse();

    LinkStrand rev = new LinkStrand(first.toString());
    current = current.next;

    While (current != null) {
        StringBuilder myNodeString = new StringBuilder(current.info);
        myNodeString.reverse();

        Node newNode = new Node(current.toString());

        rev.mySize += newNode.info.length();
        newNode.next = rev.myFirst;
        rev.myFirst = newNode;
    }

    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'charAt'");
    }

    public String toString () {
        Node current = this.myFirst;
        StringBuilder sb = new StringBuilder();

        while (current.next != null) {
            sb.append(current.info);
            current = current.next;
        }
        return sb.toString();

    }
    
}
