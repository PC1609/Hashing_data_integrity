import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HashGenerator {
    public static String generateHash(Map<String,String> map,String hashAlgorithm) throws NoSuchAlgorithmException {
        StringBuilder concatenatedString = new StringBuilder();
        for (String value : map.values()){
            concatenatedString.append(value);
        }

        MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
        byte[] hashedByte = md.digest(concatenatedString.toString().getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : hashedByte){
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) sb.append('0');
            sb.append(hex);
        }
        return sb.toString();
    }

    public static List<String> generateHashTables(List<Map<String,String>> list,String hashAlgorithm) {
        List<String> hashedStrings = new ArrayList<>();
        for (Map<String,String> map : list){
            try{
                String hashedString = generateHash(map, hashAlgorithm);
                hashedStrings.add(hashedString);
            }catch (NoSuchAlgorithmException e){
                System.out.println("No such hash algorithm found" + e.getMessage());
            }
        }
        return  hashedStrings;
    }
}
