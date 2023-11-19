package edu.hw4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationError {
    private String errors;

    public ValidationError(String errors) {
        this.errors = errors;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public static Set<ValidationError> validateErrors(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.height() < 0) {
            errors.add(new ValidationError("Height can't have negate value"));
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError("Weight can't have negate value"));
        }
        return errors;
    }

    public static String validateErrorsString(Animal animal) {
        List<String> res = new ArrayList<>();
        if (animal.height() < 0) {
            res.add("height");
        }
        if (animal.weight() < 0) {
            res.add("weight");
        }
        return String.join(" ", res);
    }
}
