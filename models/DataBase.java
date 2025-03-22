package crudNoDb.models;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DataBase {
    protected static Set<Products> dbList = new HashSet<>();
    private final File file = new File("crudNoDb/files/DB.txt");

    public DataBase() {
        createFile();
    }

    public void createFile() {
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void saveOnFile() {
        AtomicBoolean append = new AtomicBoolean(false);
        dbList.forEach(p -> {
            try (FileWriter fw = new FileWriter(file, append.get())) {
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(p.toSaveOnFile());
                bw.newLine();
                bw.flush();
                bw.close();
                append.set(true);
            } catch (Exception e) {
                e.getStackTrace();
            }
        });

    }

    public void getFromFile() {
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrayLine = line.split(",");
                DataBase.dbList.add(new Products((
                        Integer.parseInt(arrayLine[0])),
                        arrayLine[1],
                        Double.parseDouble(arrayLine[2]),
                        arrayLine[3]));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
