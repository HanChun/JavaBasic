package Reflect;
class Person{
	private String name;
	private int age;
	public Person(){
		super();
		System.out.println("person run");
	}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	public void show(String name,int age){
		System.out.println("show run... name="+name+"... age = "+age);
	}
	public static void staticshow(){
		System.out.println("static show run");
	}
}



public class Demo01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*Person p1 = new Person();
		Person p2 = new Person();
		
		Class clazz1 = p1.getClass();
		Class clazz2 = p2.getClass();
		
		System.out.println(clazz1==clazz2);*/
		getClass_3();
	}
	
	public static void getClass_1(){
		Person p =new Person();
		Class clazz = p.getClass();
	}
	public static void getClass_2(){
		Class clazz= Person.class;
	}
	
	public static void getClass_3() throws InstantiationException, IllegalAccessException{
		String className = "Reflect.Person";
		try {
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
