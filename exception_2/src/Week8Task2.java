import java.io.FileNotFoundException;
import java.io.IOException;

public class Week8Task2 {
    public void nullPointerEx() throws NullPointerException {
        throw new NullPointerException("Lỗi Null Pointer");
    }

    /**
     * Kiểm tra phương thức nullPointerEx và trả về thông báo lỗi nếu có.
     *
     * @return Thông báo lỗi của NullPointerException nếu xảy ra.
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return e.getMessage();
        }
        return notError();
    }

    public void arrayIndexOutOfBoundsEx() {
        throw new ArrayIndexOutOfBoundsException("Lỗi Array Index Out of Bounds");
    }

    /**
     * Kiểm tra phương thức arrayIndexOutOfBoundsEx và trả về thông báo lỗi nếu có.
     *
     * @return Thông báo lỗi của ArrayIndexOutOfBoundsException nếu xảy ra.
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return e.getMessage();
        }
        return notError();
    }

    public void arithmeticEx() {
        throw new ArithmeticException("Lỗi Arithmetic");
    }

    /**
     * Kiểm tra phương thức arithmeticEx và trả về thông báo lỗi nếu có.
     *
     * @return Thông báo lỗi của ArithmeticException nếu xảy ra.
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
        return notError();
    }

    public void fileNotFoundEx() throws FileNotFoundException {
        throw new FileNotFoundException("Lỗi File Not Found");
    }

    /**
     * Kiểm tra phương thức fileNotFoundEx và trả về thông báo lỗi nếu có.
     *
     * @return Thông báo lỗi của FileNotFoundException nếu xảy ra.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        return notError();
    }

    public void ioEx() throws IOException {
        throw new IOException("Lỗi IO");
    }

    /**
     * Kiểm tra phương thức ioEx và trả về thông báo lỗi nếu có.
     *
     * @return Thông báo lỗi của IOException nếu xảy ra.
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return e.getMessage();
        }
        return notError();
    }

    private String notError() {
        return "Không có lỗi";
    }

}
