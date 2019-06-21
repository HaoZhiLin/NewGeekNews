package max.jy.hzl.newgeeknews.mokuai.gold;

import java.io.Serializable;

public class TypeBean implements Serializable {
    private String name;
    private boolean type;

    public TypeBean(String name, Boolean type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
