import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {

    /**
     * Lấy tất cả chữ ký các phương thức static trong file Java.
     *
     * @param fileContent Nội dung file Java cần xử lý
     * @return chứa các chữ ký phương thức static,
     *         định dạng: methodName(paramType1,paramType2,...)
     */
    public static List<String> getAllFunctions(String fileContent) {
        List<String> result = new ArrayList<>();
        Map<String, String> classMap = new HashMap<>();
        String packageName = "";

        fileContent = fileContent.replaceAll("//.*|/\\*(?:.|\\R)*?\\*/", "");

        Matcher pkg = Pattern.compile("package\\s+([\\w\\.]+)\\s*;").matcher(fileContent);
        if (pkg.find()) {
            packageName = pkg.group(1);
        }

        Matcher imp = Pattern.compile("import\\s+([\\w\\.]+)\\s*;").matcher(fileContent);
        while (imp.find()) {
            String fqcn = imp.group(1);
            String simpleName = fqcn.substring(fqcn.lastIndexOf(".") + 1);
            classMap.put(simpleName, fqcn);
        }

        Matcher cls = Pattern.compile("class\\s+(\\w+)").matcher(fileContent);
        while (cls.find()) {
            String clsName = cls.group(1);
            classMap.put(clsName, packageName.isEmpty() ? clsName : packageName + "." + clsName);
        }

        Matcher m = Pattern.compile("(?:public\\s+)?static\\s+"
                + "([\\w\\<\\>\\[\\]\\?\\,\\s]+)\\s+(\\w+)\\s*\\(([^)]*)\\)").matcher(fileContent);
        while (m.find()) {
            String methodName = m.group(2);
            String params = m.group(3).trim();
            if (params.isEmpty()) {
                result.add(methodName + "()");
                continue;
            }

            String[] paramArr = params.split(",");
            List<String> fqParams = new ArrayList<>();
            for (String p : paramArr) {
                p = p.trim();
                if (p.isEmpty()) {
                    continue;
                }

                String[] parts = p.split("\\s+");
                String type = parts[0];

                boolean isArray = type.endsWith("[]");
                if (isArray) {
                    type = type.substring(0, type.length() - 2);
                }

                if (type.contains("<")) {
                    type = processGeneric(type, classMap, packageName);
                } else {
                    type = processType(type, classMap, packageName);
                }

                if (isArray) {
                    type += "[]";
                }
                fqParams.add(type);
            }

            result.add(methodName + "(" + String.join(",", fqParams) + ")");
        }

        return result;
    }

    private static String processType(String type, Map<String,
            String> classMap, String packageName) {
        type = type.trim();
        if (isTypeParameter(type)) {
            return type;
        }

        Set<String> primitives = new HashSet<String>();
        Collections.addAll(primitives, "int", "double", "long", "boolean", "char",
                "byte", "short", "float", "void");
        if (primitives.contains(type)) {
            return type;
        }

        Set<String> javaLangTypes = new HashSet<String>();
        Collections.addAll(javaLangTypes, "String", "Integer", "Long", "Double",
                "Float", "Boolean", "Character", "Byte", "Short", "Object");
        if (javaLangTypes.contains(type)) {
            return "java.lang." + type;
        }

        Map<String, String> defaultTypes = new HashMap<String, String>();
        defaultTypes.put("Iterable", "java.lang.Iterable");
        defaultTypes.put("List", "java.util.List");
        defaultTypes.put("Map", "java.util.Map");
        defaultTypes.put("Set", "java.util.Set");
        defaultTypes.put("Queue", "java.util.Queue");
        defaultTypes.put("Deque", "java.util.Deque");
        if (defaultTypes.containsKey(type)) {
            return defaultTypes.get(type);
        }

        return classMap.getOrDefault(type, packageName.isEmpty() ? type : packageName + "." + type);
    }

    private static boolean isTypeParameter(String type) {
        return type.matches("^[A-Z]$");
    }

    private static String processGeneric(String type, Map<String,
            String> classMap, String packageName) {
        int idx = type.indexOf("<");
        if (idx < 0) {
            return processType(type, classMap, packageName);
        }

        String base = type.substring(0, idx).trim();
        String generic = type.substring(idx + 1, type.length() - 1).trim();

        if (isTypeParameter(base) || base.equals("?")) {
            return base + "<" + generic + ">";
        }

        List<String> partsList = splitGenericParameters(generic);
        List<String> processed = new ArrayList<String>();
        for (String p : partsList) {
            p = p.trim();
            if (p.equals("?") || isTypeParameter(p)) {
                processed.add(p);
            } else if (p.contains("<")) {
                processed.add(processGeneric(p, classMap, packageName));
            } else {
                processed.add(processType(p, classMap, packageName));
            }
        }

        return processType(base, classMap, packageName) + "<" + join(processed, ",") + ">";
    }

    private static List<String> splitGenericParameters(String generic) {
        List<String> parts = new ArrayList<String>();
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : generic.toCharArray()) {
            if (c == '<') {
                level++;
            } else if (c == '>') {
                level--;
            }
            if (c == ',' && level == 0) {
                parts.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            parts.add(sb.toString());
        }
        return parts;
    }

    private static String join(List<String> list, String sep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(sep);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
