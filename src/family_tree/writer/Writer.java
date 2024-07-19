package family_tree.writer;

import java.io.Serializable;

public interface Writer {
    /**
     * Сохранение объекта в файл
     * @param serializable Объект
     */
    void save(Serializable serializable);

    /**
     * Чтение объекта из файла
     * @return Объект
     */
    Object read();

    /**
     * Задать путь к файлу
     * @param path Путь к файлу
     */
    void  SetPath(String path);
}