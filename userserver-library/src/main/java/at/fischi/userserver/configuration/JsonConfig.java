package at.fischi.userserver.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Getter
public class JsonConfig<T> {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private T item;

    public JsonConfig(T type) {
        this.item = type;
        this.createAndLoad();
    }

    private void createAndLoad() {
        if(!Files.exists(Path.of(this.getFileName()))) {
            this.saveConfig();
        }

        this.loadConfig();
    }

    private String getFileName() {
        return "configs/" + item.getClass().getSimpleName().toLowerCase() + ".json";
    }

    private JsonConfig<T> loadConfig() {
        try (final FileReader fileReader = new FileReader(this.getFileName())) {
            this.item = (T) GSON.fromJson(JsonParser.parseReader(fileReader).toString(), this.item.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    @SneakyThrows
    public JsonConfig<T> saveConfig() {
        Files.createDirectories(Path.of("configs"));

        try (final FileWriter fileWriter = new FileWriter(this.getFileName())) {
            fileWriter.write(GSON.toJson(this.item));
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return this;
    }

}
