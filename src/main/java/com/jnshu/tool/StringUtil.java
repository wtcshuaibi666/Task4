package com.jnshu.tool;

public class StringUtil {
    public static int tool(String token){
        String id=token.substring(0,token.indexOf("/"));

        return Integer.parseInt(id);
    }
}
