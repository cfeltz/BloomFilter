import java.math.BigInteger;
import java.util.BitSet;


public class BloomFilterFNV {
    private BitSet filter;
    private double numHashes;
    private int bitsPerElement;

    private BigInteger fnvprime = new BigInteger("109951168211");
    private BigInteger fnvinit = new BigInteger("14695981039346656037");


    private long FNVHash(String s){

        BigInteger hash = fnvinit;

        for(int i = 0; i < s.length() - 1; i++){
            BigInteger sBit = new BigInteger(Long.toString(s.substring(i,i+1).hashCode()));
            hash = hash.xor(sBit);
            hash = (hash.multiply(fnvprime)).remainder(new BigInteger((Long.toString((long)Math.pow(2,64)))));
        }
        return hash.longValue();
    }

    public BloomFilterFNV(){

    } 

    public BloomFilterFNV(int setSize, int bitsPerElement){
        this.bitsPerElement = bitsPerElement;
        filter = new BitSet(setSize * bitsPerElement);
        numHashes = Math.log(2.0) * (filter.size() / setSize);
    }

    public void add(String S){
        FNVHash(S);

    }

    public void appears(String S){

    }

    public int filterSize(){
        return filter.size();
    }

    public int dataSize(){
        return 0;
    }

    public int numHashes(){
        return (int)numHashes;
    }

    public boolean getBit(int j){
        return true;
    }

}
