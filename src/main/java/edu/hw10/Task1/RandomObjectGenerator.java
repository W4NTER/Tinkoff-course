package edu.hw10.Task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class RandomObjectGenerator {
    private final static Logger LOGGER = LogManager.getLogger();
    private Random random = new Random();

    public RandomObjectGenerator() {
    }

    public <T> T nextObject(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance;

            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    public <T> T nextObject(Class<T> clazz, String factoryMethod) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();

            Method method = null;
            if (factoryMethod != null && !factoryMethod.isEmpty()) {
                method = getMostWideFactoryMethodOverload(clazz, factoryMethod);
                method.setAccessible(true);
            }

            Field[] fields = clazz.getDeclaredFields();
            System.out.println(Arrays.toString(fields));
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNullAnnot.class)) {
                    field.set(instance, nextNotNullValue(field.getType()));
                } else if (field.isAnnotationPresent(MinValue.class)) {
                    long minValue = field.getAnnotation(MinValue.class).value();
                    field.set(instance, nextValueWithinRange(field.getType(), minValue, Long.MAX_VALUE));
                } else if (field.isAnnotationPresent(MaxValue.class)) {
                    long maxValue = field.getAnnotation(MaxValue.class).value();
                    field.set(instance, nextValueWithinRange(field.getType(), Long.MIN_VALUE, maxValue));
                } else {
                    field.set(instance, nextSimpleValue(field.getType()));
                }
            }
            if (method != null) {
                return (T) method.invoke(instance);
            }
            return instance;
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        return null;
    }

    private Object nextSimpleValue(Class<?> type) {
        if (type == int.class || type == Integer.class) {
            return random.nextInt();
        } else if (type == long.class || type == Long.class) {
            return random.nextLong();
        } else if (type == double.class || type == Double.class) {
            return random.nextDouble();
        } else if (type == float.class || type == Float.class) {
            return random.nextFloat();
        } else if (type == boolean.class || type == Boolean.class) {
            return random.nextBoolean();
        } else if (type == String.class) {
            return UUID.randomUUID().toString();
        }
        return null;
    }

    private Object nextNotNullValue(Class<?> type) {
        if (type == int.class || type == long.class || type == double.class ||
            type == float.class || type == boolean.class) {
            return nextSimpleValue(type);
        } else if (type == Integer.class || type == Long.class || type == Double.class ||
            type == Float.class || type == Boolean.class || type == String.class) {
            return nextSimpleValue(type);
        }
        return null;
    }

    private Object nextValueWithinRange(Class<?> type, long minValue, long maxValue) {
        if (type == int.class || type == Integer.class) {
            return random.nextLong(maxValue - minValue + 1) + minValue;
        }
        return null;
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
}
