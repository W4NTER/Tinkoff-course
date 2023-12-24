package edu.hw10.Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Random;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RandomObjectGenerator {
    private final static Logger LOGGER = LogManager.getLogger();
    private Random random = new Random();

    public RandomObjectGenerator() {
    }

    public <T> T nextObject(Class<T> clazz) {
        try {
            Constructor<?> constructor = getConstructor(clazz);
            constructor.setAccessible(true);

            var params = getArgsForParams(constructor.getParameters());
            return (T) constructor.newInstance(params);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    private Constructor<?> getConstructor(Class<?> clazz) {
        final var constructors = clazz.getConstructors();
        Constructor<?> result = null;

        for (var constr : constructors) {
            if (result == null) {
                result = constr;
            } else if (constr.getParameters().length > result.getParameters().length) {
                result = constr;
            }
        }
        return result;
    }

    public <T> T nextObject(Class<T> clazz, String factoryMethod) {
        try {
            Method method = null;
            if (factoryMethod != null && !factoryMethod.isEmpty()) {
                method = getMostWideFactoryMethodOverload(clazz, factoryMethod);
                method.setAccessible(true);
            }
            var param = getArgsForParams(method.getParameters());
            return (T) method.invoke(null, param);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    private Object nextSimpleValue(Class<?> type) {
        Object result = null;
        if (type == int.class || type == Integer.class) {
            result = random.nextInt();
        } else if (type == long.class || type == Long.class) {
            result = random.nextLong();
        } else if (type == double.class || type == Double.class) {
            result = random.nextDouble();
        } else if (type == float.class || type == Float.class) {
            result = random.nextFloat();
        } else if (type == boolean.class || type == Boolean.class) {
            result = random.nextBoolean();
        } else if (type == String.class) {
            result = UUID.randomUUID().toString();
        }
        return result;
    }

    @Nullable private static <T> Method getMostWideFactoryMethodOverload(Class<T> clazz, String factoryMethodName) {
        Method factoryMethod = null;
        for (Method method : clazz.getMethods()) {
            if (method.getName().equals(factoryMethodName) && Modifier.isStatic(method.getModifiers())) {
                if (factoryMethod == null) {
                    factoryMethod = method;
                } else if (method.getParameters().length > factoryMethod.getParameters().length) {
                    factoryMethod = method;
                }
            }
        }
        return factoryMethod;
    }

    @NotNull private Object[] getArgsForParams(Parameter[] parameters) {
        Object[] args = new Object[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            NewValueWithinRange newValueWithinRange = null;
            args[i] = newValueWithinRange.value(parameters[i], random);
        }
        return args;
    }
}
