
class MedicalStuff{}

class Doctor extends MedicalStuff{}

class Nurse extends MedicalStuff{}

class HeadDoctor extends Doctor{}

|                                                   |correct  |   not   correct      |           description           |
|--------------------------------------------------:|--------:|-------------------- :|--------------------------------:|
|Doctor doctor1 = new Doctor();                     |   [x]   |                      |                                 |
|Doctor doctor2 = new MedicalStuff();               |         |         [x]          |  Polymorphism error             |         
|Doctor doctor3 = new HeadDoctor();                 |   [x]   |                      |                                 |
|Object object1 = new HeadDoctor();                 |   [x]   |                      |                                 |
|HeadDoctor doctor4 = new Object();                 |         |         [x]          |  Polymorphism error             |
|Doctor doctor5 = new Nurse();                      |         |         [x]          |                                 | 
|Nurse nurse1 = new Doctor();                       |   [x]   |                      | This classes have no relations. | 
|Object object2 = new Nurse();                      |   [x]   |                      |                                 |
|                                                   |         |                      |                                 |
|List<Doctor> list1 = new ArrayList<Doctor>();      |   [x]   |                      |                                 |
|List<MedicalStuff> list2 = new ArrayList<Doctor>();|         |         [x]          |Generics don't have polymorphism |
|                                                   |         |                      |properties.
|                                                   |         |                      |
|List<Doctor> list3 = new ArrayList<Doctor>();      |   [x]   |                      |
|List<Object> list4 = new ArrayList<Doctor>();      |         |         [x]          |Generics don't have polymorphism |
|                                                   |         |                      |properties. 
|List<Object> list5 = new ArrayList<Object>();      |   [x]   |                      |