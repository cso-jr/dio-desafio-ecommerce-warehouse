package br.com.dio.warehouse.build;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class TriggerUpdater {
    public static void main(String[] args) {
        Path trigger = Paths.get("src/main/resources/trigger.txt");

        try {
            Files.createDirectories(trigger.getParent());
         //   String timestamp = String.valueOf(new Date().getTime()); --> esse comando pega o valor me milissegundos as partir de uma data em  1970
            String timestamp = new Date().toInstant().toString();
            Files.writeString (trigger, timestamp + System.lineSeparator(),
            		StandardOpenOption.CREATE,
            		StandardOpenOption.APPEND);
            System.out.println("trigger.txt atualizado com timestamp: " + timestamp);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar ou atualizar trigger.txt", e);
        }
    }
}
