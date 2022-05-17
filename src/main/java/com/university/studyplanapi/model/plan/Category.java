package com.university.studyplanapi.model.plan;

public enum Category {
    Obligatory_University_Requirements(1),
    Elective_University_Requirements(2),
    Obligatory_Faculty_Requirements(3),
    Obligatory_Specialization_Requirements(4),
    Elective_Specialization_Requirements(5),
    General_Requirements(6);
    private final int categoryValue;

    Category(final int categoryValue) {
        this.categoryValue = categoryValue;
    }

    public int getCategoryValue() {
        return getCategoryValue();
    }
    public static Category getCategoryByNumber(int number){
        Category[] category = Category.values();
        return category[number];
    }
}
