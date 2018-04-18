 * ARX: Powerful Data Anonymization

package org.deidentifier.arx.examples;

import java.io.File;

public class Example37 extends Example {

    /**
     * Entry point.
     * 
     * @param args
     *            the arguments
     */
    public static void main(String[] args) throws IOException {

        // Define data
        DefaultData data = Data.create();
        /*data.add("age", "gender", "zipcode");
        data.add("34", "male", "81667");
        data.add("45", "female", "81675");
        data.add("66", "male", "81925");
        data.add("70", "female", "81931");
        data.add("34", "female", "81931");
        data.add("70", "male", "81931");
        data.add("45", "male", "81931");*/
        // add the header
        //data.add("sex;age;race;marital_status;education;native_country;workclass;occupation;salary_class");
        try {
        	File subset_file = new File("data/adult_subset.csv");
        	Scanner sc = new Scanner(subset_file);
	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	            String parts[] = line.split(";");
	            data.add(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);            
	            //System.out.println(parts[1]);
	        }
	        sc.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // Define hierarchies
        // AGE
        DefaultHierarchy age = Hierarchy.create();
        try {
        	File age_file = new File("data/adult_hierarchy_age.csv");
        	Scanner sc_hier = new Scanner(age_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            age.add(parts[0], parts[1], parts[2], parts[3], parts[4]);
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // EDUCATION
        DefaultHierarchy education = Hierarchy.create();
        try {
        	File ed_file = new File("data/adult_hierarchy_education.csv");
        	Scanner sc_hier = new Scanner(ed_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            education.add(parts[0], parts[1], parts[2], parts[3]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // MARITAL STATUS
        DefaultHierarchy marital_status = Hierarchy.create();
        try {
        	File mar_file = new File("data/adult_hierarchy_marital-status.csv");
        	Scanner sc_hier = new Scanner(mar_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            marital_status.add(parts[0], parts[1], parts[2]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // NATIVE COUNTRY
        DefaultHierarchy native_country = Hierarchy.create();
        try {
        	File nat_file = new File("data/adult_hierarchy_native-country.csv");
        	Scanner sc_hier = new Scanner(nat_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            native_country.add(parts[0], parts[1], parts[2]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // OCCUPATION
        DefaultHierarchy occupation = Hierarchy.create();
        try {
        	File occ_file = new File("data/adult_hierarchy_occupation.csv");
        	Scanner sc_hier = new Scanner(occ_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            occupation.add(parts[0], parts[1], parts[2]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // RACE
        DefaultHierarchy race = Hierarchy.create();
        try {
        	File race_file = new File("data/adult_hierarchy_race.csv");
        	Scanner sc_hier = new Scanner(race_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            race.add(parts[0], parts[1]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }

        // SALARY CLASS
        DefaultHierarchy salary_class = Hierarchy.create();
        try {
        	File sallary_file = new File("data/adult_hierarchy_salary-class.csv");
        	Scanner sc_hier = new Scanner(sallary_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            salary_class.add(parts[0], parts[1]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // SEX
        DefaultHierarchy sex = Hierarchy.create();
        try {
        	File sex_file = new File("data/adult_hierarchy_sex.csv");
        	Scanner sc_hier = new Scanner(sex_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            sex.add(parts[0], parts[1]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // WORKCLASS
        DefaultHierarchy workclass = Hierarchy.create();
        try {
        	File work_file = new File("data/adult_hierarchy_workclass.csv");
        	Scanner sc_hier = new Scanner(work_file);
	        while (sc_hier.hasNextLine()) {
	            String line = sc_hier.nextLine();
	            String parts[] = line.split(";");
	            workclass.add(parts[0], parts[1], parts[2]);            
	        }
	        sc_hier.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        // Only excerpts for readability
        /*DefaultHierarchy zipcode = Hierarchy.create();
        zipcode.add("81667", "8166*", "816**", "81***", "8****", "*****");
        zipcode.add("81675", "8167*", "816**", "81***", "8****", "*****");
        zipcode.add("81925", "8192*", "819**", "81***", "8****", "*****");
        zipcode.add("81931", "8193*", "819**", "81***", "8****", "*****");*/
        
        // hierarchy - data set attr and hierar
        data.getDefinition().setAttributeType("age", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("education", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("marital-status", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("native-country", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("occupation", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("race", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("salary-class", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("sex", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);
        data.getDefinition().setAttributeType("workclass", AttributeType.QUASI_IDENTIFYING_ATTRIBUTE);

        data.getDefinition().setHierarchy("age", age);
        data.getDefinition().setHierarchy("education", education);
        data.getDefinition().setHierarchy("marital-status", marital_status);
        data.getDefinition().setHierarchy("native-country", native_country);
        data.getDefinition().setHierarchy("occupation", occupation);
        data.getDefinition().setHierarchy("race", race);
        data.getDefinition().setHierarchy("salary-class", salary_class);
        data.getDefinition().setHierarchy("sex", sex);
        data.getDefinition().setHierarchy("workclass", workclass);

        // Create an instance of the anonymizer
        ARXAnonymizer anonymizer = new ARXAnonymizer();

        // Create a differential privacy criterion
        EDDifferentialPrivacy criterion = new EDDifferentialPrivacy(10000d, 30d,
                                                                    DataGeneralizationScheme.create(data,GeneralizationDegree.HIGH));

        ARXConfiguration config = ARXConfiguration.create();
        config.addPrivacyModel(criterion);
        config.setSuppressionLimit(1d);
        ARXResult result = anonymizer.anonymize(data, config);

        // Access output
        DataHandle optimal = result.getOutput();

        System.out.println(result.isResultAvailable());

        // Print input
        System.out.println(" - Input data:");
        printHandle(data.getHandle());

        System.out.println(" - Result:");
        printHandle(optimal);
    }
}

