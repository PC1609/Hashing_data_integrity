//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Map<String, String>> originalData = List.of(
                Map.of("id", "1", "name", "Priyanka", "age", "25"),
                Map.of("id", "2", "name", "Tina", "age", "20"),
                Map.of("id", "3", "name", "Divya", "age", "23")
        );

        List<Map<String, String>> tableData = List.of(
                Map.of("id", "1", "name", "Priyanka", "age", "25"),
                Map.of("id", "2", "name", "Tina", "age", "20"),
                Map.of("id", "3", "name", "Divya", "age", "28")
        );

        /*
        List<String> hashOriginal = HashGenerator.generateHashTables(originalData, "MD5");
        List<String> hashMigratedData = HashGenerator.generateHashTables(tableData, "MD5");
        */

        List<String> hashOriginal = HashGenerator.generateHashTables(originalData, "SHA-256");
        List<String> hashMigratedData = HashGenerator.generateHashTables(tableData, "SHA-256");

        if (hashOriginal.equals(hashMigratedData)){
            System.out.println("Migrated data is consistent");
        }else{
            System.out.println("Migrated data is corrupted");
        }
    }
}