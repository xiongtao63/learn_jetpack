package com.xiongtao.jetpack.databinding.java;

import androidx.databinding.ObservableField;

public class Star2 {
    ObservableField<String> name;
    ObservableField<Integer> fans;

    public Star2(ObservableField<String> name, ObservableField<Integer> fans) {
        this.name = name;
        this.fans = fans;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<Integer> getFans() {
        return fans;
    }

    public void setFans(ObservableField<Integer> fans) {
        this.fans = fans;
    }
}
