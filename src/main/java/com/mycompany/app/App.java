package com.mycompany.app;
import java.util.ArrayList;
/**
 * Hello world!
 *
 */
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App 
{
 public static boolean search(ArrayList<Integer> array, int e) {
        System.out.println("inside search");
        if (array == null) return false;
  
        for (int elt : array) {
          if (elt == e) return true;
        }
        return false;
      }
	public static boolean search2(ArrayList<Integer> array1,ArrayList<Integer> array2, int e, int d) { //iki adet array alıp kontrol işlemleri yapar!
        System.out.println("inside search");
        if (array1 == null && array2==null) return false;

   /*     for (int elt : array1) {		
		for(int alt : array2){
			//if(array1.get(elt)==array2.get(alt)){
			if(elt==alt) {
			return true;
			}
        }//end for
    }//end for*/

	for(int i=0; i<array1.size(); i++){  			//iki array e ayrı ayrı bakar, ortak eleman varsa true yoksa false döner!
		if(array2.contains(array1.get(i))){
			return true;
		}//end if
		
	}//end for
	
	if(array1.size()==e && array2.size()==d){ 	//array1 uzunlugu e ye ,  array2 uzunlugu d ye esitse true döner!
				 return true;
		}
	if(array1.size()!=e){	//array1 uzunlugu e ye eşit değilse false döner!
		return false;
	}
        return false;
      }

    public static void main( String[] args )
    {
         port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
		
	 String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
	
	
	String input3 = req.queryParams("input3");
          java.util.Scanner sc2 = new java.util.Scanner(input3);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value1 = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList1.add(value1);
          }

          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
	
	String input4 = req.queryParams("input4").replaceAll("\\s","");
          int input4AsInt = Integer.parseInt(input4);

          boolean result = App.search2(inputList, inputList1 ,input2AsInt ,input4AsInt );

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}


    

