# FeSe-Rest
### A simple web server 
### Use Java AsynchronousSocketChannel And Restful 
refer：[nio-httpserver](https://github.com/shenedu/nio-httpserver)
 , [easy-httpserver](https://github.com/NotBadPad/easy-httpserver)
  and [RESTServlet](https://github.con/fefine/RESTServlet)
 
 #### Feature：
 * Asynchronous
 * Request method (GET, POST)
 * Customize dynamic request handler
 * Restful API
 * Method parameter dependent injection
 * Annotation
 * JSON response
 * ...
 #### Configure:
 In server.properties
````
#main dispatcher request handler
dynamic_request_handler=xyz.fefine.MainDispatcherHandler
#rest configure file
rest_config_file=rest.xml
````
 In rest.xml
````
 <main>
     <packages>
         <!--controller packages, support multi packages-->
         <package>xyz.fefine.controller</package>
     </packages>
     <!--interceptor class path, only support one-->
     <interceptor class="xyz.fefine.controller.MyInterceptor" />
 </main>
 ````
  #### Sample:
 ~~~~
 // ----------controller sample------------
     // default request method is get
     @Path("/index")
     public void index(SeResponse response) {
         response.getPrintWriter().write("this is index");
         response.getPrintWriter().flush();
         // must do it
         response.flush();
     }
 
     @Path("/page/{pn}")
     public void showPage(@PathParam("pn") int pn, SeResponse response) {
         PrintWriter pw = response.getPrintWriter();
         pw.write("this page is:" + pn);
         pw.write("this is a simple resp");
         pw.flush();
         // must do it
         response.flush();
     }
 
     @Path("/params/{pk}/{pv}")
     public void showParams(@PathParam("pv") String pv, @PathParam("pk") String pk, SeResponse response) {
         PrintWriter pw = response.getPrintWriter();
         pw.write("this key is:" + pk);
         pw.write("this val is:" + pv);
         pw.write("this is a simple resp");
         pw.flush();
         // must do it
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
     public Map<String, Object> showJsonData2(@PathParam("dn") int dn) {
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
     // post request
     @Path(value = "/data/{pk}/{pv}", method = "post")
     @JsonData
     public Map<String, Object> showJsonDataParams(@PathParam("pv") String pv, @PathParam("pk") String pk) {
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
 // ----------interceptor sample------------
 public class MyInterceptor implements Interceptor {
 
     private static final Logger logger = LogManager.getLogger(MyInterceptor.class);
 
     @Override
     public void before(SeRequest request, SeResponse response, Method method, Object[] args) {
         logger.info("before request");
     }
 
     @Override
     public void after(SeRequest request, SeResponse response, Method method, Object[] args) {
         logger.info("after request");
     }
 
     @Override
     public void afterThrowing(SeRequest request, SeResponse response, Method method, Object[] args, Throwable throwable) {
         logger.info("after throwing");
     }
 
     @Override
     public void afterFinally(SeRequest request, SeResponse response, Method method, Object[] args) {
         logger.info("after finally");
     }
 }

 ~~~~
  
  #### Install
 * Maven