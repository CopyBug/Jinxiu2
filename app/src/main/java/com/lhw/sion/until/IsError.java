package com.lhw.sion.until;



@SuppressWarnings("all")
public class IsError {
    public static boolean isNullError( Object... objects)   {
        for (Object parm : objects) {
            if (parm == null) {
  return true;
            }
            if (parm instanceof String) {
                String parameter = (String) parm;
                if ("".equals(parameter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
