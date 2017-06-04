package xyz.fefine.controller;

import bid.fese.entity.SeResponse;
import xyz.fefine.annotation.JsonData;
import xyz.fefine.annotation.Path;
import xyz.fefine.annotation.RequestParam;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by feng_sh on 17-6-4.
 * 测试controller
 */
public class IndexController {
    @Path("/index")
    public void index(SeResponse response) {
        response.getPrintWriter().write("this is index");
        response.getPrintWriter().flush();
        // must do it
        response.flush();
    }

    @Path("/page/{pn}")
    public void showPage(@RequestParam("pn") int pn, SeResponse response) {
        PrintWriter pw = response.getPrintWriter();
        pw.write("this page is:" + pn);
        pw.write("this is a simple resp");
        pw.flush();
        response.flush();
    }

    @Path("/params/{pk}/{pv}")
    public void showParams(@RequestParam("pv") String pv, @RequestParam("pk") String pk, SeResponse response) {
        PrintWriter pw = response.getPrintWriter();
        pw.write("this key is:" + pk);
        pw.write("this val is:" + pv);
        pw.write("this is a simple resp");
        pw.flush();
        response.flush();
    }


    @Path("/data")
    @JsonData // must use this annotation
    public Map<String, Object> showJsonData() {
        Map<String, Object> md = new Hashtable<>();
        md.put("name", "data");
        md.put("value", 10);
        md.put("name", Arrays.asList(1,2,3));
        Map<String, String> mss = new Hashtable<>();
        mss.put("hehe", "i don't konw");
        mss.put("jim", "i don't konw");
        md.put("friends", mss);
        return md;
    }


    @Path("/data/{dn}")
    @JsonData
    public Map<String, Object> showJsonData2(@RequestParam("dn") int dn) {
        Map<String, Object> md = new Hashtable<>();
        md.put("name", "data");
        md.put("data num", dn);
        md.put("name", Arrays.asList(1,2,3));
        Map<String, String> mss = new Hashtable<>();
        mss.put("hehe", "i don't konw");
        mss.put("jim", "i don't konw");
        md.put("friends", mss);
        return md;
    }

    @Path("/data/{pk}/{pv}")
    @JsonData
    public Map<String, Object> showJsonDataParams(@RequestParam("pv") String pv, @RequestParam("pk") String pk) {
        Map<String, Object> md = new Hashtable<>();
        md.put("pk", pk);
        md.put("pv", pv);
        md.put("name", Arrays.asList(1,2,3));
        Map<String, String> mss = new Hashtable<>();
        mss.put(pk, "i don't konw");
        mss.put(pv, "i don't konw");
        md.put("friends", mss);
        return md;
    }



}
