import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;



public class PersonLog {
		
		//creates a new ArrayList to store people
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<String> customerEmail = new ArrayList<String>();
		//WritePersonXML writePersonXml = new WritePersonXML();
		XStream xstream = new XStream();
		//Gson gson = new Gson();
		/**
		 * returns the person array List
		 * @return personList
		 */
		public ArrayList<Person> getPersonList()
		{
			return this.personList;
		}
		
		/**
		 * sets the person array List
		 * @param personList
		 */
		public void setPersonList(ArrayList<Person> personList)
		{
			this.personList = personList;
		}
		
		
		/**
		 * checkFile takes the user input string for a file name and checks it if exists 
		 * and is readable.
		 * If it is, it returns true. If not, it returns false.
		 * @param fileName
		 * @return boolean readable or not
		 */
		public boolean checkFile(String fileName)
		{
			File file = new File(fileName);
			if (file.exists() && file.canRead())
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		
		/**
		 * splitPeople reads a file and adds each line of the file into a person
		 * array list
		 * @param fileName
		 * @throws IOException
		 */
		public void splitPerson(String fileName) throws IOException
		{
			
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner personScan = new Scanner(reader);
			
			String line = null;
			while((line = reader.readLine()) != null)//while there is still a line in the file
			{
				//System.out.println(line);
				Person person = parsePerson(line);
				//System.out.println(person.getName());
				personList.add(person);
				//writePersonXml(person);
			}
			writePersonXml(personList);
			//System.out.print(personList);
		}
		public void writePersonXml( ArrayList <Person> person) {
		    System.out.println("save person XML");
		    FileOutputStream fos = null;
		    try{            
		        String xml = xstream.toXML(person);
		        fos = new FileOutputStream("data/Persons.xml");
		        fos.write("<?xml version=\"1.0\"?>".getBytes("UTF-8"));
		        byte[] bytes = xml.getBytes("UTF-8");
		        fos.write(bytes);
		        System.out.println("hi");

		    }catch (Exception e){
		        System.out.println("Error in XML Write: " + e.getMessage());
		    }
		    finally{
		        if(fos != null){
		            try{
		                fos.close();
		            }catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }
		}
		
		
		
		/**
		 * parseVehicle takes a string and splits it into an array by each space
		 * it then sets each element in the array equal to a vehicle data member
		 * @param token
		 * @return Vehicle object 
		 */
		public Person parsePerson(String token)
		{
			String[] array = token.split(";");
			//System.out.println(array[1]);
			String idNumber = array[0];
			String brokerData = array[1];
			String name = array[2];
			Name customerName = parseName(name);
			String address = array[3];
			Address customerAddress = parseAddress(address);
			if (array.length == 5){
				customerEmail = parseEmail(array[4]);
			}
			else{
				customerEmail.add("");
			}
			Person customer = new Person(idNumber, brokerData, customerName, customerAddress, customerEmail);
			return customer;
		}
		
		public Address parseAddress(String address){
			String[] addressArray = address.split(",");
			String street1 = addressArray[0];
			String city = addressArray[1];
			String state = addressArray[2];
			String zip = addressArray[3];
			String country = addressArray[4];
			Address addressObject = new Address(street1, city, state, zip, country);
			return addressObject;
		}
		
		public Name parseName(String name){
			String[] nameArray = name.split(",");
			String firstName = nameArray[0];
			String lastName = nameArray[1];
			Name nameObject = new Name(firstName, lastName);
			return nameObject;
		}
		
		public ArrayList<String> parseEmail(String email){
			//System.out.println(email);
			ArrayList<String> emailList = new ArrayList<String>(Arrays.asList(email.split(",")));
			return emailList;
		}


}