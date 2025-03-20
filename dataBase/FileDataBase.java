package crudNoDb.dataBase;

import crudNoDb.models.Products;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class FileDataBase extends DataBase {
    File file = new File("crudNoDb/files/DB.txt");

    public FileDataBase() {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void save() {
        AtomicBoolean append = new AtomicBoolean(false);
        DataBase.db.forEach(p -> {
            try (FileWriter fw = new FileWriter(file, append.get())) {
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(p.toDB());
                bw.newLine();
                bw.flush();
                bw.close();
                append.set(true);
            } catch (Exception e) {
                e.getStackTrace();
            }
        });
    }

    public void readAndAddOnDB() {
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arrayLine;
                arrayLine = line.split(",");
                DataBase.db.add(new Products((Integer.parseInt(arrayLine[0])), arrayLine[1], Double.parseDouble(arrayLine[2]), arrayLine[3]));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
