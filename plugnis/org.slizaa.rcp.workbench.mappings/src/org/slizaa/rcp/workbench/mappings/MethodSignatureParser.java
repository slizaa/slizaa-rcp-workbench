package org.slizaa.rcp.workbench.mappings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodSignatureParser {

  public static final String pattern = "([^\\s]+) ([^\\s]+)(\\(([^\\s]*)\\))";
  
  private Pattern r = Pattern.compile(pattern);
  
  public String parse( String line) {

    // Now create matcher object.
    Matcher m = r.matcher(line);
    if (m.find()) {
      
      String returnType = simpleName(m.group(1));
      String name = simpleName(m.group(2));

      //
      StringBuilder builder = new StringBuilder();
      String[] arguments = split(m.group(4));
      for (int i = 0; i < arguments.length; i++) {
        builder.append(simpleName(arguments[i]));
        if (i+1 < arguments.length) {
          builder.append(", ");
        }
      }
      
      return name + "(" + builder.toString() + "): " + returnType;
    } else {
      return line;
    }
  }

  private static String[] split(String names) {

    //
    if (names == null) {
      return new String[0];
    }

    //
    names = names.trim();

    //
    if (names.length() == 0) {
      return new String[0];
    }

    //
    return names.split(",");
  }

  /**
   * <p>
   * </p>
   *
   * @param name
   * @return
   */
  private static String simpleName(String name) {

    //
    if (name == null) {
      return name;
    }

    //
    int lastIndex = name.lastIndexOf('.');
    if (lastIndex != -1) {
      return name.substring(lastIndex + 1, name.length());
    }

    //
    return name;
  }
}