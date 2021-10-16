

public class main{
    public static void main(String[] args){
        System.out.println("hello world");
        BloomFilterFNV test = new BloomFilterFNV(100, 10);

        System.out.println("numhashes: "  + test.numHashes());
        test.add("test");
    }
}
