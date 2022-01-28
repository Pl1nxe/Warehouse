package ru.vsu.items;

public class Pipe extends Item {

    public Pipe(Integer articleNum, String title, String manufacturer, Integer innerDiameter,
                Integer outerDiameter, String material) {
        super(articleNum, title, manufacturer, null, null, null, material, null,
              innerDiameter, outerDiameter);
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "title='" + title + '\'' +
                ", manufacturer='" + manufacturer + "'}";
    }
}
