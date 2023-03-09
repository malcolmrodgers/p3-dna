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
    }

    @Override
    public IDnaStrand reverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reverse'");
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
    
}
