package test.menu;

import java.util.List;

public class MenuCard {
    private String imagePath;
    private String name;
    private List<Menu> list;

    public MenuCard(String imagePath, String name, List<Menu> list) {
        this.imagePath = imagePath;
        this.name = name;
        this.list = list;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }
}
