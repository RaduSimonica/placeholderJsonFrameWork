package ro.crownstudio.engine.logging;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Assert {

    public static void assertTrue(boolean condition, String message) {
        try {
            org.testng.Assert.assertTrue(condition, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertFalse(boolean condition, String message) {
        try {
            org.testng.Assert.assertFalse(condition, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void fail(String message, Throwable realCause) {
        try {
            org.testng.Assert.fail(message, realCause);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void fail(String message) {
        try {
            org.testng.Assert.fail(message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(byte[] actual, byte[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(short[] actual, short[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(int[] actual, int[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(boolean[] actual, boolean[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(char[] actual, char[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(float[] actual, float[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(float[] actual, float[] expected, float delta, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, delta, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(double[] actual, double[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(double[] actual, double[] expected, double delta, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, delta, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(long[] actual, long[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(String actual, String expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(double actual, double expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Double actual, double expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(double actual, Double expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Double actual, Double expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(float actual, float expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(float actual, float expected, float delta, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, delta, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Float actual, float expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(float actual, Float expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Float actual, Float expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(long actual, long expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Long actual, long expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Long actual, Long expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(boolean actual, boolean expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Boolean actual, boolean expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(boolean actual, Boolean expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Boolean actual, Boolean expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(byte actual, byte expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Byte actual, byte expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(byte actual, Byte expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Byte actual, Byte expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(char actual, char expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Character actual, char expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(char actual, Character expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Character actual, Character expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(short actual, short expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Short actual, short expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(short actual, Short expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Short actual, Short expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(int actual, int expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Integer actual, int expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(int actual, Integer expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotNull(Object object, String message) {
        try {
            org.testng.Assert.assertNotNull(object, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNull(Object object, String message) {
        try {
            org.testng.Assert.assertNull(object, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertSame(Object actual, Object expected, String message) {
        try {
            org.testng.Assert.assertSame(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotSame(Object actual, Object expected, String message) {
        try {
            org.testng.Assert.assertNotSame(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Collection<?> actual, Collection<?> expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Iterator<?> actual, Iterator<?> expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Iterable<?> actual, Iterable<?> expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Object[] actual, Object[] expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEqualsNoOrder(Object[] actual, Object[] expected, String message) {
        try {
            org.testng.Assert.assertEqualsNoOrder(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEqualsNoOrder(Collection<?> actual, Collection<?> expected, String message) {
        try {
            org.testng.Assert.assertEqualsNoOrder(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEqualsNoOrder(Iterator<?> actual, Iterator<?> expected, String message) {
        try {
            org.testng.Assert.assertEqualsNoOrder(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Set<?> actual, Set<?> expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEqualsDeep(Set<?> actual, Set<?> expected, String message) {
        try {
            org.testng.Assert.assertEqualsDeep(actual, expected, formatFailed(formatFailed(message)));
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEquals(Map<?, ?> actual, Map<?, ?> expected, String message) {
        try {
            org.testng.Assert.assertEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertEqualsDeep(Map<?, ?> actual, Map<?, ?> expected, String message) {
        try {
            org.testng.Assert.assertEqualsDeep(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(Object actual, Object expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(Object[] actual, Object[] expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(Iterator<?> actual, Iterator<?> expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(Collection<?> actual, Collection<?> expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(String actual, String expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(long actual, long expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(boolean actual, boolean expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(byte actual, byte expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(char actual, char expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(short actual, short expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(int actual, int expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(float actual, float expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(double actual, double expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(Set<?> actual, Set<?> expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEqualsDeep(Set<?> actual, Set<?> expected, String message) {
        try {
            org.testng.Assert.assertNotEqualsDeep(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(Map<?, ?> actual, Map<?, ?> expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEqualsDeep(Map<?, ?> actual, Map<?, ?> expected, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static void assertNotEquals(double actual, double expected, double delta, String message) {
        try {
            org.testng.Assert.assertNotEquals(actual, expected, delta, message);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static <T extends Throwable> void assertThrows(String message, Class<T> throwableClass, org.testng.Assert.ThrowingRunnable runnable) {
        try {
            org.testng.Assert.assertThrows(message, throwableClass, runnable);
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
        Logger.pass(formatPassed(message));
    }

    public static <T extends Throwable> T expectThrows(String message, Class<T> throwableClass, org.testng.Assert.ThrowingRunnable runnable) {
        try {
            T result = expectThrows(message, throwableClass, runnable);
            Logger.pass(formatPassed(message));
            return result;
        } catch (AssertionError e) {
            Logger.fail(formatFailed(message));
            throw e;
        }
    }

    private static String formatPassed(String message) {
        return "PASSED -> " + message;
    }

    private static String formatFailed(String message) {
        return "FAILED -> " + message;
    }
}
